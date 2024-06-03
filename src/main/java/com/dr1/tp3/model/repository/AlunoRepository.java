package com.dr1.tp3.model.repository;

import com.dr1.tp3.model.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
