package com.jhonatan.pontta_api_v2.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.pontta_api_v2.application.dto.request.PedidoRequestDTO;
import com.jhonatan.pontta_api_v2.domain.entities.Cliente;
import com.jhonatan.pontta_api_v2.domain.entities.Pedido;
import com.jhonatan.pontta_api_v2.domain.repositories.PedidoRepository;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;

    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService){
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
    }

    public void atualizarValor(Pedido ped){
        pedidoRepository.save(ped);
    }

    public List<Pedido> listPed(){
        return pedidoRepository.findAll();
    }

    public Pedido createPed(PedidoRequestDTO dto){
        Pedido ped = new Pedido();
        Cliente cli = clienteService.readCli(dto.getIdCliente());
        ped.atualizar(cli);
        return pedidoRepository.save(ped);
    }

    public Pedido readPed(Long id){
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido updatePed(Long id, PedidoRequestDTO dto){
        Pedido ped = readPed(id);
        Cliente cli = clienteService.readCli(dto.getIdCliente());
        ped.atualizar(cli);
        return pedidoRepository.save(ped);
    }

    public Pedido deletePed(Long id){
        Pedido ped = readPed(id);
        pedidoRepository.delete(ped);
        return ped;
    }
}
