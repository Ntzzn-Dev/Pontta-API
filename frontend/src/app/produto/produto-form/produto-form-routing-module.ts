import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoForm } from './produto-form/produto-form';
import { ProdutoResolver } from './produto-resolver';

const routes: Routes = [
  {
    path: '',
    component: ProdutoForm,
    resolve: {
      produto: ProdutoResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProdutoFormRoutingModule {}
