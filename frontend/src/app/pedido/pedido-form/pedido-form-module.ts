import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PedidoFormRoutingModule } from './pedido-form-routing-module';
import { PedidoForm } from './pedido-form/pedido-form';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [PedidoForm],
  imports: [CommonModule, PedidoFormRoutingModule,MatFormFieldModule, MatButtonModule, MatInputModule, ReactiveFormsModule],
})
export class PedidoFormModule {}
