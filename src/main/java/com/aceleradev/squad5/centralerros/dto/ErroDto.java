package com.aceleradev.squad5.centralerros.dto;

import com.aceleradev.squad5.centralerros.enums.AmbienteEnum;
import com.aceleradev.squad5.centralerros.enums.LevelEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErroDto {

    private Long id;
    private AmbienteEnum ambiente;
    private LevelEnum level;
    private String data_hora;
    private String titulo;
    private String origem;
    private Integer eventos;

}
