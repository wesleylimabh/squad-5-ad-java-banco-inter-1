package com.aceleradev.squad5.centralerros.service.interfaces;

import com.aceleradev.squad5.centralerros.dto.ErroDto;
import com.aceleradev.squad5.centralerros.dto.ErroFiltroDto;
import com.aceleradev.squad5.centralerros.entity.Erro;
import com.aceleradev.squad5.centralerros.enums.AmbienteEnum;
import com.aceleradev.squad5.centralerros.enums.LevelEnum;

import java.util.List;

public interface ErroServiceInterface {

    Erro findById(Long id);

    void delete(Long id);

    void arquivar(Long id);

    void  save(Erro erro);

    List<ErroDto> findAll(ErroFiltroDto erroFiltroDto);

    List<Erro> findAllByAmbiente(AmbienteEnum ambienteEnum);

    List<Erro> findByDescricao(String descricao);

    List<Erro> findByDescricaoContainingAndAmbiente(String descricao, AmbienteEnum ambiente);
}
