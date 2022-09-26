package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.exceptions.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FinalizadoTest {

    private Pedido pedido;
    private Finalizado pedidoFinalizado;

    @BeforeEach
    void setUp() {
        this.pedido = new Pedido(new BigDecimal("1000"));
        this.pedidoFinalizado = new Finalizado();
    }

    @Test
    public void verificaSeOPedidoFinalizadoTemValorDescontoZero() {
        BigDecimal valorDesconto = pedidoFinalizado.calcularDesconto(pedido);
        assertEquals(valorDesconto, BigDecimal.ZERO);
    }

    @Test
    public void pedidoFinalizadoNaoDeveSerAprovado() {
        assertThrows(BusinessException.class, () -> pedidoFinalizado.aprovarPedido(pedido));
    }

    @Test
    public void pedidoFinalizadoNaoDeveSerReprovado() {
        assertThrows(BusinessException.class, () -> pedidoFinalizado.reprovarPedido(pedido));
    }

    @Test
    public void pedidoFinalizadoNaoDeveSerFinalizadoNovamente() {
        assertThrows(BusinessException.class, () -> pedidoFinalizado.finalizarPedido(pedido));
    }
}