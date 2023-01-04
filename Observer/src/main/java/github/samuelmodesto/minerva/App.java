package github.samuelmodesto.minerva;

import github.samuelmodesto.minerva.finalizacao.EnviarEmail;
import github.samuelmodesto.minerva.finalizacao.EnviarSms;
import github.samuelmodesto.minerva.finalizacao.SalvarNoBanco;
import github.samuelmodesto.minerva.interfaces.FinalizacaoDeCadastro;
import github.samuelmodesto.minerva.model.Cliente;
import github.samuelmodesto.minerva.service.CadastroService;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(
                "Samuel",
                "samuel@samuel.com",
                "55 0000-0000");

        List<FinalizacaoDeCadastro> finalizacoes = Arrays.asList(
                new SalvarNoBanco(),
                new EnviarEmail(),
                new EnviarSms()
        );
        CadastroService cadastroService = new CadastroService(finalizacoes);

        cadastroService.finalizarCadastroDoCliente(cliente);
    }
}

