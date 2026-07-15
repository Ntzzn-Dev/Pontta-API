import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoListar } from './produto-listar/produto-listar';

const routes: Routes = [
  {path: '', component: ProdutoListar}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProdutoListarRoutingModule {}
