import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Pedido } from "./pedido.model";
import { PedidoProdutoRequest } from "./pedido-produto-request.model";
import { PedidoRequest } from "./pedido-request.model";
import { PedidoProduto } from "./pedido-produto.model";

@Injectable({
    providedIn: 'root'
})
export class PedidoService{
    private readonly baseURL = 'http://localhost:8080';
    private readonly endpoint = 'pedidos';
    private readonly endpoint2 = 'produtos';

    constructor(private httpClient: HttpClient){}

    listar(): Observable<Pedido[]> {
        return this.httpClient.get<Pedido[]>(`${this.baseURL}/${this.endpoint}`);
    }

    create(ped: PedidoRequest): Observable<Pedido> {
        return this.httpClient.post<Pedido>(`${this.baseURL}/${this.endpoint}`, ped);
    }

    read(id: number): Observable<Pedido> {
        return this.httpClient.get<Pedido>(`${this.baseURL}/${this.endpoint}/${id}`);
    }

    update(id: number, ped: PedidoRequest): Observable<Pedido> {
        return this.httpClient.put<Pedido>(`${this.baseURL}/${this.endpoint}/${id}`, ped);
    }

    delete(id: number): Observable<Pedido> {
        return this.httpClient.delete<Pedido>(`${this.baseURL}/${this.endpoint}/${id}`);
    }

    // PEDIDO PRODUTO

    listarProds(id: number) : Observable<PedidoProduto>{
        return this.httpClient.get<PedidoProduto>(`${this.baseURL}/${this.endpoint}/${id}/${this.endpoint2}`);
    }

    addProds(id: number, idsProdutos: number[]) : Observable<PedidoProduto> {
        const idsSemDuplicatas = [...new Set(idsProdutos)];

        for (const idProd of idsSemDuplicatas) {
            const request: PedidoProdutoRequest = {
                idProduto: idProd,
                qnt: idsProdutos.filter(i => i === idProd).length
            };

            this.addProd(id, request).subscribe(
                resposta => {
                    console.log("Produto adicionado:", resposta);
                },
                erro => {
                    console.error("Erro ao adicionar produto:", erro);
                }
            );
        }

        return this.listarProds(id);
    }

    addProd(id: number, pedProd: PedidoProdutoRequest): Observable<PedidoProduto> {
        return this.httpClient.post<PedidoProduto>(`${this.baseURL}/${this.endpoint}/${id}/${this.endpoint2}`, pedProd);
    }

    removeProd(id: number, idProduto: number): Observable<PedidoProduto> {
        return this.httpClient.delete<PedidoProduto>(`${this.baseURL}/${this.endpoint}/${id}/${this.endpoint2}/${idProduto}`);
    }
}