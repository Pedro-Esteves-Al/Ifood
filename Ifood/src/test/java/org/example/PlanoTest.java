package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanoTest {
    Plano planoBase = new PlanoBase();

    @Test
    void deveRetornarDescricaoPlanoBase() {
        assertEquals("Plano Básico (cashback 10%)",planoBase.getDescricao());
    }
    @Test
    void deveRetornarPrecoPlanoBase() {
        assertEquals(10,planoBase.getPreco());
    }

    @Test
    void deveRetornarDescricaoPlanoEntregaGratis() {
        planoBase = new PlanoEntregaGratis(planoBase);
        assertEquals("Plano Básico (cashback 10%) + Entrega Grátis",planoBase.getDescricao());
    }

    @Test
    void deveRetornarPrecoPlanoEntregaGratis() {
        planoBase = new PlanoEntregaGratis(planoBase);
        assertEquals(15,planoBase.getPreco());
    }
    @Test
    void deveValidarPlanoPremium() {
        planoBase = new PlanoPremium(new PlanoEntregaGratis(planoBase));
        assertEquals("Plano Básico (cashback 10%) + Entrega Grátis + adicional Premium",planoBase.getDescricao());
        assertEquals(25,planoBase.getPreco());
    }

}