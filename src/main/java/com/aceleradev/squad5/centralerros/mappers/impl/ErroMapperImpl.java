package com.aceleradev.squad5.centralerros.mappers.impl;

import com.aceleradev.squad5.centralerros.dto.ErroDto;
import com.aceleradev.squad5.centralerros.entity.Erro;
import com.aceleradev.squad5.centralerros.mappers.ErroMapper;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public class ErroMapperImpl implements ErroMapper {
    @Override
    public ErroDto erroToErroDto(Erro erro) {

        ErroDto erroDto = new ErroDto();

        erroDto.setData_hora(erro.getData_hora());
        erroDto.setLevel(erro.getLevel());
        erroDto.setOrigem(erro.getOrigem());
        erroDto.setEventos(erro.getEventos());
        erroDto.setAmbiente(erro.getAmbiente());
        erroDto.setId(erro.getId());
        erroDto.setTitulo(erro.getTitulo());

        return erroDto;
        
    }

    @Override
    public List<ErroDto> errosToErrosDto(List<Erro> erros) {
        return erros.stream().map(erro -> erroToErroDto(erro))
                .collect(Collectors.toList());
    }
}
