import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Cliente } from "./cliente.model";
import { HttpClient } from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class ClienteService{
    private URL = "http://localhost:8080/clientes";

    constructor(private httpClient: HttpClient){}

    list() : Observable<Cliente[]>{
        return this.httpClient.get<Cliente[]>(this.URL);
    }

    create(cli: Cliente) : Observable<Cliente> {
        return this.httpClient.post<Cliente>(this.URL, cli);
    }

    read(id : number) : Observable<Cliente> {
        return this.httpClient.get<Cliente>(`${this.URL}/${id}`);
    }

    update(id: number, cli: Cliente): Observable<Cliente> {
        return this.httpClient.put<Cliente>(`${this.URL}/${id}`, cli);
    }

    delete(id: number): Observable<Cliente>{
        return this.httpClient.delete<Cliente>(`${this.URL}/${id}`);
    }
}