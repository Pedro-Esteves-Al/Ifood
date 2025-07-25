package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipeTest {
    Funcionario funcionario1;
    Funcionario funcionario2;
    Equipe equipe;

    @BeforeEach
    void setup() {
        funcionario1 = new FuncionarioCozinha("Marco", "cozinheiro");
        funcionario2 = new FuncionarioCozinha("Antonio", "lavador");
        equipe = new Equipe("Noite");
        equipe.addFuncionario(funcionario1);
        equipe.addFuncionario(funcionario2);
    }

    @Test
    void deveExibirInformacoesDaEquipe() {
        assertEquals("Turno da Noite" + "\n" +
                "cozinheiro: Marco" + "\n" +
                "lavador: Antonio" + "\n",
                equipe.exibirInformacoes());
    }

}