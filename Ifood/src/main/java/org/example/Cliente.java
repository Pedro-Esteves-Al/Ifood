package org.example;

import java.util.*;

public class Cliente implements Observer, Iterable<Pedido>{
    private String estadoPedido;
    private String cadastro;
    private List<Tarefa> tarefas = new ArrayList<Tarefa>();
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    private Endereco endereco;

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

    public void fazerPedido(Pedido pedido) {

        pedido.addObserver(this);
        //Faz o observer seja acionado assim q o pedido é feito.
        this.update(pedido, null);
        pedidos.add(pedido);
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

}
