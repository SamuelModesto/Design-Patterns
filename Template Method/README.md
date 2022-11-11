<br />
<p >
  <h1>TEMPLATE METHOD</h1>
  
</p>


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
| Nome              | Categoria    | Tag        |  
|:------------------| :----------- | :--------- |
| `Template Method` |  Comportamental | Gang Of Four (GOF)|

O Template Method é um padrão de projeto comportamental que permite definir o esqueleto de um algoritmo em uma classe base e delegar para as subclasses outras etapas sem alterar a estrutura geral do algoritmo.


## Explicação
### Cenário de aplicação
Suponha que queremos preparar um café da marca Três Corações, para isso é preciso seguir alguns passos como: ferver a água, adicionar leite, adicionar açucar e adicionar o café três corações. Agora queremos preparar um café porém da marca Nescafé, para realizar o preparo, também é necessário seguir os mesmos passos do café Três Corações como:
ferver a água, adicionar leite, adicionar açucar e adicionar o Nescafé. O processo de preparo é quase o mesmo ou seja: ferver a água, adicionar leite, adicionar açucar e adicionar o tipo de café (Três Corações ou Nescafé) e com base no café escolhido ele criará o Café Nescafé ou o Café Três Corações. Portanto, como sugere o padrão Template Method, podemos criar uma etapa comum do processo em uma super classe de preparo do café e delegar a parte específica deste preparo para as subclasses.

### Resumo
O padrão Template Method descreve as etapas gerais em uma classe pai e permite que as implementações filhas concretas definam os detalhes.

### Wikipedia
O método template é um método em uma superclasse, geralmente uma superclasse abstrata, e define o esqueleto de uma operação em termos de várias etapas de alto nível. Essas etapas são implementadas por métodos auxiliares adicionais na mesma classe que o método de modelo .

### Diagrama de classe
<p align="center">
  <a href="https://github.com/SamuelModesto">
      <img alt="template-method" src="https://github.com/SamuelModesto/Imagens/blob/master/Imagens%20Minerva/template-method.png" />
  </a>
</p>

### Exemplo de código

Primeiramente criamos a classe abstrata onde fica a implementação do método que será o template e também deve conter um ou mais passos que serão implementados nas subclasses, nesse caso o método abstrato que será implementado nas subclasses é o adicionarTipoCafe().
```java
package github.samuelmodesto.minerva.model;

public abstract class Cafe {

    public void prepararCafeTemplate() {
        ferverAgua();
        adicionarLeite();
        adicionarAcucar();
        adicionarTipoCafe();
    }

    private void ferverAgua() {
        System.out.println("Agua fervida!");
    }

    private void adicionarLeite() {
        System.out.println("Leite adicionado");
    }

    private void adicionarAcucar() {
        System.out.println("Açucar adicionado");
    }

    protected abstract void adicionarTipoCafe();
}
```
Em seguida criamos as classes concretas que vão herdar da classe abstrata. Note que quando herdamos de uma classe abstrata, precisamos implementar os métodos abstratos dela, dessa forma, delegamos para a subclasse apenas algumas etapas do processo que nesse caso é o adicionarTipoCafe().
```java 
package github.samuelmodesto.minerva.model;

public class TresCoracoes extends Cafe {
    @Override
    protected void adicionarTipoCafe() {
        System.out.println("Três Corações Adicionado!");
        System.out.println("##########################");
        System.out.println("          {\n" +
                "       }   }   {\n" +
                "      {   {  }  }\n" +
                "       }   }{  {\n" +
                "      {  }{  }  }\n" +
                "     ( }{ }{  { )\n" +
                "    .-{   }   }-.\n" +
                "   ( ( } { } { } )\n" +
                "   |`-.._____..-'|\n" +
                "   |             ;--.\n" +
                "   |            (__  \\\n" +
                "   |     Café    | )  )\n" +
                "   |Três Corações|/  /\n" +
                "   |             /  / \n" +
                "   |            (  /\n" +
                "   \\             /'\n" +
                "    `-.._____..-'");
    }
}
```
O mesmo procedimento deve ser aplicado para todas as subclasses que fazem parte desse processo de preparar café.
```java 
package github.samuelmodesto.minerva.model;

public class Nescafe extends Cafe {
    @Override
    protected void adicionarTipoCafe() {
        System.out.println("Nescafé adicionado");
        System.out.println("####################");
        System.out.println("          {\n" +
                "       }   }   {\n" +
                "      {   {  }  }\n" +
                "       }   }{  {\n" +
                "      {  }{  }  }\n" +
                "     ( }{ }{  { )\n" +
                "    .-{   }   }-.\n" +
                "   ( ( } { } { } )\n" +
                "   |`-.._____..-'|\n" +
                "   |             ;--.\n" +
                "   |            (__  \\\n" +
                "   |   Nescafé   | )  )\n" +
                "   |             |/  /\n" +
                "   |             /  / \n" +
                "   |            (  /\n" +
                "   \\             /'\n" +
                "    `-.._____..-'");
    }
}

```
Finalmente na classe de execução, basta instanciar o objeto que deseja preparar o café e invocar o método prepararCafeTemplate().
```java 
package github.samuelmodesto.minerva;

import github.samuelmodesto.minerva.model.Nescafe;
import github.samuelmodesto.minerva.model.TresCoracoes;

public class App {
    public static void main(String[] args) {
        System.out.println("PREPARO DO CAFÉ TRÊS CORAÇÕES");
        TresCoracoes tresCoracoes = new TresCoracoes();
        tresCoracoes.prepararCafeTemplate();

        System.out.println("\n\n");

        System.out.println("PREPARO DO NESCAFÉ");
        Nescafe nescafe = new Nescafe();
        nescafe.prepararCafeTemplate();
    }
}

```

Saída no console
```
PREPARO DO CAFÉ TRÊS CORAÇÕES
Agua fervida!
Leite adicionado
Açucar adicionado
Três Corações Adicionado!
##########################
          {
       }   }   {
      {   {  }  }
       }   }{  {
      {  }{  }  }
     ( }{ }{  { )
    .-{   }   }-.
   ( ( } { } { } )
   |`-.._____..-'|
   |             ;--.
   |            (__  \
   |     Café    | )  )
   |Três Corações|/  /
   |             /  / 
   |            (  /
   \             /'
    `-.._____..-'



PREPARO DO NESCAFÉ
Agua fervida!
Leite adicionado
Açucar adicionado
Nescafé adicionado
##########################
          {
       }   }   {
      {   {  }  }
       }   }{  {
      {  }{  }  }
     ( }{ }{  { )
    .-{   }   }-.
   ( ( } { } { } )
   |`-.._____..-'|
   |             ;--.
   |            (__  \
   |   Nescafé   | )  )
   |             |/  /
   |             /  / 
   |            (  /
   \             /'
    `-.._____..-'
```

## Quando Usar
- Quando precisamos que as subclasses estendam apenas etapas particulares de um algoritmo, mas não todo o algoritmo e sua estrutura.
- Quando precisamos ter várias classes que contém algoritmos quase idênticos com algumas pequenas diferenças. Como resultado, temos um ganho de isolamento e modularização de código.


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
