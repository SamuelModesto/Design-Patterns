package github.samuelmodesto.minerva.model;

public class Daenerys {

    public void escreverOrdemNoPergaminho(Ordem ordem) {
        PergaminhoDeOrdem pergaminho =
                new Comandante(
                        new Oficial(
                                new Soldado(
                                        new SemOrdem()
                                )
                        )
                );
        pergaminho.enviarOrdem(ordem);
    }
}
