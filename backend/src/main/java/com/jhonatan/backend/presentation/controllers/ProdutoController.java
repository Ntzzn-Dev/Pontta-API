package com.jhonatan.backend.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonatan.backend.application.services.ProdutoService;
import com.jhonatan.backend.domain.entities.Produto;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> list(){
        return produtoService.list();
    }

    @PostMapping
    public Produto create(@RequestBody Produto obj){
        return produtoService.create(obj);
    }

    @GetMapping("/{id}")
    public Produto read(@PathVariable Long id){
        return produtoService.read(id);
    }
    
    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto obj){
        return produtoService.update(id, obj);
    }

    @DeleteMapping("/{id}")
    public Produto delete(@PathVariable Long id){
        return produtoService.delete(id);
    }
}
