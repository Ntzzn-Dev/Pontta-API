import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PedidoFormRoutingModule } from './pedido-form-routing-module';
import { PedidoForm } from './pedido-form/pedido-form';
import { MatToolbar } from "@angular/material/toolbar";
import { MatFormFieldModule } from "@angular/material/form-field";
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatAnchor } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';

@NgModule({
  declarations: [PedidoForm],
  imports: [
    CommonModule, 
    PedidoFormRoutingModule,     
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbar,
    MatAnchor,
    MatSelectModule,
    MatOptionModule
  ],
})
export class PedidoFormModule {}
