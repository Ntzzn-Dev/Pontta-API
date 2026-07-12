package com.jhonatan.pontta_api_v2.application.dto.request;

public class ProdutoRequestDTO {
    private String nome;
    private String categoria;
    private Double preco;
    
    public ProdutoRequestDTO() {
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
