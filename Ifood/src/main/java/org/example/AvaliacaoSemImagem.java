package org.example;

public class AvaliacaoSemImagem extends Avaliacao{
    public AvaliacaoSemImagem(String texto, int nota) {
        super(texto, nota);
    }

    @Override
    public String postarAvaliacao() {
        if (getNota() < 3) {
          return  getGerencia().analisarAvaliacao(this);
        } else {
            return "Avaliacao Postada sem imagem";
        }
    }
}
