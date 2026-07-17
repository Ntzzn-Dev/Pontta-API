import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Pedido } from '../../pedido.model';
import { PedidoService } from '../../pedido.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from '../../../cliente/cliente.model';
import { Observable } from 'rxjs';
import { ClienteService } from '../../../cliente/cliente.service';

@Component({
  selector: 'app-pedido-form',
  standalone: false,
  templateUrl: './pedido-form.html',
  styleUrl: './pedido-form.css',
})
export class PedidoForm {
  formGroup!: FormGroup;
  ped!: Pedido

  clientes$!: Observable<Cliente[]>;

  cliente!: Cliente;

  constructor(
    private formBuilder: FormBuilder, 
    private pedidoService:PedidoService, 
    private clienteService:ClienteService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    this.ped = this.activatedRoute.snapshot.data["pedido"];
    this.formGroup = this.formBuilder.group({
      idCliente: [this.ped?.cliente?.id ?? null, Validators.required]
    })
    this.listar();
  }

  listar(){
    this.clientes$ = this.clienteService.list();
  }

  salvar(){
    if(this.ped && this.ped.id){
      this.pedidoService.update(this.ped.id, this.formGroup.value).subscribe(
        prodAtualizado => {
        console.log("atualizado");
          this.router.navigateByUrl("/pedidos");
        }
      )
    } else {
      this.pedidoService.create(this.formGroup.value).subscribe(
        prodCadastrado => {
        console.log("criado");
          this.router.navigateByUrl("/pedidos");
        }
      )
    }
  }

  excluir(id: number){
    this.pedidoService.delete(id).subscribe(
      deletado =>{
        console.log("apagado");
        this.router.navigateByUrl("/pedidos");
      }
    )
  }

  escolher(cli: Cliente) {
    this.cliente = cli;
    this.formGroup.patchValue({
      idCliente: cli.id
    });
  }
}
