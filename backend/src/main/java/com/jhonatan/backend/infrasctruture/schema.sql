CREATE TABLE cliente(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL DEFAULT 'Sem email',
    CONSTRAINT pk_cliente PRIMARY KEY (id)
);

CREATE TABLE produto(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL DEFAULT 'Sem categoria',
    preco NUMERIC(10,2) NOT NULL DEFAULT 0.00,
    CONSTRAINT pk_produto PRIMARY KEY (id)
);

CREATE TABLE pedido(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    cliente_id INTEGER NOT NULL,
    data_pedido DATE NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id),
	CONSTRAINT pk_pedido PRIMARY KEY (id)
);

CREATE TABLE pedido_produto(
	pedido_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL,
    CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produto (id),
    CONSTRAINT fk_pedido FOREIGN KEY (pedido_id) REFERENCES pedido (id),
	CONSTRAINT pk_pedido_produto PRIMARY KEY (pedido_id, produto_id)
);