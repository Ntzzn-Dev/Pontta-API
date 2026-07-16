package com.jhonatan.pontta_api_v2.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.pontta_api_v2.application.dto.request.PedidoProdutoRequestDTO;
import com.jhonatan.pontta_api_v2.application.dto.response.PedidoProdutoResponseDTO;
import com.jhonatan.pontta_api_v2.application.dto.response.ProdutoEmPedidoResponseDTO;
import com.jhonatan.pontta_api_v2.domain.entities.Pedido;
import com.jhonatan.pontta_api_v2.domain.entities.PedidoProduto;
import com.jhonatan.pontta_api_v2.domain.entities.PedidoProdutoId;
import com.jhonatan.pontta_api_v2.domain.entities.Produto;
import com.jhonatan.pontta_api_v2.domain.repositories.PedidoProdutoRepository;

@Service
public class PedidoProdutoService {
    private final PedidoProdutoRepository pedidoProdutoRepository;
    private final ProdutoService produtoService;
    private final PedidoService pedidoService;

    public PedidoProdutoService(PedidoProdutoRepository pedidoProdutoRepository, ProdutoService produtoService, PedidoService pedidoService){
        this.pedidoProdutoRepository = pedidoProdutoRepository;
        this.produtoService = produtoService;
        this.pedidoService = pedidoService;
    }

    public void atualizarValorTotal(Long id) {
        Pedido pedido = pedidoService.readPed(id);

        List<PedidoProduto> itens = pedidoProdutoRepository.findByPedidoId(id);

        double total = 0;

        for (PedidoProduto item : itens) {
            total += item.getValorParcial();
        }

        pedido.setValorTotal(total);

        pedidoService.atualizarValor(pedido);
    }

    
    public PedidoProdutoResponseDTO listPP(Long id) {
        List<PedidoProduto> itens = pedidoProdutoRepository.findByPedidoId(id);

        if (itens.isEmpty()) {
            throw new RuntimeException("Pedido não encontrado");
        }

        Pedido pedido = itens.get(0).getPedido();

        PedidoProdutoResponseDTO response = new PedidoProdutoResponseDTO();

        response.setId(pedido.getId());
        response.setNomeDoCliente(pedido.getCliente().getNome());
        response.setContatoDoCliente(pedido.getCliente().getContato());
        response.setValorTotalPedido(pedido.getValorTotal());
        response.setDataDoPedido(pedido.getDataPedido());

        List<ProdutoEmPedidoResponseDTO> produtos = new ArrayList<>();

        for(PedidoProduto item : itens){
            ProdutoEmPedidoResponseDTO dto = new ProdutoEmPedidoResponseDTO();

            dto.setIdProduto(item.getProduto().getId());
            dto.setNomeProduto(item.getProduto().getNome());
            dto.setCategoriaProduto(item.getProduto().getCategoria());
            dto.setValorUnitario(item.getProduto().getPreco());
            dto.setQuantidade(item.getQnt());
            dto.setValorParcial(item.getValorParcial());

            produtos.add(dto);
        }

        response.setProdutos(produtos);
        return response;
    }

    public PedidoProduto createPP(Long id, PedidoProdutoRequestDTO dto){
        Pedido ped = pedidoService.readPed(id);
        PedidoProduto pp = new PedidoProduto();
        Produto prod = produtoService.readProd(dto.getIdProduto());
        pp.atualizar(prod, dto.getQnt());
        pp.setPedido(ped);

        PedidoProduto salvo = pedidoProdutoRepository.save(pp);

        atualizarValorTotal(id);

        return salvo;
    }

    public PedidoProduto readPP(PedidoProdutoId ppid){
        return pedidoProdutoRepository.findById(ppid).orElseThrow(() -> new RuntimeException("Produto do pedido não encontrado"));
    }

    public PedidoProduto updatePP(PedidoProdutoId ppid, PedidoProdutoRequestDTO dto){
        PedidoProduto pp = readPP(ppid);
        Produto prod = produtoService.readProd(dto.getIdProduto());
        pp.atualizar(prod, dto.getQnt());

        PedidoProduto salvo = pedidoProdutoRepository.save(pp);
        
        atualizarValorTotal(ppid.getIdPedido());

        return salvo;
    }

    public PedidoProduto deletePP(PedidoProdutoId ppid){
        PedidoProduto pp = readPP(ppid);
        pedidoProdutoRepository.delete(pp);

        
        atualizarValorTotal(ppid.getIdPedido());

        return pp;
    }
}
