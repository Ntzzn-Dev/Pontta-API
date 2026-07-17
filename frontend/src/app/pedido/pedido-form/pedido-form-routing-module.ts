import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PedidoForm } from './pedido-form/pedido-form';
import { PedidoResolver } from './pedido-resolver';

const routes: Routes = [{
  path: '',
  component: PedidoForm,
  resolve: {
    pedido: PedidoResolver
  }
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PedidoFormRoutingModule {}
