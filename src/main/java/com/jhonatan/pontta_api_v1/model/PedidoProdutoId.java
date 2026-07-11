package com.jhonatan.pontta_api_v1.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class PedidoProdutoId implements Serializable {

    private Long pedidoId;

    private Long produtoId;

    public PedidoProdutoId() {
    }

    public PedidoProdutoId(Long pedidoId, Long produtoId) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoProdutoId)) return false;
        PedidoProdutoId that = (PedidoProdutoId) o;
        return Objects.equals(pedidoId, that.pedidoId)
                && Objects.equals(produtoId, that.produtoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, produtoId);
    }
}