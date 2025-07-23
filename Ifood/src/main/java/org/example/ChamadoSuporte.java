package org.example;

public class ChamadoSuporte {
    String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void abrirChamado() {
        this.situacao = "Chamado aberto";
    }

    public void fecharChamado() {
        this.situacao = "Chamado fechado";
    }
}
