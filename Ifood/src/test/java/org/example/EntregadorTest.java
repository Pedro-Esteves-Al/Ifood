package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntregadorTest {
    Entregador entregador = new Entregador("Marco");
    Entregador entregador2 = new Entregador("Antonio");
    Pedido pedido = new Pedido();
    Pedido pedido2 = new Pedido();
    Visitor auditoria;

    @BeforeEach
    void setUp() {
        auditoria = new AuditorVisitor();
    }

    @Test
    void deveTestarAuditoriaComEntregas() {
        entregador.adicionarPedidoNaListaDeEntregas(pedido);
        entregador.adicionarPedidoNaListaDeEntregas(pedido2);
        entregador.aceitar(auditoria);
        assertEquals("Entregador: Marco fez um total de 2 entrega(s)",auditoria.getAuditoria());

    }

    @Test
    void deveTestarAuditoriaSemEntregas() {
        entregador2.aceitar(auditoria);
        assertEquals("Entregador: Antonio fez um total de 0 entrega(s)",auditoria.getAuditoria());
    }
}