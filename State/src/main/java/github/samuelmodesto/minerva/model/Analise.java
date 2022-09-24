package github.samuelmodesto.minerva.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Analise extends StatusPedido {
    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        return pedido.getValorPedido().multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.HALF_UP);
    }
    @Override
    public void aprovarPedido(Pedido pedido) {
        pedido.setStatus(new Aprovado());
        System.out.println("Pedido Aprovado");
    }
    @Override
    public void reprovarPedido(Pedido pedido) {
        pedido.setStatus(new Reprovado());
    }
}
