package org.example;

import java.util.Observable;
import java.util.Observer;

public class Pedido extends Observable {
    private PedidoEstado estado;
    private String formaDePagamento;

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

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
    }

    public void atualizarStatus() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return this.estado.getEstado();
    }

    public String pagar(Pagamento pagamento) {
        return this.formaDePagamento = pagamento.tipo();
    }

}
