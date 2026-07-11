package com.jhonatan.pontta_api_v1.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    private String contato = "Sem contato";
    
    public Cliente() {
    }

    public Cliente(Long id, @NotBlank String nome, String contato) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
