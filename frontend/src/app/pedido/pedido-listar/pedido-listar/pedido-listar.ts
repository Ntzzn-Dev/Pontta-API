import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Pedido } from '../../pedido.model';
import { PedidoService } from '../../pedido.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pedido-listar',
  standalone: false,
  templateUrl: './pedido-listar.html',
  styleUrl: './pedido-listar.css',
})
export class PedidoListar implements OnInit{
  pedidos$!: Observable<Pedido[]>;
  
  constructor(private pedidoService: PedidoService, private router: Router){}

  ngOnInit(): void {
    this.listar();
  }

  listar(){
    this.pedidos$ = this.pedidoService.list();
  }

  cadastrar(){
    this.router.navigateByUrl("/pedidos/cadastrar")
  }

  editar(id : number) {
    this.router.navigateByUrl(`/pedidos/editar/${id}`);
  }

  addProd(id : number) {
    this.router.navigateByUrl(`/pedidos/${id}/produtos`);
  }
}
