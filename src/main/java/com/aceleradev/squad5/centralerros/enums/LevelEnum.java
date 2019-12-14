package com.aceleradev.squad5.centralerros.enums;

public enum LevelEnum {

    DEBUG("Debug"),
    ERROR("Erro"),
    WARNING("Warning");

    public final String label;

    LevelEnum(String label) {
        this.label = label;
    }
}
