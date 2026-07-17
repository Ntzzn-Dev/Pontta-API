import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { PedidoProdutoResponse } from "./pedido-produto-response.model";
import { PedidoProdutoRequest } from "./pedido-produto-request.model";

@Injectable({
    providedIn: 'root'
})
export class PedidoProdutoService{
    private URL = "http://localhost:8080/pedidos";
    private endpoint = "produtos"

    constructor(private httpClient: HttpClient){}

    list(id : number) : Observable<PedidoProdutoResponse>{
        return this.httpClient.get<PedidoProdutoResponse>(`${this.URL}/${id}/${this.endpoint}`);
    }

    create(id : number, prod: PedidoProdutoRequest) : Observable<PedidoProdutoResponse> {
        return this.httpClient.post<PedidoProdutoResponse>(`${this.URL}/${id}/${this.endpoint}`, prod);
    }

    //Não será usado
    read(id : number) : Observable<PedidoProdutoResponse> {
        return this.httpClient.get<PedidoProdutoResponse>(`${this.URL}/${id}/${this.endpoint}`);
    }

    //Não será usado
    update(id: number, prod: PedidoProdutoRequest): Observable<PedidoProdutoResponse> {
        return this.httpClient.put<PedidoProdutoResponse>(`${this.URL}/${id}/${this.endpoint}`, prod);
    }

    delete(id: number, idProduto: number): Observable<PedidoProdutoResponse>{
        return this.httpClient.delete<PedidoProdutoResponse>(`${this.URL}/${id}/${this.endpoint}/${idProduto}`);
    }
}