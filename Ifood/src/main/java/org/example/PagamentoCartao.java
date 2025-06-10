package org.example;

public class PagamentoCartao implements Pagamento {
    @Override
    public String tipo() {
        return "Cartão";
    }
}
