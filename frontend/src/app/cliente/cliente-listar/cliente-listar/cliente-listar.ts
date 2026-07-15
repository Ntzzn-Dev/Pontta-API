import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../cliente.service';
import { Observable } from 'rxjs';
import { Cliente } from '../../cliente.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente-listar',
  standalone: false,
  templateUrl: './cliente-listar.html',
  styleUrl: './cliente-listar.css',
})
export class ClienteListar implements OnInit {
  clientes$! : Observable<Cliente[]>;

  constructor (private clienteService: ClienteService, private router: Router) { }

  ngOnInit(): void {
    this.listarClientes();
  }

  listarClientes() {
    this.clientes$ = this.clienteService.listar();
  }

  create(){
    this.router.navigate(['/clientes/cadastrar']);
  }

  update(id: number){
    this.router.navigate([`/clientes/editar/${id}`]);
  }
}
