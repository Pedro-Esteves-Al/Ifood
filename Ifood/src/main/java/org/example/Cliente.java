package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String estadoPedido;

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void fazerPedido(Pedido pedido) {

        pedido.addObserver(this);
        //Faz o observer seja acionado assim q o pedido é feito.
        this.update(pedido, null);
    }

    public void update(Observable pedido, Object arg1) {
        this.estadoPedido = "Pedido está " + pedido.toString();
    }

}
