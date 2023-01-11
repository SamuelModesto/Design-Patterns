package github.samuelmodesto.minerva.finalizacao;

import github.samuelmodesto.minerva.interfaces.FinalizacaoDeCadastro;
import github.samuelmodesto.minerva.model.Cliente;

public class EnviarSms implements FinalizacaoDeCadastro {
    @Override
    public void finalizarCadastro(Cliente cliente) {
        System.out.println("Enviando SMS para o novo cliente: "
                +cliente.getNome() + ", celular: "
                + cliente.getNumCel());
    }
}
