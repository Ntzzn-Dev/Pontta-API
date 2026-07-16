import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PedidoListar } from './pedido-listar/pedido-listar';

const routes: Routes = [
  {path: '', component: PedidoListar}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PedidoListarRoutingModule {}
