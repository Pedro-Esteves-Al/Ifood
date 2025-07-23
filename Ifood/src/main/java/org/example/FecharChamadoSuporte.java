package org.example;

public class FecharChamadoSuporte implements Tarefa {

    private ChamadoSuporte chamadoSuporte ;

    public FecharChamadoSuporte(ChamadoSuporte chamadoSuporte) {
        this.chamadoSuporte = chamadoSuporte;
    }

    public void executar() {
        this.chamadoSuporte.fecharChamado();
    }

    public void cancelar() {
        this.chamadoSuporte.abrirChamado();
    }
}
