package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.exceptions.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ReprovadoTest {

    private Pedido pedido;
    private Reprovado pedidoReprovado;

    @BeforeEach
    void setUp() {
        this.pedido = new Pedido(new BigDecimal("1000"));
        this.pedidoReprovado = new Reprovado();
    }

    @Test
    public void verificaSeOPedidoReprovadoTemValorDescontoZero() {
        BigDecimal valorDesconto = pedidoReprovado.calcularDesconto(pedido);
        assertEquals(valorDesconto, BigDecimal.ZERO);
    }

    @Test
    public void pedidoReprovadoNaoDeveSerAprovado() {
        assertThrows(BusinessException.class, () -> pedidoReprovado.aprovarPedido(pedido));
    }

    @Test
    public void pedidoReprovadoNaoDeveSerReprovadoNovamente() {
        assertThrows(BusinessException.class, () -> pedidoReprovado.reprovarPedido(pedido));
    }
}