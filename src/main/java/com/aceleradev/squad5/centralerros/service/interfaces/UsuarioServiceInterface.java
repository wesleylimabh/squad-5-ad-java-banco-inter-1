package com.aceleradev.squad5.centralerros.service.interfaces;

import com.aceleradev.squad5.centralerros.dto.UsuarioDto;
import com.aceleradev.squad5.centralerros.entity.Usuario;

public interface UsuarioServiceInterface{

    UsuarioDto save(UsuarioDto usuarioDto);

    Usuario findByEmail(String email);

}
