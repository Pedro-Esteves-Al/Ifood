package org.example;

public class PlanoPremium extends PlanoDecorator {
    public PlanoPremium(Plano plano) {
        super(plano);
    }

    @Override
    public String getDescricao() {
        return plano.getDescricao() + " + adicional Premium";
    }

    @Override
    public double getPreco() {
        return plano.getPreco() + 10;
    }
}
