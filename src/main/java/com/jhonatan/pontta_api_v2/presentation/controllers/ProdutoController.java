package com.jhonatan.pontta_api_v2.presentation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonatan.pontta_api_v2.application.dto.request.ProdutoRequestDTO;
import com.jhonatan.pontta_api_v2.application.services.ProdutoService;
import com.jhonatan.pontta_api_v2.domain.entities.Produto;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listProduto() {
        return produtoService.listProd();
    }

    @PostMapping
    public Produto createProduto(@RequestBody ProdutoRequestDTO dto){
        return produtoService.createProd(dto);
    }

    @GetMapping("/{id}")
    public Produto readProduto(@PathVariable Long id){
        return produtoService.readProd(id);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody ProdutoRequestDTO dto){
        return produtoService.updateProd(id, dto);
    }

    @DeleteMapping("/{id}")
    public Produto deleteProduto(@PathVariable Long id){
        return produtoService.deleteProd(id);
    }
}
