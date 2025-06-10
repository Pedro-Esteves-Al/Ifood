package org.example;

public class PagamentoDinheiro implements Pagamento {
    @Override
    public String tipo() {
        return "Dinheiro";
    }
}
