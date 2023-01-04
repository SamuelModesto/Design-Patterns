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


## Explicação
### Cenário de aplicação

### Resumo
 
### Wikipedia

### Exemplo de código
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

## Diagrama de classe

[//]: # (<p align="center">)

[//]: # (  <img alt="state" src="https://github.com/SamuelModesto/Imagens/blob/master/Imagens%20Minerva/state.jpeg" />)

[//]: # (</p>)

## Quando Usar

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