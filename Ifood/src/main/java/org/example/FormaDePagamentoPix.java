package org.example;

public class FormaDePagamentoPix implements FormaDePagamento {

    private FormaDePagamentoPix() {};
    private static FormaDePagamentoPix instance = new FormaDePagamentoPix();
    public static FormaDePagamentoPix getInstance() {
        return instance;
    }
    @Override
    public String processar() {
        return "Pix";
    }
}
