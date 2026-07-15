import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteCadastrarEditar } from './cliente-cadastrar-editar/cliente-cadastrar-editar';
import { ClienteResolver } from './cliente-resolver';

const routes: Routes = [
  {
    path:"", 
    component: ClienteCadastrarEditar,
    resolve: {
      cliente: ClienteResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClienteCadastrarEditarRoutingModule {}
