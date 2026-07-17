package com.jhonatan.backend.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.backend.application.dto.request.PedidoRequestDTO;
import com.jhonatan.backend.domain.entities.Pedido;
import com.jhonatan.backend.domain.repositories.PedidoRepository;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;
    private ClienteService clienteService;

    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
    }

    public List<Pedido> list(){
        return pedidoRepository.findAll();
    }

    public Pedido create(PedidoRequestDTO dto){
        Pedido obj = new Pedido();
        obj.setCliente(clienteService.read(dto.getIdCliente()));
        return pedidoRepository.save(obj);
    }

    public Pedido read(Long id){
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido update(Long id, PedidoRequestDTO dto){
        Pedido obj = read(id);
        obj.setCliente(clienteService.read(dto.getIdCliente()));
        return pedidoRepository.save(obj);
    }

    public Pedido delete(Long id){
        Pedido obj = read(id);
        pedidoRepository.delete(obj);
        return obj;
    }
}
