# APIREST_VENDAS

Projeto backend em Java com Spring Boot para gerenciamento de produtos, usando persistência relacional e migrações versionadas.

## Stack do sistema

- **Java 25**
- **Spring Boot 3.5.14**
  - spring-boot-starter-web
  - spring-boot-starter-data-jpa
  - spring-boot-starter-validation
- **PostgreSQL** (driver JDBC)
- **Flyway** para migração de banco
- **Lombok** para redução de boilerplate
- **Maven Wrapper (mvnw)** para build e dependências

## Funcionalidades atuais

- Estrutura base para API REST de produtos
- Entidade `Product` mapeada com JPA
- DTO de entrada com validações (`ProductRequestDTO`)
- Repositório JPA (`ProductRepository`) para operações de persistência
- Serviço de domínio (`ProductService`) com criação de produto
- Migração inicial de banco (`V1__create-table-products.sql`) criando a tabela `products`

## Arquitetura utilizada

O projeto segue uma arquitetura em camadas, com separação de responsabilidades:

- **Controller**: camada de entrada HTTP (a classe `ProductController` já existe, mas ainda sem endpoints implementados)
- **Service**: regras de negócio e orquestração (`ProductService`)
- **Repository**: acesso a dados com Spring Data JPA (`ProductRepository`)
- **Domain**: modelo de domínio e contratos de entrada (`Product`, `ProductRequestDTO`)
- **Infraestrutura de dados**: Flyway para evolução de schema e PostgreSQL como banco relacional

## Estrutura do projeto

```text
src/
 ├─ main/
 │   ├─ java/com/br/crud/
 │   │   ├─ CrudApplication.java
 │   │   ├─ controller/
 │   │   │   └─ ProductController.java
 │   │   └─ domain/products/
 │   │       ├─ Product.java
 │   │       ├─ ProductRequestDTO.java
 │   │       ├─ ProductRepository.java
 │   │       └─ ProductService.java
 │   └─ resources/
 │       ├─ application.properties
 │       └─ db/migration/
 │           └─ V1__create-table-products.sql
 └─ test/
     └─ java/com/br/crud/
         └─ CrudApplicationTests.java
```

## Sobre a API

Atualmente a API está com a fundação pronta (domínio, persistência, validações e migration), mas os endpoints HTTP ainda não foram expostos no `ProductController`.

Com base na estrutura existente, ela está preparada para oferecer um CRUD de produtos com operações como:

- `POST /products` para cadastro
- `GET /products` para listagem
- `GET /products/{id}` para consulta por id
- `PUT/PATCH /products/{id}` para atualização
- `DELETE /products/{id}` para remoção

## O que pode ter no futuro

Evoluções recomendadas para as próximas versões:

- Implementação completa dos endpoints REST no controller
- Padronização de respostas e tratamento global de erros
- Paginação, ordenação e filtros na listagem de produtos
- Documentação automática com Swagger/OpenAPI
- Testes unitários, de integração e de controller
- Autenticação/autorização (ex.: JWT)
- Perfis de ambiente (`dev`, `test`, `prod`) e variáveis externas para credenciais
- Containerização com Docker e pipeline CI/CD
- Observabilidade (logs estruturados, métricas e health checks)

## Configuração básica

No `application.properties` atual, o datasource está configurado para PostgreSQL local:

- URL: `jdbc:postgresql://localhost:5432/product-api`
- Usuário: `postgres`
- Senha: definida no arquivo local (`spring.datasource.password`)

> Recomendação: nunca versionar ou reutilizar senhas fracas em ambientes compartilhados/produção; prefira variáveis de ambiente e segredos gerenciados.
