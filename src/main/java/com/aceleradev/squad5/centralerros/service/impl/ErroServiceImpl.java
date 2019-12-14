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
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void arquivar(Long id) {
        repository.findById(id).get().setArquivado(true);
    }

    @Override
    public void save(Erro erro) {
        repository.save(erro);
    }

    @Override
    public List<ErroDto> findAll(ErroFiltroDto erroFiltroDto) {

        String filtro = erroFiltroDto.filtra();
        AmbienteEnum ambienteEnum = AmbienteEnum.buscarAmbientePorLabel(erroFiltroDto.getAmbiente());

        if (filtro.equals(ErroFiltroDto.FILTRO_DUPLO)){
            return mapper.map(repository.findByDescricaoContainingAndAmbiente(erroFiltroDto.getDescricao(), ambienteEnum));
        }

        if (filtro.equals(ErroFiltroDto.FILTRO_AMBIENTE)){
            return mapper.map(repository.findAllByAmbiente(ambienteEnum));
        }

        if (filtro.equals(ErroFiltroDto.FILTRO_DESCRICAO)){
            return mapper.map(repository.findByDescricaoContaining(erroFiltroDto.getDescricao()));
        }

        return mapper.map(repository.findAll());

    }

    @Override
    public List<Erro> findAllByAmbiente(AmbienteEnum ambienteEnum) {
        return repository.findAllByAmbiente(ambienteEnum);
    }

    @Override
    public List<Erro> findByDescricao(String descricao) {
        return repository.findByDescricaoContaining(descricao);
    }

    @Override
    public List<Erro> findByDescricaoContainingAndAmbiente(String descricao, AmbienteEnum ambiente) {
        return repository.findByDescricaoContainingAndAmbiente(descricao, ambiente);
    }

}
