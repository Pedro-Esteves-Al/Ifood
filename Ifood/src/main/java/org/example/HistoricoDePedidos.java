package org.example;

import java.util.Iterator;

public class HistoricoDePedidos {

    private HistoricoDePedidos() {};
    private static HistoricoDePedidos instance = new HistoricoDePedidos();
    public static HistoricoDePedidos getInstance() {
        return instance;
    }
    public static Integer contarTotalPedidosCliente(Cliente cliente) {
        int quantidade = 0;
        for (Iterator a = cliente.iterator(); a.hasNext(); ) {
            quantidade++;
            a.next();
        }
        return quantidade;
    }
}
