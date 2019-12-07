package com.aceleradev.squad5.centralerros.repository;

import com.aceleradev.squad5.centralerros.entity.Erro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErroRepository extends JpaRepository<Erro, Long> {

}
