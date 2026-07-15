import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Produto } from '../produto.model';
import { ProdutoService } from '../produto.service';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoResolver implements Resolve<Produto> {
  constructor(private produtoService: ProdutoService){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    const id = route.params["id"];
    if(id){
      return this.produtoService.read(id);
    }

    return of ({
      id: 0,
      nome : '',
      categoria: '',
      preco: 0
    });
  }
}