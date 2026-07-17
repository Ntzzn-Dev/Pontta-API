package com.jhonatan.backend.domain.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_produto")
public class PedidoProduto {
    @EmbeddedId
    private PedidoProdutoId ppid = new PedidoProdutoId();
    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    public PedidoProduto() {
    }
    public PedidoProduto(PedidoProdutoId ppid, Produto produto, Pedido pedido) {
        this.ppid = ppid;
        this.produto = produto;
        this.pedido = pedido;
    }
    public PedidoProdutoId getPpid() {
        return ppid;
    }
    public void setPpid(PedidoProdutoId ppid) {
        this.ppid = ppid;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
