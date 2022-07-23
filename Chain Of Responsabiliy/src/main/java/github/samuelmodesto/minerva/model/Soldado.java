package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.enums.TipoDeOrdem;

public class Soldado extends PergaminhoDeOrdem {

    public Soldado(PergaminhoDeOrdem proximo) {
        super(proximo);
    }

    @Override
    public void enviarOrdem(Ordem ordem) {
        if (ordem.getTipoDeOrdem().equals(TipoDeOrdem.COBRAR_IMPOSTOS)){
            System.out.println("soldado cumprindo a ordem de cobrar os impostos.");
        }
    }
}
