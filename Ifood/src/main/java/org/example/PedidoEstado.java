package org.example;

public abstract class PedidoEstado {
    private PedidoEstado proximo;

    public void setProximo(PedidoEstado proximo) {
        this.proximo = proximo;
    }

    public void proximoEstado(Pedido pedido) {
        if (proximo != null) {
            pedido.setEstado(proximo);
        }
    }
    public abstract String getEstado();
}
