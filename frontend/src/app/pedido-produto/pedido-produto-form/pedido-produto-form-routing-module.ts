import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PedidoProdutoForm } from './pedido-produto-form/pedido-produto-form';
import { PedidoProdutoResolver } from './pedido-produto-resolver';

const routes: Routes = [{
  path: '',
  component: PedidoProdutoForm,
  resolve: {
    pedido: PedidoProdutoResolver
  }
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PedidoProdutoFormRoutingModule {}
