package github.samuelmodesto.minerva.service;

import github.samuelmodesto.minerva.interfaces.FinalizacaoDeCadastro;
import github.samuelmodesto.minerva.model.Cliente;

import java.util.List;

public class CadastroService {

    private List<FinalizacaoDeCadastro> finalizacoesDeCadastro;

    public CadastroService(List<FinalizacaoDeCadastro> finalizacoesDeCadastro) {
        this.finalizacoesDeCadastro = finalizacoesDeCadastro;
    }

    public void finalizarCadastroDoCliente(Cliente cliente){
        this.finalizacoesDeCadastro.forEach(f -> f.finalizarCadastro(cliente));
    }
}
