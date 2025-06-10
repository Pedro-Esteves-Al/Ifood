package org.example;

import java.util.Observable;

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

    public void pagarPorPix() {
        Pagamento pagamento = new Pagamento();
        this.formaDePagamento = pagamento.processarPagamento(FormaDePagamentoPix.getInstance());
    }
    public void pagarPorCartao() {
        Pagamento pagamento = new Pagamento();
        this.formaDePagamento = pagamento.processarPagamento(FormaDePagamentoCartao.getInstance());
    }
    public void pagarPorDinheiro() {
        Pagamento pagamento = new Pagamento();
        this.formaDePagamento = pagamento.processarPagamento(FormaDePagamentoDinheiro.getInstance());
    }

}
