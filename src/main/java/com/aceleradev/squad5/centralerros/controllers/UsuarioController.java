package com.aceleradev.squad5.centralerros.controllers;

import com.aceleradev.squad5.centralerros.entity.Usuario;
import com.aceleradev.squad5.centralerros.service.interfaces.UsuarioServiceInterface;
import io.swagger.annotations.Api;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Random;

@RestController
@Api(tags = "Usuario", description = "Endpoints para gerenciamento de usuários")
@RequestMapping("/usuario")
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
    public ResponseEntity<Void> cadastro(@Valid @RequestHeader String email,
                                         @Valid @RequestHeader String senha,
                                         @Valid @RequestHeader String nome){

        Usuario usuario = new Usuario();

        usuario.setEmail(email);
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setToken(RandomString.hashOf(20));

        usuarioServiceInterface.save(usuario);

        return ResponseEntity.ok().build();
    }

}
