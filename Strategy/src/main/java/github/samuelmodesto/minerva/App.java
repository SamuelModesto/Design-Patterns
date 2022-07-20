package github.samuelmodesto.minerva;

import github.samuelmodesto.minerva.interfaces.impl.AtaqueComEspada;
import github.samuelmodesto.minerva.interfaces.impl.AtaqueComFlechasEnvenenadas;
import github.samuelmodesto.minerva.interfaces.impl.AtaqueComFogo;
import github.samuelmodesto.minerva.model.Guerreiro;

public class App {
    public static void main(String[] args) {
        System.out.println("Um lycan apareceu!");
        Guerreiro guerreiro = new Guerreiro();
        guerreiro.executarAtaque(new AtaqueComEspada());
        System.out.println("Um Monstro de gelo apareceu!");
        guerreiro.executarAtaque(new AtaqueComFogo());
        System.out.println("Um Vampiro apareceu!");
        guerreiro.executarAtaque(new AtaqueComFlechasEnvenenadas());
    }
}
