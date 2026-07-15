import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClienteListarRoutingModule } from './cliente-listar-routing-module';
import { ClienteListar } from './cliente-listar/cliente-listar';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [ClienteListar],
  imports: [
    CommonModule,
    ClienteListarRoutingModule,
    MatButtonModule
  ],
})
export class ClienteListarModule {}
