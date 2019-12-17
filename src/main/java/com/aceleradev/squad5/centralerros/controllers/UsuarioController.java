package com.aceleradev.squad5.centralerros.controllers;

import com.aceleradev.squad5.centralerros.dto.UsuarioDto;
import com.aceleradev.squad5.centralerros.entity.Usuario;
import com.aceleradev.squad5.centralerros.service.interfaces.UsuarioServiceInterface;
import com.aceleradev.squad5.centralerros.utils.GeradorToken;
import io.swagger.annotations.Api;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "Usuario", description = "Endpoints para gerenciamento de usuários")
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServiceInterface usuarioServiceInterface;

    @Autowired
    public UsuarioController(UsuarioServiceInterface usuarioServiceInterface) {
        this.usuarioServiceInterface = usuarioServiceInterface;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestHeader String email,
                                      @Valid @RequestHeader String senha){

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioDto> cadastro(@RequestBody Usuario usuario){
        Usuario usuarioDB = usuarioServiceInterface.findByEmail(usuario.getEmail());
        if(usuarioDB.getEmail() != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServiceInterface.save(usuario));
    }

}
