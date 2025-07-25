package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificacaoTest {
    @Test
    void deveEnviarNotificacaoPorEmail() {
        Notificacao notificacao = new Notificacao(EnviadorEmail.getInstancia(),"Pedido confirmado");
        notificacao.notificar();
        assertEquals("EMAIL: Notificação de Pedido: Pedido confirmado",notificacao.toString());
    }
}