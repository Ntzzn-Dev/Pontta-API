package com.jhonatan.pontta_api_v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.pontta_api_v1.dto.PedProdRequestDTO;
import com.jhonatan.pontta_api_v1.model.Pedido;
import com.jhonatan.pontta_api_v1.model.PedidoProduto;
import com.jhonatan.pontta_api_v1.model.PedidoProdutoId;
import com.jhonatan.pontta_api_v1.model.Produto;
import com.jhonatan.pontta_api_v1.repository.PedidoProdutoRepository;

@Service
public class PedidoProdutoService {
    private final PedidoProdutoRepository pedidoProdutoRepository;
    private final PedidoService pedidoService;
    private final ProdutoService produtoService;

    public PedidoProdutoService(PedidoProdutoRepository pedidoProdutoRepository, PedidoService pedidoService, ProdutoService produtoService){
        this.pedidoProdutoRepository = pedidoProdutoRepository;
        this.pedidoService = pedidoService;
        this.produtoService = produtoService;
    }

    public List<PedidoProduto> listPP(Long id){
        return pedidoProdutoRepository.findByPedidoId(id);
    }

    public PedidoProduto createPP(Long id, PedProdRequestDTO dto) {
        Pedido pedido = pedidoService.readPed(id);
        Produto produto = produtoService.readProd(dto.getIdProduto());

        PedidoProduto pp = new PedidoProduto();

        pp.setPedido(pedido);
        pp.setProduto(produto);
        pp.setQnt(dto.getQnt());
        pp.setValorParcial(produto.getPreco() * dto.getQnt());

        PedidoProduto salvo = pedidoProdutoRepository.save(pp);

        pedidoService.atualizarValorTotal(id);

        return salvo;
    }

    public PedidoProduto readPP(PedidoProdutoId ppid){
        return pedidoProdutoRepository.findById(ppid).orElseThrow(() -> new RuntimeException("Produtos do pedido não encontrados"));
    }

    public PedidoProduto updatePP(Long id, Long prodId, PedProdRequestDTO dto){
        Pedido pedido = pedidoService.readPed(id);
        Produto produto = produtoService.readProd(dto.getIdProduto());

        PedidoProduto antigo = readPP(new PedidoProdutoId(id, prodId));

        pedidoProdutoRepository.delete(antigo);

        PedidoProduto novo = new PedidoProduto();
        novo.setPedido(pedido);
        novo.setProduto(produto);
        novo.setQnt(dto.getQnt());
        novo.setValorParcial(produto.getPreco() * dto.getQnt());
        
        PedidoProduto salvo = pedidoProdutoRepository.save(novo);

        pedidoService.atualizarValorTotal(id);

        return salvo;
    }

    public PedidoProduto deletePP(Long id, Long prodId){
        PedidoProduto pp = readPP(new PedidoProdutoId(id, prodId));
        pedidoProdutoRepository.delete(pp);
        pedidoService.atualizarValorTotal(id);
        return pp;
    }
}
