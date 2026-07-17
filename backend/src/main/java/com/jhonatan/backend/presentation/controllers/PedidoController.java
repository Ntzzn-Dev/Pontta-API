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

import com.jhonatan.backend.application.dto.request.PedidoProdutoRequestDTO;
import com.jhonatan.backend.application.dto.request.PedidoRequestDTO;
import com.jhonatan.backend.application.dto.response.PedidoProdutoResponseDTO;
import com.jhonatan.backend.application.services.PedidoProdutoService;
import com.jhonatan.backend.application.services.PedidoService;
import com.jhonatan.backend.domain.entities.Pedido;
import com.jhonatan.backend.domain.entities.PedidoProduto;
import com.jhonatan.backend.domain.entities.PedidoProdutoId;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {
    private final PedidoService pedidoService;
    private final PedidoProdutoService pedidoProdutoService;

    public PedidoController(PedidoService pedidoService, PedidoProdutoService pedidoProdutoService) {
        this.pedidoService = pedidoService;
        this.pedidoProdutoService = pedidoProdutoService;
    }

    @GetMapping
    public List<Pedido> list(){
        return pedidoService.list();
    }

    @PostMapping
    public Pedido create(@RequestBody PedidoRequestDTO obj){
        return pedidoService.create(obj);
    }

    @GetMapping("/{id}")
    public Pedido read(@PathVariable Long id){
        return pedidoService.read(id);
    }
    
    @PutMapping("/{id}")
    public Pedido update(@PathVariable Long id, @RequestBody PedidoRequestDTO obj){
        return pedidoService.update(id, obj);
    }

    @DeleteMapping("/{id}")
    public Pedido delete(@PathVariable Long id){
        return pedidoService.delete(id);
    }

    //Pedido Produto
    @PostMapping("/{id}/produtos")
    public PedidoProduto createPP(@PathVariable Long id, @RequestBody PedidoProdutoRequestDTO dto){
        return pedidoProdutoService.createPP(id, dto);
    }

    @GetMapping("/{id}/produtos")
    public PedidoProdutoResponseDTO readPP(@PathVariable Long id){
        return pedidoProdutoService.listPP(id);
    }

    @PutMapping("/{id}/produtos/{idProd}")
    public PedidoProduto updatePP(@PathVariable Long id, @PathVariable Long idProd, @RequestBody PedidoProdutoRequestDTO dto){
        return pedidoProdutoService.updatePP(new PedidoProdutoId(id, idProd), dto);
    }

    @DeleteMapping("/{id}/produtos/{idProd}")
    public PedidoProduto deleteProduto(@PathVariable Long id, @PathVariable Long idProd){
        return pedidoProdutoService.deletePP(new PedidoProdutoId(id, idProd));
    }
}
