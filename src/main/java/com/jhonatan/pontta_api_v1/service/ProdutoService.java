package com.jhonatan.pontta_api_v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.pontta_api_v1.model.Produto;
import com.jhonatan.pontta_api_v1.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listProds(){
        return produtoRepository.findAll();
    }

    public Produto createProd(Produto prod){
        return produtoRepository.save(prod);
    }

    public Produto readProd(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto updateProd(Long id, Produto prod){
        Produto p = readProd(id);
        p.setNome(prod.getNome());
        p.setCategoria(prod.getCategoria());
        p.setPreco(prod.getPreco());

        return produtoRepository.save(p);
    }

    public Produto deleteProd(Long id){
        Produto p = readProd(id);
        produtoRepository.delete(p);
        return p;
    }
}
