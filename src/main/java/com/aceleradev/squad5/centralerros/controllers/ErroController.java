package com.aceleradev.squad5.centralerros.controllers;

import com.aceleradev.squad5.centralerros.dto.ErroDto;
import com.aceleradev.squad5.centralerros.entity.Erro;
import com.aceleradev.squad5.centralerros.mappers.impl.ErroMapperImpl;
import com.aceleradev.squad5.centralerros.service.interfaces.ErroServiceInterface;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Logs de erro", description = "Endpoints para gerenciamento dos logs de erros")
@RequestMapping("/erro")
public class ErroController {

    private final ErroServiceInterface erroServiceInterface;

    private final ErroMapperImpl mapper;

    @Autowired
    public ErroController(ErroServiceInterface erroServiceInterface, ErroMapperImpl erroMapper) {
        this.erroServiceInterface = erroServiceInterface;
        this.mapper = erroMapper;
    }

    @GetMapping
    public ResponseEntity<List<ErroDto>> buscarErros(){
        return ResponseEntity.ok(mapper.errosToErrosDto(erroServiceInterface.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Erro> buscarErro(@PathVariable Long id){
        return ResponseEntity.ok(erroServiceInterface.findById(id));
    }

    @PostMapping("/arquivar/{id}")
    public ResponseEntity<Void> arquivarErro(@PathVariable Long id){

        Erro erro = erroServiceInterface.findById(id);
        erro.setArquivado(true);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarErro(@PathVariable Long id){

        erroServiceInterface.delete(id);
        return ResponseEntity.ok().build();

    }



}
