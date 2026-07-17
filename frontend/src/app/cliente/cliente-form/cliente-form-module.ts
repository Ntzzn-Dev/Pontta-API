import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClienteFormRoutingModule } from './cliente-form-routing-module';
import { ClienteForm } from './cliente-form/cliente-form';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [ClienteForm],
  imports: [CommonModule, ClienteFormRoutingModule, MatFormFieldModule, MatButtonModule, MatInputModule, ReactiveFormsModule],
})
export class ClienteFormModule {}
