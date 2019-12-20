package com.aceleradev.squad5.centralerros.service.impl;

import com.aceleradev.squad5.centralerros.dto.ErroDto;
import com.aceleradev.squad5.centralerros.dto.ErroFiltroDto;
import com.aceleradev.squad5.centralerros.entity.Erro;
import com.aceleradev.squad5.centralerros.enums.AmbienteEnum;
import com.aceleradev.squad5.centralerros.exceptions.ResourceNotFoundException;
import com.aceleradev.squad5.centralerros.mapper.ErroMapper;
import com.aceleradev.squad5.centralerros.repository.ErroRepository;
import com.aceleradev.squad5.centralerros.service.interfaces.ErroServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ErroServiceImpl implements ErroServiceInterface {

    private final ErroRepository repository;

    private final ErroMapper mapper;

    @Autowired
    public ErroServiceImpl(ErroRepository repository, ErroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Erro findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Log não encontrado"));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public Erro save(Erro erro) {
        return repository.save(erro);
    }

    @Override
    public Page<ErroDto> findAll(ErroFiltroDto erroFiltroDto, Pageable pageable) {

        String filtro = erroFiltroDto.filtra();
        AmbienteEnum ambienteEnum = AmbienteEnum.buscarAmbientePorLabel(erroFiltroDto.getAmbiente());

        if (filtro.equals(ErroFiltroDto.FILTRO_DUPLO)){
            String filtroDescricao = erroFiltroDto.getDescricao();
            return repository
                    .findByDescricaoContainingAndAmbienteAndArquivadoIsFalse(filtroDescricao, ambienteEnum, pageable)
                    .map(mapper::map);
        }

        if (filtro.equals(ErroFiltroDto.FILTRO_AMBIENTE)){
            return repository
                    .findAllByAmbienteAndArquivadoIsFalse(ambienteEnum, pageable)
                    .map(mapper::map);
        }

        if (filtro.equals(ErroFiltroDto.FILTRO_DESCRICAO)){
            return repository
                    .findByDescricaoContainingAndArquivadoIsFalse(erroFiltroDto.getDescricao(), pageable)
                    .map(mapper::map);
        }

        return repository
                .findAllByArquivadoIsFalse(pageable)
                .map(mapper::map);
    }

}
