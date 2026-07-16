import { Component, OnInit } from '@angular/core';
import { Pedido } from '../../pedido.model';
import { PedidoService } from '../../pedido.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pedido-listar',
  standalone: false,
  templateUrl: './pedido-listar.html',
  styleUrl: './pedido-listar.css',
})
export class PedidoListar implements OnInit{
  pedidos$! : Observable<Pedido[]>;

  constructor(private pedidoService: PedidoService, private router: Router) {}

  ngOnInit(): void {
    this.listar();
  }

  listar(){
    this.pedidos$ = this.pedidoService.listar();
  }

  create(){
    this.router.navigateByUrl('/pedidos/cadastrar');
  }

  update(id: number){
    this.router.navigateByUrl(`/pedidos/editar/${id}`);
  }
}
