import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClienteCadastrarEditarRoutingModule } from './cliente-cadastrar-editar-routing-module';
import { ClienteCadastrarEditar } from './cliente-cadastrar-editar/cliente-cadastrar-editar';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbar } from '@angular/material/toolbar';
import { MatAnchor } from "@angular/material/button";

@NgModule({
  declarations: [ClienteCadastrarEditar],
  imports: [
    CommonModule,
    ClienteCadastrarEditarRoutingModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbar,
    MatAnchor
]
})
export class ClienteCadastrarEditarModule {}
