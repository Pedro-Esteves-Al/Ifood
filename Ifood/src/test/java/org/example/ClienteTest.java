package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    Pedido pedido;
    Cliente cliente;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
        cliente = new Cliente();
        cliente.fazerPedido(pedido);
    }

    @Test
    void deveNotificarClienteQuandoPedidoFeito() {
        assertEquals("Pedido está Preparando", cliente.getEstadoPedido());
    }

    @Test
    void deveNotificarClienteMudancaDeEstado() {
        pedido.proximoEstado();
        assertEquals("Pedido está Entregando", cliente.getEstadoPedido());
    }

    @Test
    void naoDeveNotificarClienteQueNaoFezPedido() {
        Cliente cliente2 = new Cliente();

        assertEquals("Pedido está Preparando",cliente.getEstadoPedido());
        assertNull(cliente2.getEstadoPedido());
    }

}