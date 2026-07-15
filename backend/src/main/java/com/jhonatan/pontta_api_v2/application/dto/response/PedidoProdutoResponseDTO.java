package com.jhonatan.pontta_api_v2.application.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoProdutoResponseDTO {
    private String nomeDoCliente;
    private String contatoDoCliente;
    private List<ProdutoEmPedidoResponseDTO> produtos;
    private Double valorTotalPedido;
    private LocalDateTime dataDoPedido;
    
    public PedidoProdutoResponseDTO() {
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }
    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }
    public String getContatoDoCliente() {
        return contatoDoCliente;
    }
    public void setContatoDoCliente(String contatoDoCliente) {
        this.contatoDoCliente = contatoDoCliente;
    }
    public List<ProdutoEmPedidoResponseDTO> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<ProdutoEmPedidoResponseDTO> produtos) {
        this.produtos = produtos;
    }
    public Double getValorTotalPedido() {
        return valorTotalPedido;
    }
    public void setValorTotalPedido(Double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }
    public LocalDateTime getDataDoPedido() {
        return dataDoPedido;
    }
    public void setDataDoPedido(LocalDateTime dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }    
}
