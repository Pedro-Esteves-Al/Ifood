package org.example;

public class AvaliacaoComImagem extends Avaliacao {

    public AvaliacaoComImagem(String texto, int nota, String imagem) {
        super(texto, nota);
        this.setImagem(imagem);
    }

    @Override
    public String postarAvaliacao() {
        return  getGerencia().analisarAvaliacao(this);
    }
}
