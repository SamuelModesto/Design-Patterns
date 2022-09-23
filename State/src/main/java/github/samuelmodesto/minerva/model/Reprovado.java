package github.samuelmodesto.minerva.model;

import java.math.BigDecimal;

public class Reprovado extends StatusPedido {

    public BigDecimal calcularDesconto(Pedido pedido) {
        return BigDecimal.ZERO;
    }

    @Override
    public void finalizarPedido(Pedido pedido) {
        pedido.setStatus(new Finalizado());
        System.out.println("Pedido Finalizado");
    }
}
