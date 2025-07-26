package org.example;

public class PlanoEntregaGratis extends PlanoDecorator {
    public PlanoEntregaGratis(Plano plano) {
        super(plano);
    }

    @Override
    public String getDescricao() {
        return plano.getDescricao() + " + Entrega Grátis";
    }

    @Override
    public double getPreco() {
        return plano.getPreco() + 5.00;
    }
}
