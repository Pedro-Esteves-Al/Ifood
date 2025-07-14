package org.example;

public class ClienteBuilder {
    private Cliente cliente;

    public ClienteBuilder() {
        cliente = new Cliente();
    }

    public Cliente build() {
        if (cliente.getCadastro().isEmpty()) {
            throw new IllegalArgumentException("Cadastro não informado");
        }
        return cliente;
    }

    public ClienteBuilder setInformacoesCadastro(String cadastro) {
        cliente.setCadastro(cadastro);
        return this;
    }

    public ClienteBuilder setEndereco(Endereco endereco) {
        cliente.setEndereco(endereco);
        return this;
    }
}
