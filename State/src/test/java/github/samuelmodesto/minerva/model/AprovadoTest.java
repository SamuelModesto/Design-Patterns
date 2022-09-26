package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.exceptions.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AprovadoTest {

    private Pedido pedido;
    private Aprovado pedidoAprovado;

    @BeforeEach
    void setUp() {
        this.pedido = new Pedido(new BigDecimal("1000"));
        this.pedidoAprovado = new Aprovado();
    }

    @Test
    public void verificaSeOPedidoAprovadoTemDescontoDeDoisPorcento() {
        BigDecimal valorDesconto = pedidoAprovado.calcularDesconto(pedido);
        assertEquals(valorDesconto, new BigDecimal("20.00"));
    }

    @Test
    public void pedidoAprovadoNaoDeveSerReprovado() {
        assertThrows(BusinessException.class, () -> pedidoAprovado.reprovarPedido(pedido));
    }
}