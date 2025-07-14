package org.example;

import java.util.HashMap;
import java.util.Map;

public class EnderecoFactory {
    private static Map<String, Endereco> enderecos = new HashMap<>();

    public static Endereco getEndereco(String rua, String bairro) {
        Endereco endereco = enderecos.get(rua);
        if (endereco == null) {
            endereco = new Endereco(rua, bairro);
            enderecos.put(rua, endereco);
        }
        return endereco;
    }

    public static int getTotalEnderecos() {
        return enderecos.size();
    }
}
