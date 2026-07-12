package com.jhonatan.pontta_api_v2.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.pontta_api_v2.application.dto.request.ClienteRequestDTO;
import com.jhonatan.pontta_api_v2.domain.entities.Cliente;
import com.jhonatan.pontta_api_v2.domain.repositories.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listCli(){
        return clienteRepository.findAll();
    }

    public Cliente createCli(ClienteRequestDTO dto){
        Cliente cli = new Cliente();
        cli.atualizar(dto.getNome(), dto.getContato());
        return clienteRepository.save(cli);
    }

    public Cliente readCli(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente updateCli(Long id, ClienteRequestDTO dto){
        Cliente cli = readCli(id);
        cli.atualizar(dto.getNome(), dto.getContato());
        return clienteRepository.save(cli);
    }

    public Cliente deleteCli(Long id){
        Cliente cli = readCli(id);
        clienteRepository.delete(cli);
        return cli;
    }
}
