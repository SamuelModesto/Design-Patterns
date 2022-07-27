package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.enums.TipoDeOrdem;

public class Oficial extends PergaminhoDeOrdem {

    public Oficial(PergaminhoDeOrdem proximo) {
        super(proximo);
    }

    @Override
    public void enviarOrdem(Ordem ordem) {
        if (ordem.getTipoDeOrdem().equals(TipoDeOrdem.LEVAR_PRISIONEIROS_PARA_CELA)) {
            System.out.println("Oficial de exercito cumprindo a ordem de levar os prisioneiros para a cela.");
        } else {
            proximo.enviarOrdem(ordem);
        }
    }
}
