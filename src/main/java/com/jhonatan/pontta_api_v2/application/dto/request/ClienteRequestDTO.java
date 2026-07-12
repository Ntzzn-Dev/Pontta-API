package com.jhonatan.pontta_api_v2.application.dto.request;

public class ClienteRequestDTO {
    private String nome;
    private String contato;
    
    public ClienteRequestDTO() {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
}
