package com.aceleradev.squad5.centralerros.dto;

import com.aceleradev.squad5.centralerros.enums.AmbienteEnum;
import com.aceleradev.squad5.centralerros.enums.LevelEnum;

public class ErroDto {

    private Long id;
    private AmbienteEnum ambiente;
    private LevelEnum level;
    private String data_hora;
    private String titulo;
    private String origem;
    private Integer eventos;

}
