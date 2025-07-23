package org.example;

public class AbrirChamadoSuporte implements Tarefa {

    private ChamadoSuporte chamadoSuporte ;

    public AbrirChamadoSuporte(ChamadoSuporte chamadoSuporte) {
        this.chamadoSuporte = chamadoSuporte;
    }

    public void executar() {
        this.chamadoSuporte.abrirChamado();
    }

    public void cancelar() {
        this.chamadoSuporte.fecharChamado();
    }
}
