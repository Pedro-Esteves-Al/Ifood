package org.example;

public class ClienteFacade {
    public static boolean verificarPendenciasPagamento(Cliente cliente) {
        return Financeiro.verificarClienteComPendencia(cliente);
    }
}
