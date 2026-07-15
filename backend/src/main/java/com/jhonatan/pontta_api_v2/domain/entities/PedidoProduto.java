package com.jhonatan.pontta_api_v2.domain.entities;

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
    private Integer qnt = 1;
    private Double valorParcial = 0.00;
    
    public PedidoProduto() {
    }
    public PedidoProduto(PedidoProdutoId ppid, Produto produto, Pedido pedido, Integer qnt, Double valorParcial) {
        this.ppid = ppid;
        this.produto = produto;
        this.pedido = pedido;
        this.qnt = qnt;
        this.valorParcial = valorParcial;
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
    public Integer getQnt() {
        return qnt;
    }
    public void setQnt(Integer qnt) {
        this.qnt = qnt == null ? 1 : qnt;
    }
    public Double getValorParcial() {
        return valorParcial;
    }
    public void setValorParcial(Double valorParcial) {
        this.valorParcial = valorParcial == null ? 0.00 : valorParcial;
    }

    public void atualizar(Produto produto, Integer qnt){
        this.setProduto(produto);
        this.setQnt(qnt);
        recalcularPrecoParcial(produto.getPreco(), qnt);
    }

    public void recalcularPrecoParcial(Double preco, Integer qnt){
        this.valorParcial = preco * qnt;
    }
}
