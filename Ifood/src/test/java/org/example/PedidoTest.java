package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PedidoTest {
    Pedido pedido;
    Cliente cliente;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
        cliente = new Cliente();
        cliente.fazerPedido(pedido);
    }

    @Test
    void deveTestarPedidoPreparando() {
        assertEquals("Preparando", pedido.verificaEstado().getEstado());
    }

    @Test
    void deveTestarPedidoEntregando() {
        pedido.proximoEstado();
        assertEquals("Entregando", pedido.verificaEstado().getEstado());
    }

    @Test
    void deveTestarPedidoEntregue() {
        pedido.proximoEstado(); // Entregando
        pedido.proximoEstado(); // Entregue
        assertEquals("Entregue", pedido.verificaEstado().getEstado());
    }

    @Test
    void testeEstadoNaoMudaDepoisDoFinal() {
        pedido.proximoEstado(); // Entregando
        pedido.proximoEstado(); // Entregue
        pedido.proximoEstado(); // não deve mudar aqi
        assertEquals("Entregue", pedido.verificaEstado().getEstado());
    }

    @Test
    void deveNotificarCliente() {
        pedido.proximoEstado();
        assertEquals("Pedido está Entregando", cliente.getEstadoPedido());
    }

    @Test
    void naoDeveNotificarClienteQueNaoFezPedido() {
        Cliente cliente2 = new Cliente();

        assertEquals("Pedido está Preparando",cliente.getEstadoPedido());
        assertNull(cliente2.getEstadoPedido());
    }

    @Test
    void deveTestarPagamentoPorPix() {
        pedido.pagarPorPix();
        assertEquals("Pagamento feito por Pix",pedido.getFormaDePagamento());
    }
    @Test
    void deveTestarPagamentoPorDinheiro() {
        pedido.pagarPorDinheiro();
        assertEquals("Pagamento feito por Dinheiro",pedido.getFormaDePagamento());
    }
    @Test
    void deveTestarPagamentoPorCartao() {
        pedido.pagarPorCartao();
        assertEquals("Pagamento feito por Cartão",pedido.getFormaDePagamento());
    }

}