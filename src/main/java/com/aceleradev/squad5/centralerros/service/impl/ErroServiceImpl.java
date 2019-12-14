package com.aceleradev.squad5.centralerros.service.impl;

import com.aceleradev.squad5.centralerros.entity.Erro;
import com.aceleradev.squad5.centralerros.exceptions.ResourceNotFoundException;
import com.aceleradev.squad5.centralerros.repository.ErroRepository;
import com.aceleradev.squad5.centralerros.service.interfaces.ErroServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErroServiceImpl implements ErroServiceInterface {

    private final ErroRepository repository;

    @Autowired
    public ErroServiceImpl(ErroRepository repository) {
        this.repository = repository;
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
    public List<Erro> findAll() {
        return repository.findAllByArquivadoIsFalse();
    }
}
