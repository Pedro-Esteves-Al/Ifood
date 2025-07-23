package org.example;

public class Gerencia {

    private static Gerencia instancia = new Gerencia();

    private Gerencia() {}

    public static Gerencia getInstancia() {
        return instancia;
    }

    public String analisarAvaliacao(Avaliacao avaliacao) {
        return "Avaliacao em análise";
    }
}
