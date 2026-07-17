import { Cliente } from "../cliente/cliente.model";

export interface Pedido{
    id: number,
    cliente: Cliente,
    dataPedido: Date
}