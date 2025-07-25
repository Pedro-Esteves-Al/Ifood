package org.example;

public class PedidoAdapter extends Pedido {
    //Imaginando que esta é uma integração com outra plataforma, talvez um app específico do cliente? Aí o adapter
    // faria o ajuste na estrutura para que o ifood pudesse usar.
    private String tipoDePao;
    private String carne;
    private String salada;

    public PedidoAdapter(String tipoDePao, String carne, String salada) {
        this.tipoDePao = tipoDePao;
        this.carne = carne;
        this.salada = salada;
    }

    public String getTipoDePao() {
        return tipoDePao;
    }

    public void setTipoDePao(String tipoDePao) {
        this.tipoDePao = tipoDePao;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getSalada() {
        return salada;
    }

    public void setSalada(String salada) {
        this.salada = salada;
    }

    @Override
    public String getConteudoPedido() {
        super.setConteudoPedido(this.getTipoDePao() + " " + this.getCarne()+ " " + this.getSalada());
        return super.getConteudoPedido();
    }
}
