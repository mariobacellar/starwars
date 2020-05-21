# StarWars APIs v.01  
![StarWars API](logo.starwars.png)

![Build Status](https://travis-ci.org/mariobacellar/startwarsb2w.svg?branch=master)
![Codacy Badge](https://api.codacy.com/project/badge/Grade/2cd2d9c4edc24cacbdabb69cd9165a43)
![License: Unlicense](https://img.shields.io/badge/license-Unlicense-blue.svg)

## Descrição
Muito <b>simples</b>, mas com um detalhe bastante útil. <p>

Em sua maior parte, este projeto é basicamente um clone do <b>template</b> que a <b>Spring</b> recomenda  em [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/).<p> Esse <b>template</b> já suporta as operações <b>CRUD</b> com o <b>MongoDB</b>.

Mas o que o <b>template</b>  não te ensina é como personlizar a implementação de uma consulta (Query) no MongoDB.<p> 
<b>É isso mesmo! \o/</b> Como todo o acesso ao MongoDB é feito dentro da 'caixa preta' do framework da Spring, se você precisar personalizar um acesso ao MongoDB, ou até mesmo desenvolver um processo de inversão de controle no seu código (IOC), você vai precisar fazer o seguinte:<p>

- Primeiro crie uma interface que representa essa personalização: PlanetaRepositoryCustom<p>
- Depois crie uma classe (PlanetaRepositoryCustomImpl) que implementa sua interface (PlanetaRepositoryCustom). E escreva o que quiser.<p>
- E para que sua implementação faça parte do fluxo HATEOAS do framework Spring, <b>inclua mais uma dependência hieraquica</b> na interface do seu documento (PlanetaRepository). Ainda bem que podemos fazer isso com as Interfaces, não é mesmo?<p>

## Desafio Backend 

Criar uma API (serviço de dados) conforme solicitado pelo desafiante!!! o/

Requisitos:
- API REST<p>
- O Documento (Planeta) devem ter a seguinte estrutura: Nome do planeta; Clima característico do Planeta e Terreno predominante do Planeta<p>
- A API deve possibilitar a inserção manual dos Documentos<p> 
- Para cada planeta devemos ter como obter a quantidade de aparições nos filmes da franquia Star Wars<p>
- Para obter os dados dos planetas, acesse o site [SWAPI The Star Wars API](https://swapi.dev/about)<p>


Funcionalidades desejadas: 
- Adicionar um planeta (com nome, clima e terreno)<p>
- Listar planetas<p>
- Buscar por nome<p>
- Buscar por ID<p>
- Remover planeta<p>


**Instalação**<p>
`https://github.com/mariobacellar/startwarsb2w.git`

**Execução**<p>
`Entre no diretório onde está o starwarsb2w-0.0.1-SNAPSHOT.jar`

`Digite $java -jar ./starwarsb2w-0.0.1-SNAPSHOT.jar br.com.b2w.starwars.StarWarsB2wApplication`

`Assim que a API subir, digite $curl http://localhost:8080/planeta/search`


**Author**
<p><i><u>Mario da Costa Bacellar</u></i> é <i>SME em Integração de Sistemas</i> atualmente trabalha no mercado de <b>Banking</b> como <i>Arquiteto de Solução com foco em Integração Digital</i>. Ele é pós graduado pela <b>Universidade Federal do Rio de Janeiro</b> (@2015) em <b>Engenharia da Computação (MBA)</b>. Atuando no mercado corporativo em integração de sistemas (SOA) desde 2001, passa o tempo publicando textos e códigos simples por ai \o/
<p>

**Fale Comigo o/**
<li>mario.bacellar@gmail.com</li>
<li>https://www.linkedin.com/in/mariobacellar<https://www.linkedin.com/in/mariobacellar></li>

<p>
  

### Veja Também
* [Aplicação tá pronta. Mas e as APIs? Salvo pelo Node. (Node e Oracle?)](https://www.linkedin.com/pulse/aplica%C3%A7%C3%A3o-t%C3%A1-pronta-mas-e-apis-salvo-pelo-nodejs-mais-mario-bacellar/)



### Reference Documentation
* [Accessing MongoDB Data with REST - Guide](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Accessing MongoDB Data with REST - Github](https://github.com/Hanope/spring-guides/issues/32)
* [HAL - Hypertext Application Language](http://stateless.co/hal_specification.html)

____
©2020 No Copyright, You can share! \o/

This code was developed in the middles of COVID outbreak in quarantine regime. 
