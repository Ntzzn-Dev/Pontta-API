package com.jhonatan.backend.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.backend.application.dto.request.PedidoProdutoRequestDTO;
import com.jhonatan.backend.application.dto.response.PedidoProdutoResponseDTO;
import com.jhonatan.backend.application.dto.response.ProdutoEmPedidoResponseDTO;
import com.jhonatan.backend.domain.entities.Pedido;
import com.jhonatan.backend.domain.entities.PedidoProduto;
import com.jhonatan.backend.domain.entities.PedidoProdutoId;
import com.jhonatan.backend.domain.entities.Produto;
import com.jhonatan.backend.domain.repositories.PedidoProdutoRepository;

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

    public PedidoProdutoResponseDTO listPP(Long id) {
        List<PedidoProduto> itens = pedidoProdutoRepository.findByPedidoId(id);

        if (itens.isEmpty()) {
            throw new RuntimeException("Pedido não encontrado");
        }

        Pedido pedido = itens.get(0).getPedido();

        PedidoProdutoResponseDTO response = new PedidoProdutoResponseDTO();

        response.setId(pedido.getId());
        response.setNomeDoCliente(pedido.getCliente().getNome());
        response.setEmailDoCliente(pedido.getCliente().getEmail());
        response.setDataDoPedido(pedido.getDataPedido());

        List<ProdutoEmPedidoResponseDTO> produtos = new ArrayList<>();

        for(PedidoProduto item : itens){
            ProdutoEmPedidoResponseDTO dto = new ProdutoEmPedidoResponseDTO();

            dto.setIdProduto(item.getProduto().getId());
            dto.setNomeProduto(item.getProduto().getNome());
            dto.setCategoriaProduto(item.getProduto().getCategoria());
            dto.setValorUnitario(item.getProduto().getPreco());

            produtos.add(dto);
        }

        response.setProdutos(produtos);
        return response;
    }

    public PedidoProduto createPP(Long id, PedidoProdutoRequestDTO dto){
        Pedido ped = pedidoService.read(id);
        PedidoProduto pp = new PedidoProduto();
        Produto prod = produtoService.read(dto.getIdProduto());
        pp.setPedido(ped);
        pp.setProduto(prod);

        return pedidoProdutoRepository.save(pp);
    }

    public PedidoProduto readPP(PedidoProdutoId ppid){
        return pedidoProdutoRepository.findById(ppid).orElseThrow(() -> new RuntimeException("Produto do pedido não encontrado"));
    }

    public PedidoProduto updatePP(PedidoProdutoId ppid, PedidoProdutoRequestDTO dto){
        PedidoProduto pp = readPP(ppid);
        Produto prod = produtoService.read(dto.getIdProduto());
        pp.setProduto(prod);

        return pedidoProdutoRepository.save(pp);
    }

    public PedidoProduto deletePP(PedidoProdutoId ppid){
        PedidoProduto pp = readPP(ppid);
        pedidoProdutoRepository.delete(pp);
        return pp;
    }
}
