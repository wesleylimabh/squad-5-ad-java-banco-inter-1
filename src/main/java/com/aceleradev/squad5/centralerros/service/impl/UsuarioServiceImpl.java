package com.aceleradev.squad5.centralerros.service.impl;

import com.aceleradev.squad5.centralerros.entity.Usuario;
import com.aceleradev.squad5.centralerros.exceptions.ResourceNotFoundException;
import com.aceleradev.squad5.centralerros.repository.UsuarioRepository;
import com.aceleradev.squad5.centralerros.service.interfaces.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioServiceInterface {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario findByEmail(String email) {
        return repository.findUsuarioByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Email não encontrado"));
    }

}
