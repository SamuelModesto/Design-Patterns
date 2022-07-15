package github.samuelmodesto.minerva;

import github.samuelmodesto.minerva.interfaces.impl.AtaqueComEspada;
import github.samuelmodesto.minerva.interfaces.impl.AtaqueComFlechasEnvenenadas;
import github.samuelmodesto.minerva.interfaces.impl.AtaqueComFogo;
import github.samuelmodesto.minerva.model.Guerreiro;
import lombok.extern.log4j.Log4j2;

@Log4j2
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
