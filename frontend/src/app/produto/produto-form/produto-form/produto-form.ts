import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Produto } from '../../produto.model';
import { ClienteService } from '../../../cliente/cliente.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ProdutoService } from '../../produto.service';

@Component({
  selector: 'app-produto-form',
  standalone: false,
  templateUrl: './produto-form.html',
  styleUrl: './produto-form.css',
})
export class ProdutoForm {
  formGroup!: FormGroup;
  prod!: Produto

  constructor(private formBuilder: FormBuilder, private produtoService: ProdutoService, private router: Router, private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    this.prod = this.activatedRoute.snapshot.data["produto"];
    this.formGroup = this.formBuilder.group({
      nome: [this.prod?.nome ?? null, Validators.required],
      categoria: [this.prod?.categoria ?? null],
      preco: [this.prod?.preco ?? null]
    })
  }

  salvar(){
    if(this.prod && this.prod.id){
      this.produtoService.update(this.prod.id, this.formGroup.value).subscribe(
        prodAtualizado => {
        console.log("atualizado");
          this.router.navigateByUrl("/produtos");
        }
      )
    } else {
      this.produtoService.create(this.formGroup.value).subscribe(
        prodCadastrado => {
        console.log("criado");
          this.router.navigateByUrl("/produtos");
        }
      )
    }
  }

  excluir(id: number){
    this.produtoService.delete(id).subscribe(
      deletado =>{
        console.log("apagado");
        this.router.navigateByUrl("/produtos");
      }
    )
  }
}
