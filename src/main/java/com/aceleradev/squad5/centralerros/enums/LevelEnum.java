package com.aceleradev.squad5.centralerros.enums;

public enum LevelEnum {

    ERROR("Erro"),
    WARNING("Warning"),
    DEBUG("Debug");

    public final String label;

    LevelEnum(String label) {
        this.label = label;
    }
}
