import { ProdutoPedidoResponse } from "../produto/produto-pedido-response.model";

export interface PedidoProduto{
    id: number,
    nomeDoCliente: string,
    contatoDoCliente: string,
    produtos: ProdutoPedidoResponse[],
    valorTotalPedido: number,
    dataDoPedido: Date
}