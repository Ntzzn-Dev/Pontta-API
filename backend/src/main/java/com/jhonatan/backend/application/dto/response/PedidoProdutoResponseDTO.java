package com.jhonatan.backend.application.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoProdutoResponseDTO {
    private Long id;
    private String nomeDoCliente;
    private String emailDoCliente;
    private List<ProdutoEmPedidoResponseDTO> produtos;
    private LocalDateTime dataDoPedido;
    
    public PedidoProdutoResponseDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }  
    public String getNomeDoCliente() {
        return nomeDoCliente;
    }
    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }
    public String getEmailDoCliente() {
        return emailDoCliente;
    }
    public void setEmailDoCliente(String emailDoCliente) {
        this.emailDoCliente = emailDoCliente;
    }
    public List<ProdutoEmPedidoResponseDTO> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<ProdutoEmPedidoResponseDTO> produtos) {
        this.produtos = produtos;
    }
    public LocalDateTime getDataDoPedido() {
        return dataDoPedido;
    }
    public void setDataDoPedido(LocalDateTime dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }  
}
