package org.example;

public class PedidoEstadoEntregue extends PedidoEstado {
    private PedidoEstadoEntregue() {};
    private static PedidoEstadoEntregue pedidoEstadoEntregue = new PedidoEstadoEntregue();

    public static PedidoEstadoEntregue getPedidoEstadoEntregue() {
        return pedidoEstadoEntregue;
    }

    public String getEstado() {
        return "Entregue";
    }
}
