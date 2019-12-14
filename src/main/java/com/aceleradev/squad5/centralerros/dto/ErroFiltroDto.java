package com.aceleradev.squad5.centralerros.dto;

import com.aceleradev.squad5.centralerros.enums.AmbienteEnum;
import com.aceleradev.squad5.centralerros.service.interfaces.ErroServiceInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErroFiltroDto {

    private String ambiente;
    private String descricao;
    private String ordenacao;

    public static final String FILTRO_DUPLO = "FILTRO_DUPLO";
    public static final String FILTRO_AMBIENTE = "FILTRO_AMBIENTE";
    public static final String FILTRO_DESCRICAO = "FILTRO_DESCRICAO";
    public static final String NENHUM = "NENHUM";


    public String filtra() {

        if (Objects.nonNull(ambiente) && Objects.nonNull(descricao)){
            return FILTRO_DUPLO;
        }

        if (Objects.nonNull(ambiente)){
            return FILTRO_AMBIENTE;
        }

        if (Objects.nonNull(descricao)){
            return FILTRO_DESCRICAO;
        }

        return NENHUM;
    }

}
