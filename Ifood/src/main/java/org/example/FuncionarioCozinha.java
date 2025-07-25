package org.example;

public class FuncionarioCozinha implements Funcionario {
    private String nome;
    private String cargo;

    public FuncionarioCozinha(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    @Override
    public String exibirInformacoes() {
        return cargo + ": " + nome;
    }
}
