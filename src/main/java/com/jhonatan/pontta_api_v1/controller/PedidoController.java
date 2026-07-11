package com.jhonatan.pontta_api_v1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonatan.pontta_api_v1.dto.PedProdRequestDTO;
import com.jhonatan.pontta_api_v1.dto.PedidoRequestDTO;
import com.jhonatan.pontta_api_v1.model.Pedido;
import com.jhonatan.pontta_api_v1.model.PedidoProduto;
import com.jhonatan.pontta_api_v1.service.PedidoProdutoService;
import com.jhonatan.pontta_api_v1.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;
    private final PedidoProdutoService pedidoProdutoService;

    public PedidoController(PedidoService pedidoService, PedidoProdutoService pedidoProdutoService){
        this.pedidoService = pedidoService;
        this.pedidoProdutoService = pedidoProdutoService;
    }

    @GetMapping
    public List<Pedido> listPed(){
        return pedidoService.listPed();
    }

    @PostMapping
    public Pedido createPed(@RequestBody PedidoRequestDTO pDto){
        return pedidoService.createPed(pDto);
    }

    @GetMapping("/{id}")
    public Pedido readPed(@PathVariable Long id){
        return pedidoService.readPed(id);
    }

    @PutMapping("/{id}")
    public Pedido updatePed(@PathVariable Long id, @RequestBody PedidoRequestDTO pDto){
        return pedidoService.updatePed(id, pDto);
    }

    @DeleteMapping("/{id}")
    public Pedido deletePed(@PathVariable Long id){
        return pedidoService.deletePed(id);
    }

    // Pedido Produto

    @GetMapping("/{id}/produtos")
    public List<PedidoProduto> listProdutos(@PathVariable Long id){
        return pedidoProdutoService.listPP(id);
    }

    @PostMapping("/{id}/produtos")
    public PedidoProduto createPP(@PathVariable Long id, @RequestBody PedProdRequestDTO dto) {
        return pedidoProdutoService.createPP(id, dto);
    }

    @PutMapping("/{id}/produtos/{prodId}")
    public PedidoProduto updatePP(@PathVariable Long id, @PathVariable Long prodId, @RequestBody PedProdRequestDTO dto){
        return pedidoProdutoService.updatePP(id, prodId, dto);
    }

    @DeleteMapping("/{id}/produtos/{prodId}")
    public PedidoProduto deletePP(@PathVariable Long id, @PathVariable Long prodId){
        return pedidoProdutoService.deletePP(id, prodId);
    }
}
