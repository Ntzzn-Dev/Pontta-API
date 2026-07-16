import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Pedido } from '../../pedido.model';
import { PedidoService } from '../../pedido.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Produto } from '../../../produto/produto.model';
import { Observable } from 'rxjs';
import { Cliente } from '../../../cliente/cliente.model';
import { ProdutoService } from '../../../produto/produto.service';
import { ClienteService } from '../../../cliente/cliente.service';
import { PedidoRequest } from '../../pedido-request.model';

@Component({
  selector: 'app-pedido-form',
  standalone: false,
  templateUrl: './pedido-form.html',
  styleUrl: './pedido-form.css',
})
export class PedidoForm implements OnInit{
  formGroup!: FormGroup;
  pedido!: Pedido;
  produtos$!: Observable<Produto[]>;
  clientes$!: Observable<Cliente[]>;

  idsProdutos: number[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private pedidoService: PedidoService,
    private produtoService: ProdutoService,
    private clienteService: ClienteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.listar();
    this.pedido = this.activatedRoute.snapshot.data["pedido"];
    console.log(this.pedido);
    this.formGroup = this.formBuilder.group({
      cliente: [this.pedido?.cliente ?? null]
    })

    if(this.pedido && this.pedido.id){
      this.pedidoService.listarProds(this.pedido.id).subscribe(
        pedidoCarregado => {
          for(const prod of pedidoCarregado.produtos){
            for (let i = 0; i < prod.quantidade; i++) {
              this.addProduto(prod.idProduto);
            }
          }
        },
        err => {
          console.error(err);
        }
      );
    }
  }

  compararCliente(c1: Cliente, c2: Cliente): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  listar(){
    this.produtos$ = this.produtoService.listar();
    this.clientes$ = this.clienteService.listar();
  }

  removeProduto(id: number){
    const indice = this.idsProdutos.findIndex(p => p === id);
    if (indice !== -1) {
      this.idsProdutos.splice(indice, 1);
    }
  }

  addProduto(id: number){
    this.idsProdutos.push(id);
  }

  salvar(){
    const formValue = this.formGroup.value;
    let body = {
      idCliente: formValue.cliente.id
    } as PedidoRequest;

    if(this.pedido && this.pedido.cliente && this.pedido.cliente.id){
      /*this.pedidoService.update(this.pedido.id, body).subscribe(
        pedidoAtualizado => {
          this.router.navigateByUrl('/pedidos');
        },
        error => {
          alert("Pedido atualizado " + JSON.stringify(error));
        }
      )*/
    } else {
      this.pedidoService.create(body).subscribe(
        pedidoCriado => {
          this.pedidoService.addProds(pedidoCriado.id, this.idsProdutos).subscribe(
            () => {
              this.router.navigateByUrl('/pedidos');
            }
          );
        },
        error => {
          alert("Pedido criado " + JSON.stringify(error));
        }
      )
    }
  }

  excluir(id: number){
    this.pedidoService.delete(id).subscribe(() => {
      this.router.navigateByUrl('/pedidos');
    })
  }
}
