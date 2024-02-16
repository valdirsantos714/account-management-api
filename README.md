# Account Management API With Spring Boot

## About this repository
This repository contains an efficient and easy-to-use Api for applications that need to manage users, that have bank accounts and that have a list of products.

## Purposes of Use:

- User, Account or product query: Users can easily enter, search, view and delete information about available products, accounts and users.

- Inventory Control: Provides updated information on the available quantity of each product in stock and on users and accounts.

- Simple Integration: Designed to be easily integrated into frontend applications, e-commerce systems, or any other platform that needs to manage accounts, users and products.

- ## Functionalities
- Insert
- To update
- Delete
- To view
- View by ID

## Technologies used
- Java 17
- Spring Boot
- Spring Data JPA
- Lombok
- Validation
- Maven
- MySQL Driver
- MySQL Database
- JPA/Hibernate

## Prerequisites
Make sure you have the following tools installed on your machine:

- Java Development Kit (JDK) - version 17.
- Maven - for dependency management and project construction.

## Installation
- Clone the repository:
- `$ git clone https://github.com/Fernanda-Kipper/live-crud-java-spring.git`
- Install dependencies with Maven
- Configure the database properties in the `application.properties` and `application-dev.properties` file.
- Run the application locally.

## How to make Requests

Place in Postman or any other collaboration platform for API development the link `http://localhost:8080/` with the following endpoints:

- `GET /product` - To return a list of all users, account or products.

- `POST /product` - To save a new object to the database.

- `PUT /product` - To change an object.

- `DELETE /product/{id}` - To delete a specific object.

===============================================================

# Api de Gerenciamento de Conta Com Spring Boot

## Sobre este repositório
Este repositório contém uma Api eficiente e fácil de usar para aplicações que necessitam gerenciar usuários, que possuam contas em bancos e que tenham uma lista de produtos.

## Finalidades de Uso:

- Consulta de Usuários, Conta ou produtos: Os usuários podem facilmente inserir, buscar, visualizar e deletar informações sobre produtos, contas e usuários disponíveis.

- Controle de Estoque: Fornece informações atualizadas sobre a quantidade disponível de cada produto em estoque e sobre os usuários e contas.

- Integração Simples: Projetado para ser facilmente integrado a aplicações frontend, sistemas de e-commerce, ou qualquer outra plataforma que necessite gerenciar contas, usuários e produtos.

- ## Funcionalidades
- Inserir
- Atualizar
- Deletar
- Visualizar
- Visualizar por Id

## Tecnologias utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Lombok
- Validation
- Maven
- MySQL Driver
- Banco de Dados MySQL
- JPA / Hibernate

## Pré-requisitos
Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Java Development Kit (JDK) - versão 17.
- Maven - para gerenciamento de dependências e construção do projeto.

## Instalação
- Clone o repositório:
- `$ git clone https://github.com/Fernanda-Kipper/live-crud-java-spring.git`
- Instale dependências com Maven
- Configure as propriedades do banco de dados no arquivo `application.properties` e no `application-dev.properties`.
- Execute a aplicação localmente.

## Como fazer Requisições

Coloque no Postman ou em qualquer outra plataforma de colaboração para desenvolvimento de API o link `http://localhost:8080/` com os seguintes endpoints:

- `GET /product` - Para retornar uma lista de todos os usuários, conta ou produtos.

- `POST /product` - Para salvar um novo objeto no banco de dados.

- `PUT /product` - Para alterar um objeto.

- `DELETE /product/{id}` - Para excluir um determinado objeto.
  
