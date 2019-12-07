package com.aceleradev.squad5.centralerros.service.interfaces;

import com.aceleradev.squad5.centralerros.entity.Usuario;

public interface UsuarioServiceInterface{

    Usuario save(Usuario usuario);

    Usuario findByEmail(String email);

}
