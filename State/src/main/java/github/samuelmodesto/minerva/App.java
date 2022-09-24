package github.samuelmodesto.minerva;

import github.samuelmodesto.minerva.model.Pedido;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {

        Pedido pedido = new Pedido(new BigDecimal("1000"));
        pedido.verificarDescontosDoPedido();
        pedido.aprovar();
        pedido.verificarDescontosDoPedido();
        pedido.finalizar();
        pedido.verificarDescontosDoPedido();
    }
}
