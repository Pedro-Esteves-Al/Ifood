package org.example;

public class Notificacao {
    private EnviadorNotificacao enviador;
    private String messagem;
    private String mensagemCompleta;

    public Notificacao(EnviadorNotificacao enviador, String mensagem) {
        this.enviador = enviador;
        this.messagem = mensagem;
    }

    public void notificar() {
        enviador.enviar("Notificação de Pedido: " + this.messagem);
        this.mensagemCompleta = enviador.enviar("Notificação de Pedido: " + this.messagem);
    }

    @Override
    public String toString() {
        return this.mensagemCompleta;
    }

}
