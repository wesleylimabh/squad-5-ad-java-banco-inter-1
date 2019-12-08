package com.aceleradev.squad5.centralerros.mappers;

import com.aceleradev.squad5.centralerros.dto.ErroDto;
import com.aceleradev.squad5.centralerros.entity.Erro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ErroMapper {

//    @Mappings({
//            @Mapping(source = "id", target = "id"),
//            @Mapping(source = "ambiente", target = "ambiente"),
//            @Mapping(source = "level", target = "level"),
//            @Mapping(source = "data_hora", target = "data_hora"),
//            @Mapping(source = "titulo", target = "titulo"),
//            @Mapping(source = "origem", target = "origem"),
//            @Mapping(source = "eventos", target = "eventos")
//    })
//
//    public ErroDto map(Erro erro);
//
//    public List<ErroDto> map(List<Erro> erros);

        ErroDto erroToErroDto(Erro erro);

        List<ErroDto> errosToErrosDto(List<Erro> erros);
}
