package github.samuelmodesto.minerva.interfaces.impl;

import github.samuelmodesto.minerva.interfaces.EstrategiaDeAtaque;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AtaqueComFlechasEnvenenadas implements EstrategiaDeAtaque {
    @Override
    public void atacar() {
        System.out.println("O guerreiro atira flechas envenanadas com veneno de alho que derrotam facilmente o inimigo");
    }
}
