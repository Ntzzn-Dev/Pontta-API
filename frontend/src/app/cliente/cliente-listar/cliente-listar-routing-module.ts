import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteListar } from './cliente-listar/cliente-listar';

const routes: Routes = [
  {
    path: '',
    component: ClienteListar
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClienteListarRoutingModule {}
