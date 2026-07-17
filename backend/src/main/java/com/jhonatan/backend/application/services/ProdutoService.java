package com.jhonatan.backend.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.backend.domain.entities.Produto;
import com.jhonatan.backend.domain.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;
    

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> list(){
        return produtoRepository.findAll();
    }

    public Produto create(Produto obj){
        return produtoRepository.save(obj);
    }

    public Produto read(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto update(Long id, Produto obj){
        Produto oldObj = read(id);
        oldObj.setNome(obj.getNome());
        oldObj.setCategoria(obj.getCategoria());
        oldObj.setPreco(obj.getPreco());
        return produtoRepository.save(oldObj);
    }

    public Produto delete(Long id){
        Produto obj = read(id);
        produtoRepository.delete(obj);
        return obj;
    }
}
