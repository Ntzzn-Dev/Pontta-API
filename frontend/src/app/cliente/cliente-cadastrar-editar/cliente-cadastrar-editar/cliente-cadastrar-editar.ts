import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClienteService } from '../../cliente.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from '../../cliente.model';

@Component({
  selector: 'app-cliente-cadastrar-editar',
  standalone: false,
  templateUrl: './cliente-cadastrar-editar.html',
  styleUrl: './cliente-cadastrar-editar.css',
})
export class ClienteCadastrarEditar implements OnInit {
  formGroup!: FormGroup;
  cli!: Cliente;

  constructor(
    private formBuilder: FormBuilder, 
    private clienteService: ClienteService, 
    private router : Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.cli = this.activatedRoute.snapshot.data["cliente"];
    this.formGroup = this.formBuilder.group({
      id: [(this.cli && this.cli.id) ? this.cli.id : null],
      nome: [(this.cli && this.cli.nome) ? this.cli.nome : null, Validators.required],
      contato: [(this.cli && this.cli.contato) ? this.cli.contato : null]
    })
  }

  salvar(){
    if(this.cli && this.cli.id) {
      this.clienteService.update(this.formGroup.value, this.cli.id).subscribe(
        clienteCadastrado => {
          this.router.navigateByUrl("/clientes");
        },
        error => {
          alert("Erro ao atualizar " + JSON.stringify(error))
        }
      );
    } else {
      this.clienteService.create(this.formGroup.value).subscribe(
        clienteCadastrado => {
          this.router.navigateByUrl("/clientes");
        },
        error => {
          alert("Erro ao cadastrar " + JSON.stringify(error))
        }
      );
    }
  }

  excluir(id: number) {
    this.clienteService.delete(id).subscribe(() => {
      this.router.navigateByUrl('/clientes');
    });
  }
}
