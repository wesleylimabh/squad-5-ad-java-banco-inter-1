package com.aceleradev.squad5.centralerros.controllers;

import com.aceleradev.squad5.centralerros.dto.LoginDto;
import com.aceleradev.squad5.centralerros.dto.UsuarioDto;
import com.aceleradev.squad5.centralerros.service.interfaces.UsuarioServiceInterface;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Void> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastro(@RequestBody UsuarioDto usuarioDto){
//        usuario.setToken(GeradorToken.gerarToken());
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServiceInterface.save(usuarioDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
