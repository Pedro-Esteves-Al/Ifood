package org.example;

public class Endereco {
    private String rua;
    private String bairro;

    public Endereco(String rua, String bairro) {
        this.rua = rua;
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }
}
