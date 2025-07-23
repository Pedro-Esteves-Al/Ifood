package org.example;

import java.util.Observable;

public class Pedido extends Observable implements Cloneable {
    private PedidoEstado estado;
    private Pagamento formaDePagamento = new Pagamento();
    private String conteudoPedido;
    private Avaliacao avaliacao;

    public Pagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public String getConteudoPedido() {
        return conteudoPedido;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setConteudoPedido(String conteudoPedido) {
        this.conteudoPedido = conteudoPedido;
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

    public Pedido pedirNovamente() throws CloneNotSupportedException {
        Pedido pedido = (Pedido) this.clone();
        PedidoEstadoPreparando estado = PedidoEstadoPreparando.getPedidoEstadoPreparando();
        pedido.setEstado(estado);
        return pedido;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void receberAvaliacao(String texto, int nota, String imagem) {
        if (imagem == null) {
            this.avaliacao = new AvaliacaoSemImagem(texto, nota);
        } else {
            this.avaliacao = new AvaliacaoComImagem(texto, nota,imagem);
        }
    }

}
