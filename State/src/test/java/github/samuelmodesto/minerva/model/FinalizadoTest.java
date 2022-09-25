package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.exceptions.BusinessException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FinalizadoTest {

    @Test
    public void verificaSeOPedidoFinalizadoTemValorDescontoZero() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Finalizado finalizado = new Finalizado();
        BigDecimal valorDesconto = finalizado.calcularDesconto(pedido);
        assertEquals(valorDesconto, BigDecimal.ZERO);
    }

    @Test
    public void pedidoFinalizadoNaoDeveSerAprovado() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Finalizado pedidoFinalizado = new Finalizado();
        assertThrows(BusinessException.class, () -> pedidoFinalizado.aprovarPedido(pedido));
    }

    @Test
    public void pedidoFinalizadoNaoDeveSerReprovado() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Finalizado pedidoFinalizado = new Finalizado();
        assertThrows(BusinessException.class, () -> pedidoFinalizado.reprovarPedido(pedido));
    }

    @Test
    public void pedidoFinalizadoNaoDeveSerFinalizadoNovamente() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Finalizado pedidoFinalizado = new Finalizado();
        assertThrows(BusinessException.class, () -> pedidoFinalizado.finalizarPedido(pedido));
    }
}