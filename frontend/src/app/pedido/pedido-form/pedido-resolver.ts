import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router";
import { PedidoService } from "../pedido.service";
import { Pedido } from "../pedido.model";
import { of } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PedidoResolver implements Resolve<Pedido>{
  constructor(private pedidoService: PedidoService){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const id = route.params["id"];
    
    if(id){
      return this.pedidoService.read(id);
    }

    return of ({
      id: 0,
      cliente: {
        id: 0,
        nome: '',
        contato: ''
      },
      dataPedido: new Date(),
      valorTotal: 0
    });
  }
}