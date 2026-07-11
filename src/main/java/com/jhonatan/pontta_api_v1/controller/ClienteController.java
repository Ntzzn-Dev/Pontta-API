package com.jhonatan.pontta_api_v1.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.jhonatan.pontta_api_v1.model.Cliente;
import com.jhonatan.pontta_api_v1.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listCli() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente createCli(@RequestBody Cliente cliente) {
        return clienteService.adicionarCliente(cliente);
    }

    @GetMapping("/{id}")
    public Cliente readCli(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Cliente updateCli(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public Cliente deleteCli(@PathVariable Long id){
        return clienteService.apagarCliente(id);
    }
}