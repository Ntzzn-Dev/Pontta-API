package com.jhonatan.pontta_api_v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.pontta_api_v1.model.Cliente;
import com.jhonatan.pontta_api_v1.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente adicionarCliente(Cliente cliente){        
        if(cliente.getNome() == null || cliente.getNome().isBlank()){
            throw new RuntimeException("Nome obrigatório");
        } 
        if (clienteRepository.existsByNome(cliente.getNome())) {
            throw new RuntimeException("Cliente já cadastrado");
        }

        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizarCliente(Long id, Cliente cli){
        Cliente cliente = buscarPorId(id);

        if(cli.getNome() == null || cli.getNome().isBlank()){
            throw new RuntimeException("Nome obrigatório");
        }

        cliente.setNome(cli.getNome());
        cliente.setContato(cli.getContato());

        return clienteRepository.save(cliente);
    }

    public Cliente apagarCliente(Long id){
        Cliente cliente = buscarPorId(id);

        clienteRepository.delete(cliente);

        return cliente;
    }
}
