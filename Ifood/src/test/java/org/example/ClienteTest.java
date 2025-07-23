package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    Pedido pedido;
    Cliente cliente;
    ChamadoSuporte chamadoSuporte;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
        cliente = new Cliente();
        cliente.fazerPedido(pedido);
        chamadoSuporte = new ChamadoSuporte();
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
    @Test
    void deveRetornarClienteValido() {
        ClienteBuilder clienteBuilder = new ClienteBuilder();
        Endereco endereco = new Endereco("Rua do ifet", "fábrica");
        Cliente cliente = clienteBuilder
                .setInformacoesCadastro("nome,email etc")
                .setEndereco(endereco)
                .build();

        assertNotNull(cliente);
    }
    @Test
    void deveRetornarExcecaoCadastroInvalido() {
        try {
            ClienteBuilder clienteBuilder = new ClienteBuilder();
            Cliente cliente = clienteBuilder
                    .setInformacoesCadastro("")
                    .build();
        } catch (IllegalArgumentException e) {
            assertEquals("Cadastro não informado", e.getMessage());
        }
    }

    @Test
    void deveRetornarTotalEnderecos() {
        Endereco endereco = EnderecoFactory.getEndereco("Rua do ifet", "fábrica");
        Endereco endereco2 = EnderecoFactory.getEndereco("Rua do ifet", "fábrica");
        Endereco endereco3 = EnderecoFactory.getEndereco("Rua2", "alto dos passos");

        assertEquals(2, EnderecoFactory.getTotalEnderecos());
    }

    @Test
    void deveAbrirChamadoSuporte() {
        Tarefa abrirChamadoSuporte = new AbrirChamadoSuporte(chamadoSuporte);
        cliente.executarTarefa(abrirChamadoSuporte);

        assertEquals("Chamado aberto", chamadoSuporte.getSituacao());
    }

    @Test
    void deveFecharChamadoSuporte() {
        Tarefa fecharChamadoSuporte = new FecharChamadoSuporte(chamadoSuporte);
        cliente.executarTarefa(fecharChamadoSuporte);

        assertEquals("Chamado fechado", chamadoSuporte.getSituacao());
    }

    @Test
    void deveCancelarFecharChamadoSuporte() {
        Tarefa abrirChamadoSuporte = new AbrirChamadoSuporte(chamadoSuporte);
        Tarefa fecharChamadoSuporte = new FecharChamadoSuporte(chamadoSuporte);

        cliente.executarTarefa(abrirChamadoSuporte);
        cliente.executarTarefa(fecharChamadoSuporte);

        cliente.cancelarUltimaTarefa();

        assertEquals("Chamado aberto", chamadoSuporte.getSituacao());
    }

}