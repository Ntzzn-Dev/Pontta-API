import { ProdutoResponse } from "./produto-response.model";

export interface PedidoProdutoResponse{
    id : number,
    nomeDoCliente : string,
    emailDoCliente: string,
    produtos: ProdutoResponse[],
    dataDoPedido: Date
}