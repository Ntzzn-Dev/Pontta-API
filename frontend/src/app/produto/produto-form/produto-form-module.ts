import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutoFormRoutingModule } from './produto-form-routing-module';
import { ProdutoForm } from './produto-form/produto-form';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [ProdutoForm],
  imports: [CommonModule, ProdutoFormRoutingModule, MatFormFieldModule, MatButtonModule, MatInputModule, ReactiveFormsModule],
})
export class ProdutoFormModule {}
