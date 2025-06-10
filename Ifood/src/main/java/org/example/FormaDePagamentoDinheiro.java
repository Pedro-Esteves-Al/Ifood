package org.example;

public class FormaDePagamentoDinheiro implements FormaDePagamento {
    private FormaDePagamentoDinheiro() {};
    private static FormaDePagamentoDinheiro instance = new FormaDePagamentoDinheiro();
    public static FormaDePagamentoDinheiro getInstance() {
        return instance;
    }
    public String processar() {
        return "Dinheiro";
    }
}
