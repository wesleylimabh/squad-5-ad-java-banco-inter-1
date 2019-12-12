package com.aceleradev.squad5.centralerros.controllers;

import com.aceleradev.squad5.centralerros.dto.ErroDto;
import com.aceleradev.squad5.centralerros.entity.Erro;
import com.aceleradev.squad5.centralerros.enums.AmbienteEnum;
import com.aceleradev.squad5.centralerros.enums.LevelEnum;
import com.aceleradev.squad5.centralerros.mapper.ErroMapper;
import com.aceleradev.squad5.centralerros.service.interfaces.ErroServiceInterface;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@Api(tags = "Logs de erro", description = "Endpoints para gerenciamento dos logs de erros")
@RequestMapping("/erro")
public class ErroController {

    private ErroServiceInterface erroServiceInterface;

    private ErroMapper mapper;

    @Autowired
    public ErroController(ErroServiceInterface erroServiceInterface, ErroMapper mapper) {
        this.erroServiceInterface = erroServiceInterface;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ErroDto>> buscarErros(@RequestParam(name = "Level", required = false) LevelEnum level,
                                                     @RequestParam(name = "Ambiente", required = false) AmbienteEnum ambiente){

        if (Objects.nonNull(level)) return ResponseEntity.ok(mapper.map(erroServiceInterface.findAllByLevel(level)));
        if (Objects.nonNull(ambiente)) return ResponseEntity.ok(mapper.map(erroServiceInterface.findAllByAmbiente(ambiente)));
        return ResponseEntity.ok(mapper.map(erroServiceInterface.findAll()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Erro> buscarErro(@PathVariable Long id){
        return ResponseEntity.ok(erroServiceInterface.findById(id));
    }

    @PostMapping("/arquivar/{id}")
    public ResponseEntity<Void> arquivarErro(@PathVariable Long id){
        Erro erro = erroServiceInterface.findById(id);
        erro.setArquivado(true);
        erroServiceInterface.save(erro);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarErro(@PathVariable Long id){
        erroServiceInterface.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<String> criarErro(@RequestBody Erro erro){

        erroServiceInterface.save((Erro) erro);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/ambientes")
    public ResponseEntity<List<String>> buscarAmbientes(){

        List<String> ambientes = new ArrayList<>();

        ambientes.add(AmbienteEnum.DESENVOLVIMENTO.label);
        ambientes.add(AmbienteEnum.PRODUCAO.label);
        ambientes.add(AmbienteEnum.HOMOLOGACAO.label);

        return ResponseEntity.ok(ambientes);
    }

    @GetMapping("/levels")
    public ResponseEntity<List<String>> buscarLevels(){

        List<String> levels = new ArrayList<>();

        levels.add(LevelEnum.DEBUG.label);
        levels.add(LevelEnum.ERROR.label);
        levels.add(LevelEnum.WARNING.label);

        return ResponseEntity.ok(levels);
    }


}
