import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../../produto.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Produto } from '../../produto.model';

@Component({
  selector: 'app-produto-listar',
  standalone: false,
  templateUrl: './produto-listar.html',
  styleUrl: './produto-listar.css',
})
export class ProdutoListar implements OnInit {
  produtos$! : Observable<Produto[]>;

  constructor(private produtoService : ProdutoService, private router : Router){}

  ngOnInit(): void {
    this.listar();
  }

  listar(){
    this.produtos$ = this.produtoService.listar();
  }

  create(){
    this.router.navigateByUrl('produtos/cadastrar');
  }

  update(id: number){
    this.router.navigateByUrl(`produtos/editar/${id}`);
  }
}
