package com.jhonatan.backend.application.dto.request;

public class PedidoProdutoRequestDTO {
    private Long idProduto;
    
    public PedidoProdutoRequestDTO() {
    }

    public Long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
}
