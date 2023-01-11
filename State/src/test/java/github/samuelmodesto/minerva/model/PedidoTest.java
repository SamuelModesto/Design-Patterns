package github.samuelmodesto.minerva.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        this.pedido = new Pedido(new BigDecimal("1000"));
    }

    @Test
    public void verificaSeFoiDescontadoDezPorcentoDoPedido() {
        pedido.verificarDescontosDoPedido();
        BigDecimal valor = pedido.getValorPedido();
        assertEquals(valor, new BigDecimal("900.00"));
    }

    @Test
    public void verificaSeFoiDescontadoDoisPorcentoDoPedido() {
        pedido.setStatus(new Aprovado());
        pedido.verificarDescontosDoPedido();
        BigDecimal valor = pedido.getValorPedido();
        assertEquals(valor, new BigDecimal("980.00"));
    }

    @Test
    public void verificaSeFoiDescontadoZeroPorcentoDoPedidoParaStatusReprovado() {
        pedido.setStatus(new Reprovado());
        pedido.verificarDescontosDoPedido();
        BigDecimal valor = pedido.getValorPedido();
        assertEquals(valor, new BigDecimal("1000.00"));
    }

    @Test
    public void verificaSeFoiDescontadoZeroPorcentoDoPedidoParaStatusFinalizado() {
        pedido.setStatus(new Finalizado());
        pedido.verificarDescontosDoPedido();
        BigDecimal valor = pedido.getValorPedido();
        assertEquals(valor, new BigDecimal("1000.00"));
    }
}
