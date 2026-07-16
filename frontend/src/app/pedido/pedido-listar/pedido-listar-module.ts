import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PedidoListarRoutingModule } from './pedido-listar-routing-module';
import { PedidoListar } from './pedido-listar/pedido-listar';
import { MatAnchor } from "@angular/material/button";

@NgModule({
  declarations: [PedidoListar],
  imports: [CommonModule, PedidoListarRoutingModule, MatAnchor],
})
export class PedidoListarModule {}
