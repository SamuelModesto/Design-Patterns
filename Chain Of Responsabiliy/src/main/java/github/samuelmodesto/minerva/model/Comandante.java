package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.enums.TipoDeOrdem;

public class Comandante extends PergaminhoDeOrdem {

    public Comandante(PergaminhoDeOrdem proximo) {
        super(proximo);
    }

    @Override
    public void enviarOrdem(Ordem ordem) {
        if (ordem.getTipoDeOrdem().equals(TipoDeOrdem.ATACAR)) {
            System.out.println("Oficial cumprindo a ordem de atacar.");
        } else {
            proximo.enviarOrdem(ordem);
        }
    }
}
