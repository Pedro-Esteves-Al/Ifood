package org.example;

public class Pagamento {
    public String processarPagamento(FormaDePagamento formaDePagamento) {
        return "Pagamento feito por "+formaDePagamento.processar();
    }
}
