package github.samuelmodesto.minerva.finalizacao;

import github.samuelmodesto.minerva.interfaces.FinalizacaoDeCadastro;
import github.samuelmodesto.minerva.model.Cliente;

public class SalvarNoBanco implements FinalizacaoDeCadastro {
    @Override
    public void finalizarCadastro(Cliente cliente) {
        System.out.println("Salvando cliente no banco de dados.");
    }
}
