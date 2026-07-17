package com.jhonatan.backend.presentation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonatan.backend.application.services.ClienteService;
import com.jhonatan.backend.domain.entities.Cliente;
@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @GetMapping
    public List<Cliente> list(){
        return clienteService.list();
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente obj){
        return clienteService.create(obj);
    }

    @GetMapping("/{id}")
    public Cliente read(@PathVariable Long id){
        return clienteService.read(id);
    }
    
    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente obj){
        return clienteService.update(id, obj);
    }

    @DeleteMapping("/{id}")
    public Cliente delete(@PathVariable Long id){
        return clienteService.delete(id);
    }
}
