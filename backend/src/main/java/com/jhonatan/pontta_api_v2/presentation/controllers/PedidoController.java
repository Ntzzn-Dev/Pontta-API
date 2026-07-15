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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.jhonatan.pontta_api_v2.application.dto.request.PedidoProdutoRequestDTO;
import com.jhonatan.pontta_api_v2.application.dto.request.PedidoRequestDTO;
import com.jhonatan.pontta_api_v2.application.dto.response.PedidoProdutoResponseDTO;
import com.jhonatan.pontta_api_v2.application.services.PedidoProdutoService;
import com.jhonatan.pontta_api_v2.application.services.PedidoService;
import com.jhonatan.pontta_api_v2.domain.entities.Pedido;
import com.jhonatan.pontta_api_v2.domain.entities.PedidoProduto;
import com.jhonatan.pontta_api_v2.domain.entities.PedidoProdutoId;

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
    public List<Pedido> listPedido(){
        return pedidoService.listPed();
    }

    @PostMapping
    public Pedido createPedido(@RequestBody PedidoRequestDTO dto){
        return pedidoService.createPed(dto);
    }

    @GetMapping("/{id}")
    public Pedido readPedido(@PathVariable Long id){
        return pedidoService.readPed(id);
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody PedidoRequestDTO dto){
        return pedidoService.updatePed(id, dto);
    }

    @DeleteMapping("/{id}")
    public Pedido deletePedido(@PathVariable Long id){
        return pedidoService.deletePed(id);
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
