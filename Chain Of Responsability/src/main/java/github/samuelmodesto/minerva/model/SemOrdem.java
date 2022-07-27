package github.samuelmodesto.minerva.model;

public class SemOrdem extends PergaminhoDeOrdem {

    public SemOrdem() {
        super(null);
    }

    @Override
    public void enviarOrdem(Ordem ordem) {
        System.out.println("Fim da cadeia de responsabilidade");
    }
}
