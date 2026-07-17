package com.jhonatan.backend.domain.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PedidoProdutoId implements Serializable{
    private Long idPedido;
    private Long idProduto;
    public PedidoProdutoId() {
    }
    public PedidoProdutoId(Long idPedido, Long idProduto) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
    }
    public Long getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
    public Long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
       
}