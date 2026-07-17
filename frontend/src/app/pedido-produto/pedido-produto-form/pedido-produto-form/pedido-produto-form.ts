import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../../../produto/produto.model';
import { ProdutoService } from '../../../produto/produto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Pedido } from '../../../pedido/pedido.model';
import { PedidoProdutoService } from '../../pedido-produto.service';
import { PedidoProdutoRequest } from "./../../pedido-produto-request.model";


@Component({
  selector: 'app-pedido-produto-form',
  standalone: false,
  templateUrl: './pedido-produto-form.html',
  styleUrl: './pedido-produto-form.css',
})
export class PedidoProdutoForm {
  produtos$!: Observable<Produto[]>;
  produtosNoPedido!: number[];
  ped!: Pedido;
  
  constructor(
    private produtoService: ProdutoService, 
    private pedidoProdutoService: PedidoProdutoService,
    private router: Router, 
    private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    this.ped = this.activatedRoute.snapshot.data["pedido"];
    this.listar();
    console.log(this.ped.id);
  }

  listar(){
    this.produtos$ = this.produtoService.list();
    this.pedidoProdutoService.list(this.ped.id).subscribe(response => {
      this.produtosNoPedido = response.produtos.map(p => p.idProduto);
    });
  }

  add(id: number){
    if(this.produtosNoPedido.includes(id)){
      this.pedidoProdutoService.delete(this.ped.id, id).subscribe(
        produtoAdicionado => {
          console.log("removido");
        }
      );
      
      this.produtosNoPedido = this.produtosNoPedido.filter(p => p !== id);
    } else {
      const pedProd = {
        idProduto : id
      } as PedidoProdutoRequest;

      this.pedidoProdutoService.create(this.ped.id, pedProd).subscribe(
        produtoAdicionado => {
          console.log("adicionado");
        }
      );

      this.produtosNoPedido.push(id);
    }
  }
}
