import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../../cliente.model';
import { ClienteService } from '../../cliente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente-listar',
  standalone: false,
  templateUrl: './cliente-listar.html',
  styleUrl: './cliente-listar.css',
})
export class ClienteListar implements OnInit {
  clientes$!: Observable<Cliente[]>;
  
  constructor(private clienteService: ClienteService, private router: Router){}

  ngOnInit(): void {
    this.listar();
  }

  listar(){
    this.clientes$ = this.clienteService.list();
  }

  cadastrar(){
    this.router.navigateByUrl("/clientes/cadastrar")
  }

  editar(id : number) {
    this.router.navigateByUrl(`/clientes/editar/${id}`);
  }
}
