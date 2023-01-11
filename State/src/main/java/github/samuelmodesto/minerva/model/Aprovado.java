package github.samuelmodesto.minerva.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Aprovado extends StatusPedido {
    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        return pedido.getValorPedido().multiply(new BigDecimal("0.02")).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void finalizarPedido(Pedido pedido) {
        pedido.setStatus(new Finalizado());
        System.out.println("Pedido Finalizado");
    }
}
