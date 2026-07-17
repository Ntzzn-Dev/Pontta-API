import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Pedido } from "./pedido.model";
import { Observable } from "rxjs";
import { PedidoRequest } from "./pedido.request";

@Injectable({
    providedIn: 'root'
})
export class PedidoService{
    private URL = "http://localhost:8080/pedidos";

    constructor(private httpClient: HttpClient){}

    list() : Observable<Pedido[]>{
        return this.httpClient.get<Pedido[]>(this.URL);
    }

    create(ped: PedidoRequest) : Observable<Pedido> {
        return this.httpClient.post<Pedido>(this.URL, ped);
    }

    read(id : number) : Observable<Pedido> {
        return this.httpClient.get<Pedido>(`${this.URL}/${id}`);
    }

    update(id: number, ped: PedidoRequest): Observable<Pedido> {
        return this.httpClient.put<Pedido>(`${this.URL}/${id}`, ped);
    }

    delete(id: number): Observable<Pedido>{
        return this.httpClient.delete<Pedido>(`${this.URL}/${id}`);
    }
}