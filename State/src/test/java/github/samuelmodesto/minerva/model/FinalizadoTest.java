package github.samuelmodesto.minerva.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FinalizadoTest {

    @Test
    public void verificaSeOPedidoFinalizadoTemValorDescontoZero(){
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Finalizado finalizado = new Finalizado();
        BigDecimal valorDesconto = finalizado.calcularDesconto(pedido);
        assertEquals(valorDesconto, BigDecimal.ZERO);
    }

}