CREATE TABLE IF NOT EXISTS cliente
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    nome varchar(50) NOT NULL,
    contato varchar(50) NOT NULL DEFAULT 'Sem contato',
    CONSTRAINT pk_cliente PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS produto
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    nome varchar(50) NOT NULL,
    categoria varchar(50) NOT NULL DEFAULT 'Sem categoria',
    preco numeric(10,2) DEFAULT 0.00,
    CONSTRAINT pk_produto PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pedido
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    cliente_id integer NOT NULL,
    data_pedido date NOT NULL DEFAULT CURRENT_DATE,
    valor_total numeric(10,2) NOT NULL DEFAULT 0,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id),
	CONSTRAINT pk_pedido PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pedido_produto
(
	pedido_id integer NOT NULL,
    produto_id integer NOT NULL,
	qnt integer NOT NULL DEFAULT 1,
	valor_parcial numeric(10,2) NOT NULL DEFAULT 0,
    CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produto (id),
    CONSTRAINT fk_pedido FOREIGN KEY (pedido_id) REFERENCES pedido (id),
	CONSTRAINT pk_pedido_produto PRIMARY KEY (pedido_id, produto_id)
);
