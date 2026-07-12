package com.jhonatan.pontta_api_v2.application.dto.request;

public class PedidoProdutoRequestDTO {
    private Long idProduto;
    private Integer qnt;
    
    public PedidoProdutoRequestDTO() {
    }

    public Long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
    public Integer getQnt() {
        return qnt;
    }
    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }
}
