import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Produto } from "./produto.model";

@Injectable({
    providedIn: 'root'
})
export class ProdutoService{
    private readonly baseURL = 'http://localhost:8080';
    private readonly endpoint = 'produtos';

    constructor(private httpCliente: HttpClient ){}

    listar() : Observable<Produto[]> {
        return this.httpCliente.get<Produto[]>(`${this.baseURL}/${this.endpoint}`);
    }

    create(prod : Produto) : Observable<Produto> {
        return this.httpCliente.post<Produto>(`${this.baseURL}/${this.endpoint}`, prod);
    }

    read(id: number) : Observable<Produto> {
        return this.httpCliente.get<Produto>(`${this.baseURL}/${this.endpoint}/${id}`);
    }

    update(id: number, prod: Produto) : Observable<Produto>{
        return this.httpCliente.put<Produto>(`${this.baseURL}/${this.endpoint}/${id}`, prod);
    }

    delete(id: number) : Observable<Produto> {
        return this.httpCliente.delete<Produto>(`${this.baseURL}/${this.endpoint}/${id}`);
    }
}