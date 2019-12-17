package com.aceleradev.squad5.centralerros.service.impl;

import com.aceleradev.squad5.centralerros.dto.UsuarioDto;
import com.aceleradev.squad5.centralerros.entity.Usuario;
import com.aceleradev.squad5.centralerros.exceptions.ResourceNotFoundException;
import com.aceleradev.squad5.centralerros.repository.UsuarioRepository;
import com.aceleradev.squad5.centralerros.service.interfaces.UsuarioServiceInterface;
import com.aceleradev.squad5.centralerros.utils.GeradorToken;
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
    public UsuarioDto save(Usuario usuario) {
        usuario.setToken(GeradorToken.gerarToken());
        return repository.save(usuario).toDto();
    }

    @Override
    public Usuario findByEmail(String email) {
        return repository.findUsuarioByEmail(email).orElse(new Usuario());
    }

}
