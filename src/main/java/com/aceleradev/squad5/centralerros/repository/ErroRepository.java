package com.aceleradev.squad5.centralerros.repository;

import com.aceleradev.squad5.centralerros.entity.Erro;
import com.aceleradev.squad5.centralerros.enums.AmbienteEnum;
import com.aceleradev.squad5.centralerros.enums.LevelEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.SecureRandom;
import java.util.List;

@Repository
public interface ErroRepository extends JpaRepository<Erro, Long> {

    List<Erro> findAllByArquivadoIsFalse();

    List<Erro> findAllByAmbiente(AmbienteEnum ambienteEnum);

    List<Erro> findByDescricaoContaining(String descricao);

    List<Erro> findByDescricaoContainingAndAmbiente(String descricao, AmbienteEnum ambiente);

}
