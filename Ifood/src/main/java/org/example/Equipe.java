package org.example;

import java.util.ArrayList;
import java.util.List;

public class Equipe implements Funcionario{
    private String turno;
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Equipe(String turno) {
        this.turno = turno;
    }

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public String exibirInformacoes() {
        String informacoes = "Turno da " + turno + "\n";
        for (Funcionario funcionario : funcionarios) {
            informacoes += funcionario.exibirInformacoes() + "\n";
        }
        return informacoes;
    }
}
