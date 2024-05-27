# Tech Challenge - Sistema de Gerenciamento de lanchonete

O sistema tem como intuito fornecer o controle de pedidos para atender os clientes de uma lanchonete de maneira eficiente, gerenciando seus pedidos e estoques de forma adequada.

## Integrantes do Grupo
- RM354032 - Alysson Gustavo Rodrigues Maciel
- RM355969 - Vinicius Duarte Mendes Nepomuceno
- RM354090 - Lucas Pugliese de Morais Barros
- RM353273 - Felipe Pinheiro Dantas

## Rodar instâncias de aplicação e Postgre

1 - Clonar o projeto
```bash
$ git clone https://github.com/ViniNepo/hexagonal-architecture-postech-challenge.git
```
2 - Subir container docker com instância da aplicação e do banco Postgre
```bash
$ docker-compose up --build
```

## Para acessar o swagger e realizar os testes
Rota para acessar Swagger
```url
http://localhost:8080/lanchonete/swagger-ui
```
Rota para acessar Swagger.yml
```url
http://localhost:8080/lanchonete/api-docs
```

## Rotas do Cliente
---
### Criar novo cliente
---
**URL**: `localhost:8080/lanchonete/v1/cliente`

**Método HTTP**: `POST`

**Headers**:
`Content-Type: application/json`

**Corpo da Requisição**:
```json
  {
    "nome": "Test",
    "email": "test@test.com",
    "cpf": "12345678978"
  }
```
---
### Buscar cliente por CPF
---
  
**URL**: `localhost:8080/lanchonete/v1/cliente`

**Método HTTP**: `GET`

**Headers**:
`Accept: application/json`

**Parâmetros de Query**:
- `cpf` (string, obrigatório): CPF de cliente já cadastrado.
