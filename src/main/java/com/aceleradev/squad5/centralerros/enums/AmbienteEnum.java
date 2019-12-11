package com.aceleradev.squad5.centralerros.enums;

public enum AmbienteEnum {

    PRODUCAO("Produção"),
    DESENVOLVIMENTO("Desenvolvimento"),
    HOMOLOGACAO("Homologação");

    public final String label;

    AmbienteEnum(String label) {
        this.label = label;
    }
}
