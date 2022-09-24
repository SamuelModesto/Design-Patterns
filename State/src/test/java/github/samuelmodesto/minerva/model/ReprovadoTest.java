package github.samuelmodesto.minerva.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ReprovadoTest {

    @Test
    public void verificaSeOPedidoReprovadoTemValorDescontoZero(){
        Pedido pedido = new Pedido(new BigDecimal("1000"));
        Reprovado reprovado = new Reprovado();
        BigDecimal valorDesconto = reprovado.calcularDesconto(pedido);
        assertEquals(valorDesconto, BigDecimal.ZERO);
    }
}