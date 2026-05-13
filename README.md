# Produto API — REST API com Spring Boot e MySQL

API REST completa para gerenciamento de produtos, desenvolvida com Java, Spring Boot e MySQL.

## Tecnologias

- Java 17
- Spring Boot 3.5
- Spring Data JPA
- MySQL
- Lombok
- Maven

## Funcionalidades

- Listar todos os produtos
- Buscar produto por ID
- Cadastrar novo produto
- Atualizar produto existente
- Deletar produto
- Tratamento de erros com mensagens claras (404 para produto não encontrado)

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/api/produtos` | Lista todos os produtos |
| GET | `/api/produtos/{id}` | Busca produto por ID |
| POST | `/api/produtos` | Cadastra novo produto |
| PUT | `/api/produtos/{id}` | Atualiza produto |
| DELETE | `/api/produtos/{id}` | Deleta produto |

## Exemplo de requisição

**POST /api/produtos**
```json
{
    "name": "Notebook",
    "price": 3500.00,
    "quantity": 10
}
```

**Resposta:**
```json
{
    "id": 1,
    "name": "Notebook",
    "price": 3500.0,
    "quantity": 10
}
```

## Arquitetura

O projeto segue o padrão de camadas:

```
Controller  →  recebe as requisições HTTP
Service     →  regras de negócio
Repository  →  acesso ao banco de dados
```

## Como rodar o projeto

### Pré-requisitos
- Java 17+
- MySQL 8+
- Maven

### Configuração

1. Clone o repositório:
```bash
git clone https://github.com/LucasPossamaiDev/produto-api.git
```

2. Configure o banco de dados em `src/main/resources/application.yaml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/produto_db?createDatabaseIfNotExist=true
    username: seu_usuario
    password: sua_senha
```

3. Rode o projeto:
```bash
mvn spring-boot:run
```

4. Acesse: `http://localhost:8080/api/produtos`

## Autor

**Lucas Possamai de Souza**  
Cursando Engenharia de Software  
[GitHub](https://github.com/LucasPossamaiDev)
