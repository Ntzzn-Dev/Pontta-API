import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../../produto.model';
import { ProdutoService } from '../../produto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-produto-listar',
  standalone: false,
  templateUrl: './produto-listar.html',
  styleUrl: './produto-listar.css',
})
export class ProdutoListar {
  produtos$!: Observable<Produto[]>;
  
  constructor(private produtoService: ProdutoService, private router: Router){}

  ngOnInit(): void {
    this.listar();
  }

  listar(){
    this.produtos$ = this.produtoService.list();
  }

  cadastrar(){
    this.router.navigateByUrl("/produtos/cadastrar")
  }

  editar(id : number) {
    this.router.navigateByUrl(`/produtos/editar/${id}`);
  }
}
