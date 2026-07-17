import { Routes } from '@angular/router';
import { Home } from './home/home';

export const routes: Routes = [
    {
        path: '',
        component: Home
    },
    {
        path: 'clientes',
        loadChildren: () => import('./cliente/cliente-listar/cliente-listar-module').then(m => m.ClienteListarModule)
    },
    {
        path: 'clientes/cadastrar',
        loadChildren: () => import('./cliente/cliente-form/cliente-form-module').then(m => m.ClienteFormModule)
    },
    {
        path: 'clientes/editar/:id',
        loadChildren: () => import('./cliente/cliente-form/cliente-form-module').then(m => m.ClienteFormModule)
    },
    {
        path: 'produtos',
        loadChildren: () => import('./produto/produto-listar/produto-listar-module').then(m => m.ProdutoListarModule)
    },
    {
        path: 'produtos/cadastrar',
        loadChildren: () => import('./produto/produto-form/produto-form-module').then(m => m.ProdutoFormModule)
    },
    {
        path: 'produtos/editar/:id',
        loadChildren: () => import('./produto/produto-form/produto-form-module').then(m => m.ProdutoFormModule)
    },
    {
        path: 'pedidos',
        loadChildren: () => import('./pedido/pedido-listar/pedido-listar-module').then(m => m.PedidoListarModule)
    },
    {
        path: 'pedidos/cadastrar',
        loadChildren: () => import('./pedido/pedido-form/pedido-form-module').then(m => m.PedidoFormModule)
    },
    {
        path: 'pedidos/editar/:id',
        loadChildren: () => import('./pedido/pedido-form/pedido-form-module').then(m => m.PedidoFormModule)
    },
    {
        path: 'pedidos/:id/produtos',
        loadChildren: () => import('./pedido-produto/pedido-produto-form/pedido-produto-form-module').then(m => m.PedidoProdutoFormModule)
    }
];
