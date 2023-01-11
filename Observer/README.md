<br />
<p >
  <h1>OBSERVER</h1>
<p/>


<!-- TABLE OF CONTENTS -->

## Conteúdo

- [Propósito](#Propósito)  
- [Explicação](#Explicação)  
  - [Cenário](#Cenário-De-Aplicação)    
  - [Resumo](#Resumo)
  - [Wikipedia](#Wikipedia)
  - [Exemplo de Código](#Exemplo-de-código)
- [Diagrama de Classe](#Diagrama-de-Classe)

- [Quando Usar](#Quando-Usar)
- [Créditos](#Créditos)
- [Licença](#Licença)
- [Contato](#Contato)

## Propósito
| Nome       | Categoria    | Tag        |  
|:-----------| :----------- | :--------- |
| `Observer` |  Comportamental | Gang Of Four (GOF)|

Garantir que objetos que dependem de outro objeto percebam as mudanças naquele objeto da qual dependem.


## Explicação
### Cenário de aplicação
Em um cenário de cadastro de clientes, precisamos executar algumas ações no momento em que um cliente é cadastro, essas ações podem ser salvar no banco de           dados, enviar email, enviar SMS e assim por diante. Para isso podemos usar esse padrão para que quando o método de cadastrar usuário for chamado, os demais         objetos que estão observando possam ser notificados para executar uma determinada tarefa.


### Resumo
Permite que objetos interessados sejam avisados da mudança de estado ou outros eventos ocorrendo num outro objeto.
 
### Wikipedia
Esse padrão de projeto de software define uma dependência um-para-muitos entre objetos de modo que quando um objeto muda o estado, todos seus dependentes são       notificados e atualizados automaticamente. 

## Diagrama de classe

<p align="center">
  <img alt="state" src="https://github.com/SamuelModesto/Assets/blob/master/Imagens%20Java-Design-Patterns/observer.jpeg" />
</p>

### Exemplo de código

Para este exemplo criamos uma interface com o metodo ``` notificar() ``` que recebe uma entidade Cliente.

```java 
public interface FinalizacaoDeCadastro {

    void notificar(Cliente cliente);
}

```

```java

Entidade Cliente
public class Cliente {

    private String nome;
    private String email;
    private String numCel;
    //Getters, Setters e construtor 
}
```

Após isso, para cada ação que queremos tomar devemos criar uma classe, essas classes são chamadas de subscribers pois são elas que vão receber
a notificação da mudança de estado de um objeto.
```java 
public class EnviarEmail implements FinalizacaoDeCadastro {
    @Override
    public void notificar(Cliente cliente) {
        System.out.println("Enviando email para o novo cliente: "
                +cliente.getNome() + ", e-mail: "
                + cliente.getEmail());
    }
}
```

```java 
public class EnviarSms implements FinalizacaoDeCadastro {
    @Override
    public void notificar(Cliente cliente) {
        System.out.println("Enviando SMS para o novo cliente: "
                +cliente.getNome() + ", celular: "
                + cliente.getNumCel());
    }
}
```

```java
public class SalvarNoBanco implements FinalizacaoDeCadastro {
    @Override
    public void notificar(Cliente cliente) {
        System.out.println("Salvando cliente no banco de dados.");
    }
}
```
Por fim implementamos a classe CadastroService, essa classe é chamada de Publisher pois é ela quem dispara as mensagens para os subscribers.
Note que implementamos uma lista do tipo da interface e percorremos a lista sendo que para cada elemento na minha lista eu devo chamar o método ```notificar()```.

```java 
public class CadastroService {

    private List<FinalizacaoDeCadastro> finalizacoesDeCadastro;

    public CadastroService(List<FinalizacaoDeCadastro> finalizacoesDeCadastro) {
        this.finalizacoesDeCadastro = finalizacoesDeCadastro;
    }

    public void finalizarCadastroDoCliente(Cliente cliente){
        this.finalizacoesDeCadastro.forEach(f -> f.notificar(cliente));
    }
}
```
Na classe de teste ou classe que vai fazer o uso, devemos instanciar os objetos subscribers na ordem em que queremos que sejam notificados.
```java 
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
```

Saída no console:
```
Salvando cliente no banco de dados.
Enviando email para o novo cliente: Samuel, e-mail: samuel@samuel.com
Enviando SMS para o novo cliente: Samuel, celular: 55 0000-0000
```

## Quando Usar
- Quando mudanças as no estado de um objeto precisar mudar outros objetos, e o atual conjunto de objetos é desconhecido de antemão ou muda dinamicamente.
- Quando algum objeto da aplicação precisam observar outros objetos.

## Como Executar
 1. Baixe o projeto.
 2. Abra o projeto na IDE de sua preferência.
 3. Execute a classe "App" de qualquer padrão de projeto.

## Créditos
- https://refactoring.guru/design-patterns
- https://tinyurl.com/2p9f795f
- https://amzn.to/3ceYsRG
## Licença

Distribuído sob a licença do MIT. Consulte `LICENSE` para obter mais informações.

## Contato
Samuel Modesto 
- [Github](https://github.com/SamuelModesto) 
- [LinkedIn](https://www.linkedin.com/in/samuelmodesto)
- **samuelmodestoes@gmail.com** 
