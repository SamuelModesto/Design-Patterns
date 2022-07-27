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
A Rainha Daenerys escreve ordens em um pergaminho para o comandante do seu exército dos imaculados, que pode executar ele mesmo ou pedir para um oficial mais proximo que por sua vez também pode executar ou ordenar que um soldado raso execute o trabalho. O comandante, o oficial e o soldado raso representam a cadeia de responsabilidade.
### Resumo
Esse padrão ajuda a construir uma cadeia de objetos. Uma solicitação entra de um lado e continua indo de um objeto para outro até encontrar um manipulador adequado.
### Wikipedia
No projeto orientado a objetos, o padrão de cadeia de responsabilidade é um padrão de projeto comportamental que consiste em uma fonte de objetos de comando e uma série de objetos de processamento. Cada objeto de processamento contém uma lógica que define os tipos de objetos de comando que ele pode manipular, o restante é passado para o próximo objeto de processamento na cadeia.
### Exemplo de código

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
