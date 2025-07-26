package org.example;

public class PlanoBase implements Plano {
    @Override
    public String getDescricao() {
        return "Plano Básico (cashback 10%)";
    }

    @Override
    public double getPreco() {
        return 10;
    }
}
