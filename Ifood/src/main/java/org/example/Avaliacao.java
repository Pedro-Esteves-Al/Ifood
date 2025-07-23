package org.example;

public abstract class Avaliacao {
    private String texto;
    private int nota;
    private String imagem; //finge que é arquivo.
    private Gerencia gerencia = Gerencia.getInstancia();

    public Avaliacao(String texto, int nota) {
        this.texto = texto;
        this.nota = nota;
    }

    public Gerencia getGerencia() {
        return gerencia;
    }

    public void setGerencia(Gerencia gerencia) {
        this.gerencia = gerencia;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public abstract String  postarAvaliacao();

}
