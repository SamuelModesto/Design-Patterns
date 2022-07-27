package github.samuelmodesto.minerva.model;

public abstract class PergaminhoDeOrdem {

    protected PergaminhoDeOrdem proximo;

    public PergaminhoDeOrdem(PergaminhoDeOrdem proximo) {
        this.proximo = proximo;
    }

    public abstract void enviarOrdem(Ordem ordem);
}
