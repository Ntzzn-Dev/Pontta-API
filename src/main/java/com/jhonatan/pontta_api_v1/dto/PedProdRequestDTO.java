package com.jhonatan.pontta_api_v1.dto;

public class PedProdRequestDTO {
    private Long idProduto;
    private Integer qnt;
    
    public PedProdRequestDTO() {
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
