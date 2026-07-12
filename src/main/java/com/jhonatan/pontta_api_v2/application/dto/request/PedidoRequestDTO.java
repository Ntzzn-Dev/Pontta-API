package com.jhonatan.pontta_api_v2.application.dto.request;

public class PedidoRequestDTO {
    private Long idCliente;

    public PedidoRequestDTO() {
    }

    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
