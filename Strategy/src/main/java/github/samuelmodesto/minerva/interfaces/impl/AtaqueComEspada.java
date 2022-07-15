package github.samuelmodesto.minerva.interfaces.impl;

import github.samuelmodesto.minerva.interfaces.EstrategiaDeAtaque;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AtaqueComEspada implements EstrategiaDeAtaque {
    @Override
    public void atacar() {
        System.out.println("O guerreiro saca a espada de prata e ataca cortando o inimigo que possui fraqueza quando atacado armas de prata!");
    }
}
