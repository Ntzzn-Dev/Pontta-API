# Pontta API

**Projeto:** pontta-api  
**Autor:** Nathan  
**GitHub:** [https://github.com/Ntzzn-Dev](https://github.com/Ntzzn-Dev)  
**Data:** 11/07/2026  

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.16-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
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
- Spring Boot 3.5.16
- PostgreSQL 17
- Maven
- Spring Data JPA

## Endpoints
Veja todos os ENDPOINTS em [ENDPOINTS.md](ENDPOINTS.md)

## Configuração do Banco

Crie um banco PostgreSQL e configure as credenciais no arquivo:

src/main/resources/application-dev.properties

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pontta
spring.datasource.username=postgres
spring.datasource.password=SENHA
```

## Log de versões
### v1.0
- Estrutura inicial da API
- Configuração do Spring Boot
- Integração com PostgreSQL
- Implementação das entidades Cliente, Produto e Pedido
- Criação dos CRUDs principais
- Primeiros relacionamentos utilizando JPA/Hibernate