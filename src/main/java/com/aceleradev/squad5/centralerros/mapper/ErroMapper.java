package com.aceleradev.squad5.centralerros.mapper;

import com.aceleradev.squad5.centralerros.dto.ErroDto;
import com.aceleradev.squad5.centralerros.entity.Erro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ErroMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "ambiente", target = "ambiente"),
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "data_hora", target = "data_hora"),
            @Mapping(source = "titulo", target = "titulo"),
            @Mapping(source = "origem", target = "origem"),
            @Mapping(source = "eventos", target = "eventos"),
            @Mapping(source = "descricao", target = "descricao")
    })

    public ErroDto map(Erro erro);

}
