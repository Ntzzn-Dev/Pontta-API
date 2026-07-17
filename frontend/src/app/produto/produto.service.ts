import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Produto } from "./produto.model";

@Injectable({
    providedIn: 'root'
})
export class ProdutoService{
    private URL = "http://localhost:8080/produtos";

    constructor(private httpClient: HttpClient){}

    list() : Observable<Produto[]>{
        return this.httpClient.get<Produto[]>(this.URL);
    }

    create(prod: Produto) : Observable<Produto> {
        return this.httpClient.post<Produto>(this.URL, prod);
    }

    read(id : number) : Observable<Produto> {
        return this.httpClient.get<Produto>(`${this.URL}/${id}`);
    }

    update(id: number, prod: Produto): Observable<Produto> {
        return this.httpClient.put<Produto>(`${this.URL}/${id}`, prod);
    }

    delete(id: number): Observable<Produto>{
        return this.httpClient.delete<Produto>(`${this.URL}/${id}`);
    }
}