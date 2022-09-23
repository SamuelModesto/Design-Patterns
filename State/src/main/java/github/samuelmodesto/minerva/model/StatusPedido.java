package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.exceptions.BusinessException;

import java.math.BigDecimal;

public abstract class StatusPedido {

    public BigDecimal calcularDesconto(Pedido pedido) {
        return BigDecimal.ZERO;
    }

    public void aprovarPedido(Pedido pedido) {
        throw new BusinessException("O pedido não pode ser aprovado!");
    }

    public void reprovarPedido(Pedido pedido) {
        throw new BusinessException("O pedido não pode ser reprovado!");
    }

    public void finalizarPedido(Pedido pedido) {
        throw new BusinessException("O pedido não pode ser finalizado!");
    }
}

