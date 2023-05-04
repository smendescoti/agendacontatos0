# Agenda de Contatos

Este é um projeto em Java utilizando Spring MVC e JDBC para acesso a banco de dados PostGreSQL. A Agenda de Contatos permite ao usuário armazenar, atualizar e excluir informações de contatos em um banco de dados.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter os seguintes pré-requisitos instalados:

- [PostgreSQL](https://www.postgresql.org/download/)
- [Apache Tomcat](https://tomcat.apache.org/download-90.cgi)

## Configuração do Banco de Dados

Antes de executar o projeto, é necessário criar um banco de dados no PostgreSQL com o nome "bd_agendacontatos". Em seguida, execute o arquivo script.sql localizado na raiz do projeto para criar as tabelas necessárias para o funcionamento da aplicação. Não deixe de modificar a classe ConnectionFactory colocando o usuário e senha do seu servidor de banco de dados do PostGreSQL.

## Executando a aplicação

Para executar a aplicação, faça o download do código-fonte do projeto e, em seguida, compile-o utilizando uma IDE como Eclipse ou IntelliJ IDEA. Em seguida, copie o arquivo .war gerado para a pasta "webapps" do Tomcat e inicie o servidor.

Após iniciar o servidor, acesse a aplicação em um navegador web, utilizando o endereço: `http://localhost:8080/nome-do-projeto`
