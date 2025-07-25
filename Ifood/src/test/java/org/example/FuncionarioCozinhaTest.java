package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioCozinhaTest {
    Funcionario funcionario1;
    Funcionario funcionario2;

    @BeforeEach
    void setup() {
        funcionario1 = new FuncionarioCozinha("Marco", "cozinheiro");
        funcionario2 = new FuncionarioCozinha("Antonio", "lavador");
    }

    @Test
    void deveExibirInformacoesDaEquipe() {
        assertEquals("cozinheiro: Marco",funcionario1.exibirInformacoes());
        assertEquals("lavador: Antonio",funcionario2.exibirInformacoes());
    }

}