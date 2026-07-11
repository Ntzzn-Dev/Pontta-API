package com.jhonatan.pontta_api_v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.pontta_api_v1.dto.PedidoRequestDTO;
import com.jhonatan.pontta_api_v1.model.Pedido;
import com.jhonatan.pontta_api_v1.model.PedidoProduto;
import com.jhonatan.pontta_api_v1.repository.PedidoProdutoRepository;
import com.jhonatan.pontta_api_v1.repository.PedidoRepository;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PedidoProdutoRepository pedidoProdutoRepository;
    private final ClienteService clienteService;

    public PedidoService(PedidoRepository pedidoRepository, PedidoProdutoRepository pedidoProdutoRepository, ClienteService clienteService){
        this.pedidoRepository = pedidoRepository;
        this.pedidoProdutoRepository = pedidoProdutoRepository;
        this.clienteService = clienteService;
    }

    public void atualizarValorTotal(Long pedidoId) {
        Pedido pedido = readPed(pedidoId);

        List<PedidoProduto> itens = pedidoProdutoRepository.findByPedidoId(pedidoId);

        double total = 0;

        for (PedidoProduto item : itens) {
            total += item.getValorParcial();
        }

        pedido.setValorTotal(total);

        pedidoRepository.save(pedido);
    }

    public List<Pedido> listPed(){
        return pedidoRepository.findAll();
    }

    public Pedido createPed(PedidoRequestDTO pDto){
        Pedido ped = new Pedido();
        ped.setCliente(clienteService.buscarPorId(pDto.getIdCliente()));
        return pedidoRepository.save(ped);
    }

    public Pedido readPed(Long id){
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
    }

    public Pedido updatePed(Long id, PedidoRequestDTO pDto){
        Pedido pedido = readPed(id);
        pedido.setCliente(clienteService.buscarPorId(pDto.getIdCliente()));

        return pedidoRepository.save(pedido);
    }

    public Pedido deletePed(Long id){
        Pedido ped = readPed(id);
        pedidoRepository.delete(ped);
        return ped;
    }
}
