package com.jhonatan.pontta_api_v2.application.dto.response;

public class ProdutoEmPedidoResponseDTO {
    private String nomeProduto;
    private String categoriaProduto;
    private Double valorUnitario;
    private Integer quantidade;
    private Double valorParcial;

    public ProdutoEmPedidoResponseDTO() {
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public String getCategoriaProduto() {
        return categoriaProduto;
    }
    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
    public Double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Double getValorParcial() {
        return valorParcial;
    }
    public void setValorParcial(Double valorParcial) {
        this.valorParcial = valorParcial;
    }
}
