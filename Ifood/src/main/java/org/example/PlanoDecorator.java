package org.example;

public abstract class PlanoDecorator implements Plano {
    protected Plano plano;

    public PlanoDecorator(Plano plano) {
        this.plano = plano;
    }
}
