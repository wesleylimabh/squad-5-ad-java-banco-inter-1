package com.aceleradev.squad5.centralerros.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ErroTest {

    @Test
    public void deveArquivarQuandoExecutarArquivarDeErro() {
        Erro erro = Erro.builder().arquivado(false).build();
        erro.arquivar();
        Assertions.assertTrue(erro.isArquivado());
    }

    @Test
    public void deveArquivarMesmoQuandoJaArquivado() {
        Erro erro = Erro.builder().arquivado(true).build();
        erro.arquivar();
        Assertions.assertTrue(erro.isArquivado());
    }

//    @Test
//    public void deveSubirExceptionQuandoArquivadoForFalseEValidarArquivo() {
//        Erro erro = Erro.builder().arquivado(false).build();
//
//        Assertions.assertThrows(RuntimeException.class, () -> erro.validaArquivado());
//    }


}