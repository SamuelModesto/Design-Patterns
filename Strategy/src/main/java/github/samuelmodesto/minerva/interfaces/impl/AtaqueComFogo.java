package github.samuelmodesto.minerva.interfaces.impl;

import github.samuelmodesto.minerva.interfaces.EstrategiaDeAtaque;

public class AtaqueComFogo implements EstrategiaDeAtaque {
    @Override
    public void atacar() {
        System.out.println("O guerreiro atira um pequeno jarro de óleo no inimigo e com uma tocha queima o mosntro!");
    }
}
