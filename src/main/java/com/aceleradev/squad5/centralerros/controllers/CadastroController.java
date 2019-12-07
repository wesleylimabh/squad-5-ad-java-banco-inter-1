package com.aceleradev.squad5.centralerros.controllers;

import com.aceleradev.squad5.centralerros.service.interfaces.UsuarioServiceInterface;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "Usuario", description = "Endpoints para gerenciamento de usuários")
@RequestMapping("/usuario")
public class CadastroController {

    private final UsuarioServiceInterface usuarioServiceInterface;

    @Autowired
    public CadastroController(UsuarioServiceInterface usuarioServiceInterface) {
        this.usuarioServiceInterface = usuarioServiceInterface;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestHeader String email,
                                      @Valid @RequestHeader String senha){

        return ResponseEntity.ok().build();
    }


}
