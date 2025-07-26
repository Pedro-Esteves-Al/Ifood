package org.example;

public class ClienteProxy {
    Cliente cliente;


    public ClienteProxy(Cliente cliente) {
        this.cliente = cliente;
    }

    public void fazerPedido(Pedido pedido) {
        if (cliente.isLogado()) {
            cliente.fazerPedido(pedido);
        } else {
            throw new IllegalArgumentException("Cliente não está logado");
        }
    }
}
