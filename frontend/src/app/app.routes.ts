import { RouterModule, Routes } from '@angular/router';
import { Home } from './home/home';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    {
        path: "",
        component: Home
    },
    {
        path: "clientes",
        loadChildren: () => import('./cliente/cliente-listar/cliente-listar-module').then(modulo => modulo.ClienteListarModule)
    },
    {
        path: "clientes/cadastrar",
        loadChildren: () => import('./cliente/cliente-cadastrar-editar/cliente-cadastrar-editar-module').then(modulo => modulo.ClienteCadastrarEditarModule)
    },
    {
        path: "clientes/editar/:id",
        loadChildren: () => import('./cliente/cliente-cadastrar-editar/cliente-cadastrar-editar-module').then(modulo => modulo.ClienteCadastrarEditarModule)
    },
    {
        path: "produtos",
        loadChildren: () => import('./produto/produto-listar/produto-listar-module').then(modulo => modulo.ProdutoListarModule)
    },
    {
        path: "produtos/cadastrar",
        loadChildren: () => import('./produto/produto-cadastrar-editar/produto-cadastrar-editar-module').then(modulo => modulo.ProdutoCadastrarEditarModule)
    },
    {
        path: "produtos/editar/:id",
        loadChildren: () => import('./produto/produto-cadastrar-editar/produto-cadastrar-editar-module').then(m => m.ProdutoCadastrarEditarModule)
    }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
