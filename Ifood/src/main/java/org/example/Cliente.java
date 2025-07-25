package org.example;

import java.util.*;

public class Cliente implements Observer, Iterable<Pedido>, Usuario {
    private String nome;
    private String estadoPedido;
    private String cadastro;
    private Endereco endereco;
    private List<Tarefa> tarefas = new ArrayList<Tarefa>();
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private List<Notificacao> notificacoes = new ArrayList<Notificacao>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        Endereco endereco1 = EnderecoFactory.getEndereco(endereco.getRua(), endereco.getBairro());
        this.endereco = endereco1;
    }

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void fazerPedido(Pedido pedido) {
        if (ClienteFacade.verificarPendenciasPagamento(this)) {
            throw new IllegalArgumentException(
                "Cliente possui pagamento pendente, não poderá fazer novos pedidos até completa-lo"
            );
        }
        pedido.addObserver(this);
        //Faz o observer seja acionado assim q o pedido é feito.
        this.update(pedido, null);
        pedidos.add(pedido);
        Notificacao notificacao = new Notificacao(EnviadorEmail.getInstancia(),"Pedido confirmado");
        notificacao.notificar();
        this.notificacoes.add(notificacao);
    }

    public void update(Observable pedido, Object arg1) {
        this.estadoPedido = "Pedido está " + pedido.toString();
    }

    public void executarTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
        tarefa.executar();
    }

    public void cancelarUltimaTarefa() {
        if (!tarefas.isEmpty()) {
            Tarefa tarefa = this.tarefas.get(this.tarefas.size() - 1);
            tarefa.cancelar();
            this.tarefas.remove(this.tarefas.size() - 1);
        }
    }
    @Override
    public Iterator<Pedido> iterator() {
        return pedidos.iterator();
    }

    public void avaliarPedido(Pedido pedido,String texto, int nota, String imagem) {
        pedido.receberAvaliacao(texto,nota,imagem);
    }

    @Override
    public void aceitar(Visitor visitor) {
        visitor.visitar(this);
    }
    public String getAuditoria() {
        return "Entregador: " + this.nome + "fez um total de " + HistoricoDePedidos.contarTotalPedidosCliente(this) + " pedidos";
    }
}
