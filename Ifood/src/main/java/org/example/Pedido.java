package org.example;

import java.util.Observable;
import java.util.Observer;

public class Pedido extends Observable {
    private PedidoEstado estado;

    public PedidoEstado getEstado() {
        return estado;
    }

    public Pedido() {
        this.estado = PedidoEstadoPreparando.getPedidoEstadoPreparando();
    }

    public void atualizarStatus() {
        setChanged();
        notifyObservers();
    }
}
