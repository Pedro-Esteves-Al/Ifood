package org.example;

public interface EnviadorNotificacao  {
    // A ideia é que psosam existir diferentes tipos de enviadores, por exemplo EnviadorWhatsapp
    String enviar(String mensagem);
}
