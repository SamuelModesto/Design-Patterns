package github.samuelmodesto.minerva.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {

    @Test
    public void verificaSeFoiDescontadoDezPorcentoDoPedido(){
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        pedido.verificarDescontosDoPedido();
        BigDecimal valor = pedido.getValorPedido();
        assertEquals(valor, new BigDecimal("900.00"));
    }

    @Test
    public void verificaSeFoiDescontadoDoisPorcentoDoPedido(){
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        pedido.setStatus(new Aprovado());
        pedido.verificarDescontosDoPedido();
        BigDecimal valor = pedido.getValorPedido();
        assertEquals(valor, new BigDecimal("980.00"));
    }

    @Test
    public void verificaSeFoiDescontadoZeroPorcentoDoPedidoParaStatusReprovado(){
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        pedido.setStatus(new Reprovado());
        pedido.verificarDescontosDoPedido();
        BigDecimal valor = pedido.getValorPedido();
        assertEquals(valor, new BigDecimal("1000.00"));
    }

    @Test
    public void verificaSeFoiDescontadoZeroPorcentoDoPedidoParaStatusFinalizado(){
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        pedido.setStatus(new Finalizado());
        pedido.verificarDescontosDoPedido();
        BigDecimal valor = pedido.getValorPedido();
        assertEquals(valor, new BigDecimal("1000.00"));
    }



}
