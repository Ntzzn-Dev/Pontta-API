import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClienteListarRoutingModule } from './cliente-listar-routing-module';
import { ClienteListar } from './cliente-listar/cliente-listar';
import { MatAnchor, MatButtonModule } from "@angular/material/button";

@NgModule({
  declarations: [ClienteListar],
  imports: [CommonModule, ClienteListarRoutingModule, MatAnchor, MatButtonModule],
})
export class ClienteListarModule {}
