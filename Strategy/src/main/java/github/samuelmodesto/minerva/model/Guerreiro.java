package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.interfaces.EstrategiaDeAtaque;

public class Guerreiro {
    public void executarAtaque(EstrategiaDeAtaque estrategiaDeAtaque) {
        estrategiaDeAtaque.atacar();
    }
}
