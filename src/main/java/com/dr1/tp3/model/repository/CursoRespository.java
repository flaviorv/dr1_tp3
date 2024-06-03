package com.dr1.tp3.model.repository;

import com.dr1.tp3.model.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRespository extends JpaRepository<Curso, Integer> {
}
