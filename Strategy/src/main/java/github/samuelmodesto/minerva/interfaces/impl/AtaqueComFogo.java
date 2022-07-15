package github.samuelmodesto.minerva.interfaces.impl;

import github.samuelmodesto.minerva.interfaces.EstrategiaDeAtaque;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AtaqueComFogo implements EstrategiaDeAtaque {
    @Override
    public void atacar() {
        System.out.println("O guerreiro atira um pequeno jarro de óleo no inimigo e com uma tocha queima o mosntro!");
    }
}
