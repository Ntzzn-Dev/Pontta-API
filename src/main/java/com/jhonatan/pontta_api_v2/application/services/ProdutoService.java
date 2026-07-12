package com.jhonatan.pontta_api_v2.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.pontta_api_v2.application.dto.request.ProdutoRequestDTO;
import com.jhonatan.pontta_api_v2.domain.entities.Produto;
import com.jhonatan.pontta_api_v2.domain.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listProd(){
        return produtoRepository.findAll();
    }

    public Produto createProd(ProdutoRequestDTO dto){
        Produto prod = new Produto();
        prod.atualizar(dto.getNome(), dto.getCategoria(), dto.getPreco());
        return produtoRepository.save(prod);
    }

    public Produto readProd(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto updateProd(Long id, ProdutoRequestDTO dto){
        Produto prod = readProd(id);
        prod.atualizar(dto.getNome(), dto.getCategoria(), dto.getPreco());
        return produtoRepository.save(prod);
    }

    public Produto deleteProd(Long id){
        Produto prod = readProd(id);
        produtoRepository.delete(prod);
        return prod;
    }
}
