package github.samuelmodesto.minerva.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pedido {

    private BigDecimal valorPedido;
    private StatusPedido status;

    public void verificarDescontosDoPedido() {
        BigDecimal valorDesconto = this.status.calcularDesconto(this);
        valorPedido = this.valorPedido.subtract(valorDesconto);
        arredondarValorPedido();
        System.out.println("O valor do pedido com desconto é " + valorPedido);
    }

    private void arredondarValorPedido() {
        this.valorPedido = this.valorPedido.setScale(2, RoundingMode.HALF_UP);
    }

    public Pedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
        this.status = new Analise();
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void aprovar() {
        status.aprovarPedido(this);
    }

    public void reprovar() {
        status.reprovarPedido(this);
    }

    public void finalizar() {
        status.finalizarPedido(this);
    }
}
