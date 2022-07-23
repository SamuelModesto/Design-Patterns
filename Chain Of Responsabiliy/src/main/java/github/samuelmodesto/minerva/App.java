package github.samuelmodesto.minerva;

import github.samuelmodesto.minerva.enums.TipoDeOrdem;
import github.samuelmodesto.minerva.model.Daenerys;
import github.samuelmodesto.minerva.model.Ordem;

public class App {
    public static void main(String[] args) {
        Ordem ordem1 = new Ordem(TipoDeOrdem.LEVAR_PRISIONEIROS_PARA_CELA);
        Ordem ordem2 = new Ordem(TipoDeOrdem.ATACAR);
        Ordem ordem3 = new Ordem(TipoDeOrdem.COBRAR_IMPOSTOS);
        Daenerys daenerys = new Daenerys();
        daenerys.escreverOrdemNoPergaminho(ordem1);
        daenerys.escreverOrdemNoPergaminho(ordem2);
        daenerys.escreverOrdemNoPergaminho(ordem3);
    }
}
