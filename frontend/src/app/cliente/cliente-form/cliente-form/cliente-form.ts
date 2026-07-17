import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Cliente } from '../../cliente.model';
import { ClienteService } from '../../cliente.service';
import { ActivatedRoute, Router } from '@angular/router';
import { email } from '@angular/forms/signals';

@Component({
  selector: 'app-cliente-form',
  standalone: false,
  templateUrl: './cliente-form.html',
  styleUrl: './cliente-form.css',
})
export class ClienteForm implements OnInit {
  formGroup!: FormGroup;
  cli!: Cliente;

  constructor(private formBuilder: FormBuilder, private clienteService: ClienteService, private router: Router, private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    this.cli = this.activatedRoute.snapshot.data["cliente"];
    this.formGroup = this.formBuilder.group({
      nome: [this.cli?.nome ?? null, Validators.required],
      email: [this.cli?.email ?? null]
    })
  }

  salvar(){
    if(this.cli && this.cli.id){
      this.clienteService.update(this.cli.id, this.formGroup.value).subscribe(
        cliAtualizado => {
        console.log("atualizado");
          this.router.navigateByUrl("/clientes");
        }
      )
    } else {
      this.clienteService.create(this.formGroup.value).subscribe(
        cliCadastrado => {
        console.log("criado");
          this.router.navigateByUrl("/clientes");
        }
      )
    }
  }

  excluir(id: number){
    this.clienteService.delete(id).subscribe(
      deletado =>{
        console.log("apagado");
        this.router.navigateByUrl("/clientes");
      }
    )
  }
}
