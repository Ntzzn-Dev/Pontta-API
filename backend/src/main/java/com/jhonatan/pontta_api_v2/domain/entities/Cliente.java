package com.jhonatan.pontta_api_v2.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Cliente")
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
        this.contato = (contato == null || contato.isBlank()) ? "Sem contato" : contato;
    }

    public void atualizar(String nome, String contato){
        this.setNome(nome);
        this.setContato(contato);
    }
}
