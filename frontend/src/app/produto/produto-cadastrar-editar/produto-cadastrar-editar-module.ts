import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutoCadastrarEditarRoutingModule } from './produto-cadastrar-editar-routing-module';
import { ProdutoCadastrarEditar } from './produto-cadastrar-editar/produto-cadastrar-editar';
import { MatAnchor } from '@angular/material/button';
import { MatToolbar } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [ProdutoCadastrarEditar],
  imports: [
    CommonModule, 
    ProdutoCadastrarEditarRoutingModule, 
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbar,
    MatAnchor
  ],
})
export class ProdutoCadastrarEditarModule {}
