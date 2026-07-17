package com.jhonatan.backend.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.backend.domain.entities.Cliente;
import com.jhonatan.backend.domain.repositories.ClienteRepository;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    public List<Cliente> list(){
        return clienteRepository.findAll();
    }

    public Cliente create(Cliente obj){
        return clienteRepository.save(obj);
    }

    public Cliente read(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente update(Long id, Cliente obj){
        Cliente oldObj = read(id);
        oldObj.setId(id);
        oldObj.setNome(obj.getNome());
        oldObj.setEmail(obj.getEmail());
        return clienteRepository.save(oldObj);
    }

    public Cliente delete(Long id){
        Cliente obj = read(id);
        clienteRepository.delete(obj);
        return obj;
    }
}
