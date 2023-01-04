package github.samuelmodesto.minerva.finalizacao;

import github.samuelmodesto.minerva.interfaces.FinalizacaoDeCadastro;
import github.samuelmodesto.minerva.model.Cliente;

public class EnviarEmail implements FinalizacaoDeCadastro {
    @Override
    public void finalizarCadastro(Cliente cliente) {
        System.out.println("Enviando email para o novo cliente: "
                +cliente.getNome() + ", e-mail: "
                + cliente.getEmail());
    }
}
