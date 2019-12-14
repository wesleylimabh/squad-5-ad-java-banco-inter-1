package com.aceleradev.squad5.centralerros.enums;

import java.util.HashMap;
import java.util.Map;

public enum AmbienteEnum {

    PRODUCAO("Produção"),
    DESENVOLVIMENTO("Desenvolvimento"),
    HOMOLOGACAO("Homologação");

    public final String label;

    private static final Map<String, AmbienteEnum> ambientePorLabel= new HashMap<>();

    AmbienteEnum(String label) {
        this.label = label;
    }

    static {
        for(AmbienteEnum ambienteEnum : AmbienteEnum.values()){
            ambientePorLabel.put(ambienteEnum.label, ambienteEnum);
        }
    }

    public static AmbienteEnum buscarAmbientePorLabel(String label){
        return ambientePorLabel.get(label);
    }

}
