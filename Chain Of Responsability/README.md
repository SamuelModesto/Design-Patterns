<br />
<p >
  <h1>Chain Of Responsability</h1>
</p>

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
- [Como Usar](#Como-Usar)
- [Créditos](#Créditos)
- [Licença](#Licença)
- [Contato](#Contato)

## Propósito
O Chain of Responsibility é um padrão de projeto que permite que você passe solicitações de ações por uma corrente de regras. Ao receber uma solicitação, cada regra decide se processa a solicitação ou se passa adiante para a próximo regra na corrente.

## Explicação
### Cenário de aplicação
A Rainha Daenerys (Game Of Thrones) escreve ordens em um pergaminho para o comandante do seu exército dos imaculados, que pode executar ele mesmo ou pedir para um oficial mais proximo que por sua vez também pode executar ou ordenar que um soldado raso execute o trabalho. O comandante, o oficial e o soldado raso representam a cadeia de responsabilidade.
### Resumo
Esse padrão ajuda a construir uma cadeia de objetos. Uma solicitação entra de um lado e continua indo de um objeto para outro até encontrar um manipulador adequado.
### Wikipedia
No projeto orientado a objetos, o padrão de cadeia de responsabilidade é um padrão de projeto comportamental que consiste em uma fonte de objetos de comando e uma série de objetos de processamento. Cada objeto de processamento contém uma lógica que define os tipos de objetos de comando que ele pode manipular, o restante é passado para o próximo objeto de processamento na cadeia.
### Exemplo de código
Primeiramente para este exemplo deve ser criado os enums referente a cada acao que podera ser ordenada aos soldados.
```java
package github.samuelmodesto.minerva.enums;

public enum TipoDeOrdem {

    ATACAR,
    LEVAR_PRISIONEIROS_PARA_CELA,
    COBRAR_IMPOSTOS
}
```

Após basta criar a classe Ordem 
```java
package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.enums.TipoDeOrdem;

public class Ordem {

    private TipoDeOrdem tipoDeOrdem;

    public Ordem(TipoDeOrdem tipoDeOrdem) {
        this.tipoDeOrdem = tipoDeOrdem;
    }

    public TipoDeOrdem getTipoDeOrdem() {
        return tipoDeOrdem;
    }

    public void setTipoDeOrdem(TipoDeOrdem tipoDeOrdem) {
        this.tipoDeOrdem = tipoDeOrdem;
    }
}
```

O pergaminh de ordem representa a classe abstrata pois a ordem poderá ser passada na cadeia de responsabilidade dependendo da ordem que estiver no pergaminho.
```java
package github.samuelmodesto.minerva.model;

public abstract class PergaminhoDeOrdem {

    protected PergaminhoDeOrdem proximo;

    public PergaminhoDeOrdem(PergaminhoDeOrdem proximo) {
        this.proximo = proximo;
    }

    public abstract void enviarOrdem(Ordem ordem);
}
```

O primeiro nivel da cadeia de responsabilidade deve extender a classe de pergaminho de ordem para que possa implementar o metodo enviar ordem.
```java
package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.enums.TipoDeOrdem;

public class Comandante extends PergaminhoDeOrdem {

    public Comandante(PergaminhoDeOrdem proximo) {
        super(proximo);
    }

    @Override
    public void enviarOrdem(Ordem ordem) {
        if (ordem.getTipoDeOrdem().equals(TipoDeOrdem.ATACAR)) {
            System.out.println("Oficial cumprindo a ordem de atacar.");
        } else {
            proximo.enviarOrdem(ordem);
        }
    }
}

```

O Segundo nivel da cadeia de responsabilidade deve extender a classe de pergaminho de ordem para que possa implementar o metodo enviar ordem.
```java
package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.enums.TipoDeOrdem;

public class Oficial extends PergaminhoDeOrdem {

    public Oficial(PergaminhoDeOrdem proximo) {
        super(proximo);
    }

    @Override
    public void enviarOrdem(Ordem ordem) {
        if (ordem.getTipoDeOrdem().equals(TipoDeOrdem.LEVAR_PRISIONEIROS_PARA_CELA)) {
            System.out.println("Oficial de exercito cumprindo a ordem de levar os prisioneiros para a cela.");
        } else {
            proximo.enviarOrdem(ordem);
        }
    }
}
```

O Terceiro nivel da cadeia de responsabilidade deve extender a classe de pergaminho de ordem para que possa implementar o metodo enviar ordem.
```java
package github.samuelmodesto.minerva.model;

import github.samuelmodesto.minerva.enums.TipoDeOrdem;

public class Soldado extends PergaminhoDeOrdem {

    public Soldado(PergaminhoDeOrdem proximo) {
        super(proximo);
    }

    @Override
    public void enviarOrdem(Ordem ordem) {
        if (ordem.getTipoDeOrdem().equals(TipoDeOrdem.COBRAR_IMPOSTOS)) {
            System.out.println("soldado cumprindo a ordem de cobrar os impostos.");
        } else {
            proximo.enviarOrdem(ordem);
        }
    }
}
```

O último nivel da cadeia de responsabilidade deve extender a classe de pergaminho de ordem para que possa implementar o metodo enviar ordem de forma que nao passe mais adiante na cadeia de responsabilidade.
```java
package github.samuelmodesto.minerva.model;

public class SemOrdem extends PergaminhoDeOrdem {

    public SemOrdem() {
        super(null);
    }

    @Override
    public void enviarOrdem(Ordem ordem) {
        System.out.println("Fim da cadeia de responsabilidade");
    }
}
```

Essa classe é de quem escreve a ordem no pergaminho, e nesse caso a rainha Daenerys é encarregada desse papel.
```java
package github.samuelmodesto.minerva.model;

public class Daenerys {

    public void escreverOrdemNoPergaminho(Ordem ordem) {
        PergaminhoDeOrdem pergaminho =
                new Comandante(
                        new Oficial(
                                new Soldado(
                                        new SemOrdem()
                                )
                        )
                );
        pergaminho.enviarOrdem(ordem);
    }
}
```
O padrão chain of responsibility em ação.
```java
package github.samuelmodesto.minerva;

import github.samuelmodesto.minerva.enums.TipoDeOrdem;
import github.samuelmodesto.minerva.model.Daenerys;
import github.samuelmodesto.minerva.model.Ordem;

public class App {
    public static void main(String[] args) {
        Ordem ordem1 = new Ordem(TipoDeOrdem.LEVAR_PRISIONEIROS_PARA_CELA);
        Ordem ordem2 = new Ordem(TipoDeOrdem.ATACAR);
        Ordem ordem3 = new Ordem(TipoDeOrdem.COBRAR_IMPOSTOS);
        Daenerys daenerys = new Daenerys();
        daenerys.escreverOrdemNoPergaminho(ordem1);
        daenerys.escreverOrdemNoPergaminho(ordem2);
        daenerys.escreverOrdemNoPergaminho(ordem3);
    }
}
```
Saída no console
```
Oficial de exercito cumprindo a ordem de levar os prisioneiros para a cela.
Comandante cumprindo a ordem de atacar.
soldado cumprindo a ordem de cobrar os impostos.
```


## Diagrama de classe
<p align="center">
  <a href="https://github.com/SamuelModesto">
      <img alt="chain-of-responsability" src="https://github.com/SamuelModesto/Imagens/blob/master/Imagens%20Minerva/chain-of-responsability.png" />
  </a>
</p>

## Quando Usar
  - Mais de um objeto pode manipular uma solicitação e o manipulador não é conhecido. O manipulador deve ser verificado automaticamente.
  - Você deseja enviar uma solicitação para um dos vários objetos sem especificar o objeto receptor explicitamente.
  - O conjunto de objetos que podem manipular uma solicitação precisa ser especificado dinamicamente.

## Como Executar
 1. Baixe o projeto.
 2. Abra o projeto na IDE de sua preferência.
 3. Execute a classe "App".

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
- Email - **samuelmodestoes@gmail.com**
