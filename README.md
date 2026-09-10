Produto API — REST API com Spring Boot e MySQL
API REST para gerenciamento de produtos (CRUD completo), construída para praticar arquitetura em camadas com Spring Boot, Spring Data JPA e MySQL.

Stack
Java 17
Spring Boot 3.5
Spring Data JPA / Hibernate
MySQL
Lombok
Maven
O que a API faz
Método	Endpoint	Descrição
GET	/api/produtos	Lista todos os produtos
GET	/api/produtos/{id}	Busca produto por ID
POST	/api/produtos	Cadastra novo produto
PUT	/api/produtos/{id}	Atualiza produto existente
DELETE	/api/produtos/{id}	Remove produto
Exemplo — POST /api/produtos

Request:

{
    "name": "Notebook",
    "price": 3500.00,
    "quantity": 10
}
Response (201 Created):

{
    "id": 1,
    "name": "Notebook",
    "price": 3500.0,
    "quantity": 10
}
Arquitetura
Camadas separadas por responsabilidade:

Controller  →  recebe e valida a requisição HTTP
Service     →  regras de negócio
Repository  →  acesso ao banco (Spring Data JPA)
Erros são centralizados em um @ControllerAdvice (GlobalExceptionHandler), em vez de tratamento espalhado em cada endpoint.

Como rodar localmente
Pré-requisitos
Java 17+
MySQL 8+
Maven
Passos
Clone o repositório:
git clone https://github.com/LucasPossamaiDev/produto-api.git
Configure suas credenciais de banco em src/main/resources/application.yaml:
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/produto_db?createDatabaseIfNotExist=true
    username: seu_usuario
    password: sua_senha
Rode o projeto:
mvn spring-boot:run
Acesse: http://localhost:8080/api/produtos
O que pratiquei neste projeto
Construção de uma API REST do zero com Spring Boot, incluindo os cinco verbos HTTP básicos de um CRUD.
Separação em camadas (Controller / Service / Repository) e injeção de dependência via construtor.
Mapeamento objeto-relacional com JPA/Hibernate (@Entity, @GeneratedValue, geração automática de tabela).
Tratamento centralizado de exceções com @ControllerAdvice.
Uso do Lombok para reduzir boilerplate (@Data).
Configuração de projeto Maven e gerenciamento de dependências.
Limitações atuais e próximos passos
Sendo direto sobre o estado do projeto, porque isso é mais útil do que vender algo que não existe ainda:

Sem DTOs: a entidade JPA é exposta diretamente na API. Próximo passo é criar ProdutoRequestDTO / ProdutoResponseDTO para não acoplar o contrato da API ao modelo do banco.
Tratamento de erro genérico demais: hoje qualquer RuntimeException vira 404, o que mascara bugs reais. Trocar por exceções customizadas (ProdutoNaoEncontradoException) com status HTTP específicos por caso.
Validação não implementada: a dependência spring-boot-starter-validation já está no projeto, mas ainda falta anotar os campos (@NotBlank, @Positive) e usar @Valid no controller.
Autor
Lucas Possamai de Souza Cursando Engenharia de Software GitHub
