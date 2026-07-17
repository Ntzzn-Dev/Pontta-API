import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteForm } from './cliente-form/cliente-form';
import { ClienteResolver } from './cliente-resolver';

const routes: Routes = [
  {
    path: '',
    component: ClienteForm,
    resolve: {
      cliente: ClienteResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClienteFormRoutingModule {}
