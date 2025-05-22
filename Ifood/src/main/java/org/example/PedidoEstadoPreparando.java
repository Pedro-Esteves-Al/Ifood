package org.example;

public class PedidoEstadoPreparando extends PedidoEstado {
    private PedidoEstadoPreparando() {};
    private static PedidoEstadoPreparando pedidoEstadoPreparando = new PedidoEstadoPreparando();

    public static PedidoEstadoPreparando getPedidoEstadoPreparando() {
        return pedidoEstadoPreparando;
    }

    public String getEstado() {
        return "Preparando";
    }
}
