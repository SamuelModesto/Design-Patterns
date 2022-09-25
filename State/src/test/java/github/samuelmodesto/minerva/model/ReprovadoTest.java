package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.exceptions.BusinessException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ReprovadoTest {

    @Test
    public void verificaSeOPedidoReprovadoTemValorDescontoZero() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Reprovado reprovado = new Reprovado();
        BigDecimal valorDesconto = reprovado.calcularDesconto(pedido);
        assertEquals(valorDesconto, BigDecimal.ZERO);
    }

    @Test
    public void pedidoReprovadoNaoDeveSerAprovado() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Reprovado pedidoReprovado = new Reprovado();
        assertThrows(BusinessException.class, () -> pedidoReprovado.aprovarPedido(pedido));
    }

    @Test
    public void pedidoReprovadoNaoDeveSerReprovadoNovamente() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Reprovado pedidoReprovado = new Reprovado();
        assertThrows(BusinessException.class, () -> pedidoReprovado.reprovarPedido(pedido));
    }
}