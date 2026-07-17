# Endpoints
Documentação sobre entradas de cada endpoint.

## Clientes

| Método | Endpoint | Descrição | Body |
|---|---|---|---|
| GET | `/clientes` | Lista todos os clientes | Não |
| GET | `/clientes/{id}` | Busca um cliente pelo ID | Não |
| POST | `/clientes` | Cadastra um novo cliente | Sim |
| PUT | `/clientes/{id}` | Atualiza um cliente existente | Sim |
| DELETE | `/clientes/{id}` | Remove um cliente pelo ID | Não |

#### POST ou PUT `/clientes`
Body:
```json
{
    "nome": "Fernando",
    "email": "fernander@gmail.com"
}
```

## Produtos

| Método | Endpoint | Descrição | Body |
|---|---|---|---|
| GET | `/produtos` | Lista todos os produtos | Não |
| GET | `/produtos/{id}` | Busca um produto pelo ID | Não |
| POST | `/produtos` | Cria um novo produto | Sim |
| PUT | `/produtos/{id}` | Atualiza um produto existente | Sim |
| DELETE | `/produtos/{id}` | Remove um produto pelo ID | Não |

#### POST ou PUT `/produtos`
Body:
```json
{
    "nome": "Tabua Cedro 2m²",
    "categoria": "Madeira",
    "preco": 100.5
}
```

## Pedidos

| Método | Endpoint | Descrição | Body |
|---|---|---|---|
| GET | `/pedidos` | Lista todos os pedidos | Não |
| GET | `/pedidos/{id}` | Busca um pedido pelo ID | Não |
| POST | `/pedidos` | Cria um novo pedido | Sim |
| PUT | `/pedidos/{id}` | Atualiza um pedido existente | Sim |
| DELETE | `/pedidos/{id}` | Remove um pedido pelo ID | Não |

#### POST ou PUT `/pedidos`
Body:
```json
{
    "idCliente": 1
}
```

## Produtos do Pedido

| Método | Endpoint | Descrição | Body |
|---|---|---|---|
| GET | `/pedidos/{id}/produtos` | Lista os produtos de um pedido | Não |
| POST | `/pedidos/{id}/produtos` | Adiciona um produto ao pedido | Sim |
| DELETE | `/pedidos/{id}/produtos/{idProduto}` | Remove um produto do pedido | Não |

#### POST `/pedidos/:id/produtos`
Body:
```json
{
	"idProduto": 1
}
```