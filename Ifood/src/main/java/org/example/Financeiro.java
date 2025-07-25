package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Financeiro {
    private static List<Cliente> clientesComPendencia = new ArrayList<Cliente>();

    public static void addClientePendente(Cliente cliente) {
        clientesComPendencia.add(cliente);
    }

    public static boolean verificarClienteComPendencia(Cliente cliente) {
        return clientesComPendencia.contains(cliente);
    }
}
