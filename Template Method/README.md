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
  - [Exemplo de Código](#Exemplo-de-código)
- [Diagrama de Classe](#Diagrama-de-Classe)

- [Quando Usar](#Quando-Usar)
- [Como Usar](#Como-Usar)
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

### Exemplo de código

## Diagrama de classe


## Quando Usar


## Como Executar
 1. Baixe o projeto.
 2. Abra o projeto na IDE de sua preferência.
 3. Execute a classe App

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
