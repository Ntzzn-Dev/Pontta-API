import { HttpClient } from '@angular/common/http';
import { Injectable, Service } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from './cliente.model';

@Injectable({
    providedIn: 'root'
})
export class ClienteService {
    private baseURL = 'http://localhost:8080'
    private endpoint = 'clientes'

    constructor(private httpClient: HttpClient){ }

    listar() : Observable<Cliente[]> {
        return this.httpClient.get<Cliente[]>(`${this.baseURL}/${this.endpoint}`);
    }

    create(cli : Cliente): Observable<Cliente> {
        return this.httpClient.post<Cliente>(`${this.baseURL}/${this.endpoint}`, cli);
    }

    read(id: number) : Observable<Cliente> {
        return this.httpClient.get<Cliente>(`${this.baseURL}/${this.endpoint}/${id}`);
    }

    update(cli : Cliente, id: number): Observable<Cliente> {
        return this.httpClient.put<Cliente>(`${this.baseURL}/${this.endpoint}/${id}`, cli);
    }

    delete(id: number) : Observable<Cliente> {
        return this.httpClient.delete<Cliente>(`${this.baseURL}/${this.endpoint}/${id}`);
    }
}
