package com.aceleradev.squad5.centralerros.repository;

import com.aceleradev.squad5.centralerros.entity.Erro;
import com.aceleradev.squad5.centralerros.enums.AmbienteEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErroRepository extends JpaRepository<Erro, Long> {

    Page<Erro> findAllByArquivadoIsFalse(Pageable pageable);

    Page<Erro> findAllByAmbienteAndArquivadoIsFalse(AmbienteEnum ambienteEnum, Pageable pageable);

    Page<Erro> findByDescricaoContainingAndArquivadoIsFalse(String descricao, Pageable pageable);

    Page<Erro> findByDescricaoContainingAndAmbienteAndArquivadoIsFalse(String descricao, AmbienteEnum ambiente, Pageable pageable);

}
