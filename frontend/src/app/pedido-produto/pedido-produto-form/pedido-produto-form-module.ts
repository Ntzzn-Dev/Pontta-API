import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PedidoProdutoFormRoutingModule } from './pedido-produto-form-routing-module';
import { PedidoProdutoForm } from './pedido-produto-form/pedido-produto-form';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [PedidoProdutoForm],
  imports: [CommonModule, PedidoProdutoFormRoutingModule,MatFormFieldModule, MatButtonModule, MatInputModule, ReactiveFormsModule],
})
export class PedidoProdutoFormModule {}
