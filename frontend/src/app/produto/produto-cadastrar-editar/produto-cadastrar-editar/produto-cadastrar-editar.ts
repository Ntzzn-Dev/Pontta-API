import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Produto } from '../../produto.model';
import { ProdutoService } from '../../produto.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-produto-cadastrar-editar',
  standalone: false,
  templateUrl: './produto-cadastrar-editar.html',
  styleUrl: './produto-cadastrar-editar.css',
})
export class ProdutoCadastrarEditar implements OnInit{
  formGroup!: FormGroup;
  prod!: Produto;

  constructor(
    private formBuilder: FormBuilder,
    private produtoService: ProdutoService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.prod = this.activatedRoute.snapshot.data["prod"];
    this.formGroup = this.formBuilder.group({
      id: [(this.prod && this.prod.id) ? this.prod.id : null],
      nome: [(this.prod && this.prod.nome) ? this.prod.nome : null, Validators.required],
      categoria: [(this.prod && this.prod.categoria) ? this.prod.categoria : null],
      preco: [(this.prod && this.prod.preco) ? this.prod.preco : null]
    })
  }

  salvar(){
    if(this.prod && this.prod.id){
      this.produtoService.update(this.prod.id, this.formGroup.value).subscribe(
        produtoAtualizado => {
          this.router.navigateByUrl("/produtos");
        },
        error => {
          alert("Erro ao atualizar " + JSON.stringify(error));
        }
      )
    } else {
      this.produtoService.create(this.formGroup.value).subscribe(
        produtoCriado => {
          this.router.navigateByUrl("/produtos");
        },
        error => {
          alert("Erro ao cadastrar " + JSON.stringify(error));
        }
      )
    }
  }

  excluir(id: number){
    this.produtoService.delete(id).subscribe(() => {
      this.router.navigateByUrl("/produtos");
    });
  }
}
