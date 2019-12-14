package com.aceleradev.squad5.centralerros.controllers;

import com.aceleradev.squad5.centralerros.dto.ErroDto;
import com.aceleradev.squad5.centralerros.dto.ErroFiltroDto;
import com.aceleradev.squad5.centralerros.entity.Erro;
import com.aceleradev.squad5.centralerros.enums.AmbienteEnum;
import com.aceleradev.squad5.centralerros.enums.LevelEnum;
import com.aceleradev.squad5.centralerros.service.interfaces.ErroServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "Logs de erro", description = "Endpoints para gerenciamento dos logs de erros")
@RequestMapping("/erro")
public class ErroController {

    private ErroServiceInterface erroServiceInterface;


    @Autowired
    public ErroController(ErroServiceInterface erroServiceInterface) {
        this.erroServiceInterface = erroServiceInterface;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page.", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query", defaultValue = "id,desc", value = "Sorting by column")
    })
    @GetMapping
    public ResponseEntity<Page<ErroDto>> buscarErros(ErroFiltroDto erroFiltroDto,
                                                     @ApiIgnore @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable){
        return ResponseEntity.ok(erroServiceInterface.findAll(erroFiltroDto, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Erro> buscarErro(@PathVariable Long id){
        return ResponseEntity.ok(erroServiceInterface.findById(id));
    }

    @PostMapping("/arquivar")
    public ResponseEntity<Void> arquivarErro(@RequestParam List<Long> ids){

        ids.forEach(id -> {
            Erro erro = erroServiceInterface.findById(id);
            erro.arquivar();
            erroServiceInterface.save(erro);
        });

        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarErro(@RequestParam List<Long> ids){

        ids.forEach(id ->  erroServiceInterface.delete(id));
        return ResponseEntity.ok().build();

    }

    @PostMapping
    public ResponseEntity<Erro> criarErro(@RequestBody Erro erro){
        return ResponseEntity.status(HttpStatus.CREATED).body(erroServiceInterface.save(erro));
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
