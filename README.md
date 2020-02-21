# Soc Api

API desenvolvida utilizando Java / Maven / Spring Boot (version 2.2.4) / Mysql 5.7.22

# Pré requisitos

- Docker (https://www.docker.com/)
- Lombok instalado na IDE (IntelliJ IDEA Ex: https://dicasdejava.com.br/como-configurar-o-lombok-no-intellij-idea/)

# 3 Passos para rodar o projeto

1 - Rodar arquivo docker-compose.yml na raiz do projeto. (Ex: docker-compose up -d)

2 - Baixar as dependências do projeto com o Maven.

3 - Startar o projeto da IDE.

# Documentação

## Endpoints

Cliente
```
GET - localhost:8080/api/cliente/listarClientes
```

Produto
```
GET - localhost:8080/api/produto/listarproduto
```

Pedido

```
GET - localhost:8080/api/pedido/consultarPorId/{id}
POST - localhost:8080/api/pedido/salvar
PUT - localhost:8080/api/pedido/alterar
```

