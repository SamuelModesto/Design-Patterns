<br />
<p >
  <h1> STRATEGY</h1>
  
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
- [Créditos](#Créditos)
- [Licença](#Licença)
- [Contato](#Contato)

## Propósito
|  Nome           | Categoria    | Tag        |  
| :-------------  | :----------- | :--------- |
| Strategy      |  Comportamental | `Gang Of Four (GOF)`|


O Strategy é um padrão de projeto comportamental que permite que você defina uma família de algoritmos, 
separadas em classes, e faça com que os objetos dessas classes sejam intercambiáveis.

## Explicação

### Cenário de aplicação
Enfrentar criaturas mitológicas é uma tarefa extremamente difícil e por isso os guerreiros desenvolveram diferentes estratégias de combate para enfrentar
os maiores inimigos.

### Resumo
O padrão de estratégia permite escolher o algoritmo mais adequado em tempo de execução.

### Wikipedia
O padrão é aplicado em situações em que muitas classes se relacionam e diferem apenas no modo de atuação, com isso o Strategy irá configurar a classe que tenha um dentre muitos comportamentos fornecidos.

### Exemplo de código
Primeiramente deve ser criada a interface de implementação com o método que deverá assumir diferentes comportamentos.
```java 
public interface EstrategiaDeAtaque {
    void atacar();
}
```
Em seguida deve ser implementado a interface nas classes que assumirão diferentes comportamentos:

Classe 1
```java 
public class AtaqueComEspada implements EstrategiaDeAtaque {
    @Override
    public void atacar() {
        System.out.println("O guerreiro saca a espada de prata e ataca cortando o inimigo que possui fraqueza " +
        "quando atacado armas de prata!");
    }
}
```
Classe 2
```java 
public class AtaqueComFlechasEnvenenadas implements EstrategiaDeAtaque {
    @Override
    public void atacar() {
        System.out.println("O guerreiro atira flechas envenanadas com veneno de alho que derrotam facilmente o inimigo");
    }
}
```
Classe 3
```java 
public class AtaqueComFogo implements EstrategiaDeAtaque {
    @Override
    public void atacar() {
        System.out.println("O guerreiro atira um pequeno jarro de óleo no inimigo e com uma tocha queima o monstro!");
    }
}
```
Em seguida vamos implementar a classe Guerreiro, que pode escolher a estratégia de combate de acordo com o inimigo.
```java
public class Guerreiro {
    public void executarAtaque(EstrategiaDeAtaque estrategiaDeAtaque) {
        estrategiaDeAtaque.atacar();
    }
}
```
Finalmente podemos ver o guerreiro em ação

```java
public class App {
    public static void main(String[] args) {
        System.out.println("Um lycan apareceu!");
        Guerreiro guerreiro = new Guerreiro();
        guerreiro.executarAtaque(new AtaqueComEspada());
        System.out.println("Um Monstro de gelo apareceu!");
        guerreiro.executarAtaque(new AtaqueComFogo());
        System.out.println("Um Vampiro apareceu!");
        guerreiro.executarAtaque(new AtaqueComFlechasEnvenenadas()); 

    }
}
```

Saída no console
```
Um lycan apareceu!
O guerreiro saca a espada de prata e ataca cortando o inimigo que possui fraqueza quando atacado armas de prata!
Um Monstro de gelo apareceu!
O guerreiro atira um pequeno jarro de óleo no inimigo e com uma tocha queima o mosntro!
Um Vampiro apareceu!
O guerreiro atira flechas envenanadas com veneno de alho que derrotam facilmente o inimigo
```
## Diagrama de classe

<p align="center">
  <a href="https://github.com/SamuelModesto">
      <img alt="Minerva" src="https://github.com/SamuelModesto/Imagens/blob/master/Imagens%20Minerva/strategy.png" />
  </a>
</p>


## Quando Usar
- Quando muitas classes relacionadas diferem apenas em seu comportamento. As estratégias fornecem uma maneira de configurar uma classe com um dos muitos comportamentos
- Quando Você precisa de diferentes variantes de um algoritmo. por exemplo, você pode definir algoritmos que reflitam diferentes compensações de espaço/tempo.
- Quando um algoritmo usa dados que os clientes não deveriam conhecer. Use o padrão Strategy para evitar a exposição de estruturas de dados complexas específicas de algoritmos.
- Uma classe define muitos comportamentos, e estes aparecem como várias instruções condicionais em suas operações. Em vez de muitas condicionais, abstraia as   condicionais para a sua própria classe de estratégia.

## Como Executar
 1. Baixe o projeto.
 2. Abra o projeto na IDE de sua preferência.
 3. Execute a classe "App" de qualquer padrão de projeto.

## Créditos
- https://refactoring.guru/design-patterns
- https://tinyurl.com/2p9f795f
- https://amzn.to/3ceYsRG
- https://pt.wikipedia.org/wiki/Strategy
## Licença

Distribuído sob a licença do MIT. Consulte `LICENSE` para obter mais informações.

## Contato
Samuel Modesto 
- [Github](https://github.com/SamuelModesto) 
- [LinkedIn](https://www.linkedin.com/in/samuelmodesto)
- Email - **samuelmodestoes@gmail.com**
