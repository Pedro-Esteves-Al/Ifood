package org.example;

import java.util.Observable;

public class Pedido extends Observable {
    private PedidoEstado estado;
    private Pagamento formaDePagamento = new Pagamento();

    public Pagamento getFormaDePagamento() {
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

    public String pagarPorPix() {
        return this.formaDePagamento.processarPagamento(FormaDePagamentoPix.getInstance());
    }
    public String pagarPorCartao() {
        return this.formaDePagamento.processarPagamento(FormaDePagamentoCartao.getInstance());
    }
    public String pagarPorDinheiro() {
        return this.formaDePagamento.processarPagamento(FormaDePagamentoDinheiro.getInstance());
    }

}
