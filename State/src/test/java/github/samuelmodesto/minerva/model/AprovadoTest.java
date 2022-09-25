package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.exceptions.BusinessException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AprovadoTest {

    @Test
    public void verificaSeOPedidoAprovadoTemDescontoDeDoisPorcento() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Aprovado aprovado = new Aprovado();
        BigDecimal valorDesconto = aprovado.calcularDesconto(pedido);
        assertEquals(valorDesconto, new BigDecimal("20.00"));
    }

    @Test
    public void pedidoAprovadoNaoDeveSerReprovado() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Aprovado aprovado = new Aprovado();
        assertThrows(BusinessException.class, () -> aprovado.reprovarPedido(pedido));
    }

}