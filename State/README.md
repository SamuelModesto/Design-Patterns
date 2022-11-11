<br />
<p >
  <h1>STATE</h1>
<p/>


<!-- TABLE OF CONTENTS -->

## Conteúdo

- [Propósito](#Propósito)
- [Explicação](#Explicação)
  - [Cenário](#Cenário-De-Aplicação)
  - [Resumo](#Resumo)
  - [Wikipedia](#Wikipedia)
  - [Diagrama de Classe](#Diagrama-de-Classe)
  - [Exemplo de Código](#Exemplo-de-código)
- [Quando Usar](#Quando-Usar)
- [Créditos](#Créditos)
- [Licença](#Licença)
- [Contato](#Contato)

## Propósito
| Nome    | Categoria    | Tag        |  
|:--------| :----------- | :--------- |
| `State` |  Comportamental | Gang Of Four (GOF)|

Possibiitar que um objeto mude de comportamento de acordo com seu estado interno. Tomando a forma de outro objeto ou seja se parece com um novo objeto de uma outra classe.

## Explicação
### Cenário de aplicação
Em uma calculadora de desconto de uma loja virtual, o pedido tem alguns estados ( ANALISE, APROVADO, REPROVADO, FINALIZADO) e dependendo desse estado, a calculadora aplica diferentes percentuais de descontos.

### Resumo
 O padrão state permite que um objeto altere o seu comportamento quando o seu estado interno muda.
 
### Wikipedia
Em certas ocasiões, quando o contexto em que está a desenvolver requer um objeto que possua comportamentos diferentes dependendo de qual estado se encontra, é difícil manejar a mudança de comportamento e os estados desse objeto, tudo dentro do mesmo bloco de código. O padrão State propõe uma solução para esta complicação, criando basicamente, um objeto para cada estado possível do objeto que o chama.

### Diagrama de classe

<p align="center">
  <img alt="state" src="https://github.com/SamuelModesto/Imagens/blob/master/Imagens%20Minerva/state.jpeg" />
</p>

### Exemplo de código
Primeiro implementamos a classe de contexto que possui os estados, nesse caso é a classe que representa um pedido. Essa classe é responsável por invocar um método que verifica com base no estado do pedido, se aquele pedido tem desconto ou não.
```java 
package github.samuelmodesto.minerva.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pedido {

    private BigDecimal valorPedido;
    private StatusPedido status;

    public void verificarDescontosDoPedido() {
        BigDecimal valorDesconto = this.status.calcularDesconto(this);
        valorPedido = this.valorPedido.subtract(valorDesconto).setScale(2, RoundingMode.HALF_UP);
        System.out.println("O valor do pedido com desconto é " + valorPedido);
    }

    public Pedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
        this.status = new Analise();
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void aprovar() {
        status.aprovarPedido(this);
    }

    public void reprovar() {
        status.reprovarPedido(this);
    }

    public void finalizar() {
        status.finalizarPedido(this);
    }
}


```
Em seguida implementamos a classe abstrata ou interface onde colocaremos as exceções, pois nesse exemplo as classes concretas devem implementar as regras de mudanca de estado por si só. Para os estados que não puderem ser alcançados, será lançado uma exceção que consta na SuperClasse.
```java
package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.exceptions.BusinessException;

import java.math.BigDecimal;

public abstract class StatusPedido {

    public BigDecimal calcularDesconto(Pedido pedido) {
        return BigDecimal.ZERO;
    }

    public void aprovarPedido(Pedido pedido) {
        throw new BusinessException("O pedido não pode ser aprovado!");
    }

    public void reprovarPedido(Pedido pedido) {
        throw new BusinessException("O pedido não pode ser reprovado!");
    }

    public void finalizarPedido(Pedido pedido) {
        throw new BusinessException("O pedido não pode ser finalizado!");
    }
}

```
Todos os objetos da classe pedido já são instanciados com o status Analise, sendo que neste estado o valor do pedido recebe 10% de desconto e só podem ser aprovados ou reprovados, mas nunca finalizados a partir deste estado.
```java
package github.samuelmodesto.minerva.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Analise extends StatusPedido {
    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        return pedido.getValorPedido().multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.HALF_UP);
    }
    @Override
    public void aprovarPedido(Pedido pedido) {
        pedido.setStatus(new Aprovado());
        System.out.println("Pedido Aprovado");
    }
    @Override
    public void reprovarPedido(Pedido pedido) {
        pedido.setStatus(new Reprovado());
    }
}

```
Pedidos no estado de aprovado recebem desconto de 2% no valor do pedido e só podem ser finalizados a partir deste estado.
```java
package github.samuelmodesto.minerva.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Aprovado extends StatusPedido {
    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        return pedido.getValorPedido().multiply(new BigDecimal("0.02")).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void finalizarPedido(Pedido pedido) {
        pedido.setStatus(new Finalizado());
        System.out.println("Pedido Finalizado");
    }
}

```

Pedidos reprovados não recebem nenhum desconto e só podem ser finalizados a partir deste estado.
```java
package github.samuelmodesto.minerva.model;

import java.math.BigDecimal;

public class Reprovado extends StatusPedido {
    @Override
    public BigDecimal calcularDesconto(Pedido pedido) {
        return BigDecimal.ZERO;
    }

    @Override
    public void finalizarPedido(Pedido pedido) {
        pedido.setStatus(new Finalizado());
        System.out.println("Pedido Finalizado");
    }
}

```
Pedidos Finalizados não possui nenhum comportamento de transição de estado, caso a aplicação tente transitar de estado, a exceção da SuperClasse será lançada.
```java
package github.samuelmodesto.minerva.model;

public class Finalizado extends StatusPedido {
}
```
Finalmente implementamos a classe App para execução da aplicação. (A ordem das chamadas dos métodos podem ser alteradas ou acrescentadas para verficar diferentes comportamentos da aplicação).

```java
package github.samuelmodesto.minerva;

import github.samuelmodesto.minerva.model.Pedido;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {

        Pedido pedido = new Pedido(new BigDecimal("1000"));
        pedido.verificarDescontosDoPedido();
        pedido.aprovar();
        pedido.verificarDescontosDoPedido();
        pedido.finalizar();
        pedido.verificarDescontosDoPedido();
    }
}
```

Saída no console
```
O valor do pedido com desconto é 900.00
Pedido Aprovado
O valor do pedido com desconto é 882.00
Pedido Finalizado
O valor do pedido com desconto é 882.00
```

## Quando Usar
- Quando você tem um objeto que se comporta de maneira diferente dependendo do seu estado atual e quando o código estado específico muda com frequência.
- Quando você tem uma classe com muitas condicionais que alteram o comportamento da classe  de acordo com os valores atuais do objeto.

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
