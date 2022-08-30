package github.samuelmodesto.minerva;

import github.samuelmodesto.minerva.model.Nescafe;
import github.samuelmodesto.minerva.model.TresCoracoes;

public class App {
    public static void main(String[] args) {
        System.out.println("PREPARO DO CAFÉ TRÊS CORAÇÕES");
        TresCoracoes tresCoracoes = new TresCoracoes();
        tresCoracoes.prepararCafeTemplate();

        System.out.println("\n\n");

        System.out.println("PREPARO DO NESCAFÉ");
        Nescafe nescafe = new Nescafe();
        nescafe.prepararCafeTemplate();
    }
}
