package org.example;

public class PedidoEstadoEntregando extends PedidoEstado{
    private PedidoEstadoEntregando() {};
    private static PedidoEstadoEntregando pedidoEstadoEntregando = new PedidoEstadoEntregando();

    public static PedidoEstadoEntregando getPedidoEstadoEntregando() {
        return pedidoEstadoEntregando;
    }
    public String getEstado() {
        return "Entregando";
    }
}
