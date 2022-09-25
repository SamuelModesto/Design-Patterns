package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.exceptions.BusinessException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AnaliseTest {

    @Test
    public void verificaSeOPedidoEmAnaliseTemDescontoDeDezPorcento() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Analise analise = new Analise();
        BigDecimal valorDesconto = analise.calcularDesconto(pedido);
        assertEquals(valorDesconto, new BigDecimal("100.00"));
    }

    @Test
    public void pedidoEmAnaliseNaoDeveSerFinalizado() {
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Analise analise = new Analise();
        assertThrows(BusinessException.class, () -> analise.finalizarPedido(pedido));
    }
}