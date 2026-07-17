package com.jhonatan.backend.application.dto.request;

public class PedidoRequestDTO {
    private Long idCliente;

    public PedidoRequestDTO() {
    }

    public PedidoRequestDTO(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    
}
