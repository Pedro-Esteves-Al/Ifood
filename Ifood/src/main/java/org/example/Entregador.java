package org.example;

import java.util.ArrayList;
import java.util.List;

public class Entregador implements Usuario {

    private String nome;
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Entregador(String nome) {
        this.nome = nome;
    }

    public int getTotalEntregasRealizadas() {
        return pedidos.size();
    }

    public void adicionarPedidoNaListaDeEntregas(Pedido pedido) {
        pedidos.add(pedido);
    }

    public String getAuditoria() {
        return "Entregador: " + this.nome + " fez um total de " + getTotalEntregasRealizadas() + " entrega(s)";
    }

    @Override
    public void aceitar(Visitor visitor) {
        visitor.visitar(this);
    }
}
