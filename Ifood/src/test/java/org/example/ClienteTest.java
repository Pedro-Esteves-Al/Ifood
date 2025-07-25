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

    @Test
    void deveContarTotalPedidosHistoricoDePedidos() {
        cliente.fazerPedido(new Pedido());
        assertEquals(2, HistoricoDePedidos.contarTotalPedidosCliente(cliente));
    }

    @Test
    void deveAvaliarPedidoSemImagemESemPassarPelaGerencia() {
        cliente.avaliarPedido(pedido,"bom",3,null);
        assertEquals(3,pedido.getAvaliacao().getNota());
        assertEquals("Avaliacao Postada sem imagem", pedido.getAvaliacao().postarAvaliacao());
    }

    @Test
    void deveAvaliarPedidoSemImagemPassandoPorGerencia() {
        cliente.avaliarPedido(pedido,"bom",2,"foto de hamburguer");
        assertEquals("Avaliacao em análise", pedido.getAvaliacao().postarAvaliacao());
    }
    @Test
    void deveAvaliarPedidoComImagem() {
        cliente.avaliarPedido(pedido,"bom",3,"foto de hamburguer");
        assertEquals("Avaliacao em análise", pedido.getAvaliacao().postarAvaliacao());
    }

    @Test
    void deveLancarExcecaoQuandoClienteTemPendencia() {
        try {
        Cliente cliente3 = new Cliente();
        Financeiro.addClientePendente(cliente3);

        cliente3.fazerPedido(pedido);
        fail();

        } catch (IllegalArgumentException e) {
            assertEquals("Cliente possui pagamento pendente, não poderá fazer novos pedidos até completa-lo", e.getMessage());
        }
    }
    @Test
    void deveConfirmarQueClienteRecebeuNotificacaoPorEmail() {
        assertEquals("[EMAIL: Notificação de Pedido: Pedido confirmado]",cliente.getNotificacoes().toString());
    }
    @Test
    void deveAuditarCliente() {
        Visitor auditoria = new AuditorVisitor();
        cliente.aceitar(auditoria);
        
    }

}