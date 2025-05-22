package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String estadoPedido;

    public void fazerPedido(Pedido pedido) {
        pedido.addObserver(this);
    }

    public void update(Observable pedido, Object arg1) {
        //tem um erro aqui
        this.estadoPedido = "Pedido" + pedido.getEstado();
    }
}
