package com.jhonatan.pontta_api_v1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jhonatan.pontta_api_v1.model.Produto;
import com.jhonatan.pontta_api_v1.service.ProdutoService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listProd() {
        return produtoService.listProds();
    }

    @PostMapping
    public Produto createProd(@RequestBody Produto prod){
        return produtoService.createProd(prod);
    }

    @GetMapping("/{id}")
    public Produto readProd(@PathVariable Long id){
        return produtoService.readProd(id);
    }

    @PutMapping("/{id}")
    public Produto updateProd(@PathVariable Long id, @RequestBody Produto prod){
        return produtoService.updateProd(id, prod);
    }

    @DeleteMapping("/{id}")
    public Produto deleteProd(@PathVariable Long id){
        return produtoService.deleteProd(id);
    }    
}
