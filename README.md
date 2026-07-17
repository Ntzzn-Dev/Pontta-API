# Pontta API

**Projeto:** pontta-api  
**Autor:** Nathan  
**GitHub:** [https://github.com/Ntzzn-Dev](https://github.com/Ntzzn-Dev)  
**Data:** 11/07/2026  

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.7-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

## Descrição  

**Pontta API** é uma API REST desenvolvida com **Spring Boot**, criada com o objetivo de praticar e consolidar conceitos do desenvolvimento backend utilizando Java.

O projeto aborda a construção de uma aplicação estruturada seguindo boas práticas, utilizando **Spring Data JPA** para persistência de dados e **PostgreSQL** como banco de dados relacional.

Durante o desenvolvimento foram explorados conceitos como:

- Criação de APIs REST
- Arquitetura em camadas (Controller, Service e Repository)
- Mapeamento objeto-relacional com JPA/Hibernate
- Entidades e relacionamentos entre tabelas
- Configuração de banco de dados
- Validações e tratamento de requisições

## Tecnologias  
- Java 21
- Spring Boot 4.0.7
- PostgreSQL 17
- Maven
- Spring Data JPA

## Arquitetura

O backend foi organizado em camadas:

- DTO → Objetos de entrada e saída da API
- Service → Regras de negócio
- Entity → Modelos do banco de dados
- Repository → Persistência com Spring Data JPA
- Controller → Recebe as requisições HTTP

## Funcionalidades

- Cadastro de clientes
- Cadastro de produtos
- Cadastro de pedidos
- Associação de produtos aos pedidos
- Alteração de cliente do pedido
- Exclusão de registros

### Conhecendo a interface
A pagina principal apresenta apenas uma mensagem de bem vindo, para realmente interagir com o banco de dados, use as abas do menu nav.  
#### Clientes
Em clientes será exibida uma lista com todos os cadastros.  
No botão de cadastrar teremos a criação de um novo registro no banco para o cliente contendo nome e email.  
Cada cliente pode ter seu nome e email alterado, e na mesma tela de edição possui a opção de exclusão do registro.  
#### Produtos
Na aba Produtos, assim como em Clientes, uma lista exibirá tudo.  
E da mesma forma o produto pode ter seu nome, categoria e preço alterados, além da possibilidade de exclusão.  
#### Pedidos
Nessa aba ja diferencia um pouco.
A primeira vista também temos a lista de todos os pedidos.
Assim como antes temos a possibilidade de editar, alterando o cliente do pedido.
Mas nessa mesma aba podemos adicionar produtos aos pedidos.  
Até essa versão é possivel apenas adicionar 1 unidade de cada produto.  

## Modelagem

O projeto possui quatro entidades principais:

- Cliente
- Produto
- Pedido
- Pedido_Produto

Relacionamentos:

- Cliente 1:N Pedido
- Pedido N:N Produto (através de Pedido_Produto)

## Configuração do Banco

Crie um banco PostgreSQL e configure as credenciais no arquivo:

src/main/resources/application-dev.properties

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pontta
spring.datasource.username=postgres
spring.datasource.password=SENHA
```

Caso necessário, execute o arquivo em `src/main/java/com/jhonatan/backend/infrastructure/schema.sql` que contém a criação de todas as tabelas do projeto.  

## Executando backend

A parte em que ficam os endpoint foram feitos em java.  
Após clonar o repositório, navegue até o diretório `pontta/backend` em qualquer terminal.  
Execute: 
```
mvn spring-boot:run
```
E finalmente acesse a api através do caminho padrão:
```
http://localhost:8080
```

Veja todos os ENDPOINTS em [ENDPOINTS.md](ENDPOINTS.md)

## Executando frontend

A parte visual do projeto foi criado puramente com angular.  
Após clonar o repositório, navegue até o diretório `pontta/frontend` em qualquer terminal.    
Execute: 
```
ng serve
```
E finalmente acesse a api através do caminho padrão:
```
http://localhost:4200
```
E então navegue livremente.

## Log de versões
Veja o log de versões em [CHANGELOG.md](CHANGELOG.md)