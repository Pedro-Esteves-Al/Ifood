package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PedidoTest {
    Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
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
    void deveTestarPagamentoPorPix() {
        assertEquals("Pagamento feito por Pix",pedido.pagarPorPix());
    }
    @Test
    void deveTestarPagamentoPorDinheiro() {
        assertEquals("Pagamento feito por Dinheiro",pedido.pagarPorDinheiro());
    }
    @Test
    void deveTestarPagamentoPorCartao() {
        assertEquals("Pagamento feito por Cartão",pedido.pagarPorCartao());
    }

}