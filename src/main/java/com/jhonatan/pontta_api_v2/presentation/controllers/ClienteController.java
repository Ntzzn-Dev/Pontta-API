package com.jhonatan.pontta_api_v2.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonatan.pontta_api_v2.application.dto.request.ClienteRequestDTO;
import com.jhonatan.pontta_api_v2.application.services.ClienteService;
import com.jhonatan.pontta_api_v2.domain.entities.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listCli(){
        return clienteService.listCli();
    }

    @PostMapping
    public Cliente createCliente(@RequestBody ClienteRequestDTO dto){
        return clienteService.createCli(dto);
    }

    @GetMapping("/{id}")
    public Cliente readCliente(@PathVariable Long id){
        return clienteService.readCli(id);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO dto){
        return clienteService.updateCli(id, dto);
    }

    @DeleteMapping("/{id}")
    public Cliente deleteCliente(@PathVariable Long id){
        return clienteService.deleteCli(id);
    }
}
