import { Injectable, Service } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { ClienteService } from '../cliente.service';
import { Cliente } from '../cliente.model';
import { of } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class ClienteResolver implements Resolve<Cliente> {
    constructor(private clienteService: ClienteService){}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
        const id = route.params["id"];
        if(id){
            return this.clienteService.read(id);
        }
        
        return of({
            id: 0,
            nome: '',
            contato: ''
        } as Cliente);
    }
}
