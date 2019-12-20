package com.aceleradev.squad5.centralerros.service.interfaces;

import com.aceleradev.squad5.centralerros.dto.ErroDto;
import com.aceleradev.squad5.centralerros.dto.ErroFiltroDto;
import com.aceleradev.squad5.centralerros.entity.Erro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ErroServiceInterface {

    Erro findById(Long id);

    void delete(Long id);

    Erro save(Erro erro);

    Page<ErroDto> findAll(ErroFiltroDto erroFiltroDto, Pageable pageable);

}
