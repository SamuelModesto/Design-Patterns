package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.exceptions.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AnaliseTest {
    private Pedido pedido;
    private Analise pedidoEmanalise;

    @BeforeEach
    void setUp() {
        this.pedido = new Pedido(new BigDecimal("1000"));
        this.pedidoEmanalise = new Analise();
    }

    @Test
    public void verificaSeOPedidoEmAnaliseTemDescontoDeDezPorcento() {
        BigDecimal valorDesconto = pedidoEmanalise.calcularDesconto(pedido);
        assertEquals(valorDesconto, new BigDecimal("100.00"));
    }

    @Test
    public void pedidoEmAnaliseNaoDeveSerFinalizado() {
        assertThrows(BusinessException.class, () -> pedidoEmanalise.finalizarPedido(pedido));
    }
}