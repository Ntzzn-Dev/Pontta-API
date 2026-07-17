import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutoListarRoutingModule } from './produto-listar-routing-module';
import { ProdutoListar } from './produto-listar/produto-listar';
import { MatAnchor, MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [ProdutoListar],
  imports: [CommonModule, ProdutoListarRoutingModule, MatAnchor, MatButtonModule],
})
export class ProdutoListarModule {}
