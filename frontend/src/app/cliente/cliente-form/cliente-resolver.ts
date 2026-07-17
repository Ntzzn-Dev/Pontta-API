import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, MaybeAsync, RedirectCommand, Resolve, RouterStateSnapshot } from "@angular/router";
import { Cliente } from "../cliente.model";
import { ClienteService } from "../cliente.service";
import { of } from "rxjs";
import { email } from "@angular/forms/signals";

@Injectable({
    providedIn: 'root'
})
export class ClienteResolver implements Resolve<Cliente>{
    constructor(private clienteService: ClienteService){}
    
    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params["id"];
        
        if(id){
            return this.clienteService.read(id);
        }

        return of ({
            id: 0,
            nome: '',
            email: ''
        });
    }
}