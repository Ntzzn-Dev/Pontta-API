import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoCadastrarEditar } from './produto-cadastrar-editar/produto-cadastrar-editar';
import { ProdutoResolver } from './produto-resolver';

const routes: Routes = [{
  path: '',
  component: ProdutoCadastrarEditar,
  resolve: {
    prod: ProdutoResolver
  }
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProdutoCadastrarEditarRoutingModule {}
