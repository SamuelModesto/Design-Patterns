package github.samuelmodesto.minerva.interfaces.impl;

import github.samuelmodesto.minerva.interfaces.EstrategiaDeAtaque;

public class AtaqueComFlechasEnvenenadas implements EstrategiaDeAtaque {
    @Override
    public void atacar() {
        System.out.println("O guerreiro atira flechas envenanadas com veneno de alho que derrotam facilmente o inimigo");
    }
}
