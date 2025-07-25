package org.example;

public class EnviadorEmail implements EnviadorNotificacao {
    private static EnviadorEmail enviadorEmail = new EnviadorEmail();

    private EnviadorEmail() {};

    public static EnviadorEmail getInstancia() {
        return enviadorEmail;
    }
    @Override
    public String enviar(String mensagem) {
        return "EMAIL: " + mensagem;
    }
}
