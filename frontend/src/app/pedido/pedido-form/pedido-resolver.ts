import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, MaybeAsync, RedirectCommand, Resolve, RouterStateSnapshot } from "@angular/router";
import { of } from "rxjs";
import { PedidoService } from "../pedido.service";
import { Pedido } from "../pedido.model";

@Injectable({
    providedIn: 'root'
})
export class PedidoResolver implements Resolve<Pedido>{
    constructor (private pedidoService: PedidoService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
        const id = route.params["id"];

        if(id){
            return this.pedidoService.read(id);
        }

        return of ({
            id:0,
            cliente: {
                id: 0,
                nome: '',
                email: ''
            },
            dataPedido: new Date()
        } as Pedido)
    }
}