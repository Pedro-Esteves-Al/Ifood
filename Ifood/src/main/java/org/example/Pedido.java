package org.example;

import java.util.Observable;
import java.util.Observer;

public class Pedido extends Observable {
    private PedidoEstado estado;

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        atualizarStatus();
    }

    public void proximoEstado() {
        this.estado.proximoEstado(this);
    }

    public PedidoEstado verificaEstado() {
        return estado;
    }

    public Pedido() {
        PedidoEstadoPreparando preparando = PedidoEstadoPreparando.getPedidoEstadoPreparando();
        PedidoEstadoEntregando entregando = PedidoEstadoEntregando.getPedidoEstadoEntregando();
        PedidoEstadoEntregue entregue = PedidoEstadoEntregue.getPedidoEstadoEntregue();

        preparando.setProximo(entregando);
        entregando.setProximo(entregue);

        this.estado = preparando;

        //this.estado = PedidoEstadoPreparando.getPedidoEstadoPreparando();
    }

    public void atualizarStatus() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return this.estado.getEstado();
    }

}
