package com.dr1.tp3.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int matricula;
    private String nome;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Map<Integer, Curso> cursos = new HashMap<>();

    public void seInscrever(Curso curso) throws Exception {
        if (cursos.containsKey(curso.getId())) {
            throw new Exception("Erro ao realizar inscrição. Incrição já existe.");
        }
       cursos.put(curso.getId(), curso);
    }

    public void removerInscricao(Curso curso) throws Exception {
        if (!cursos.containsKey(curso.getId())) {
            throw new Exception("Não foi possível excluir. Inscrição inexistente.");
        }
        cursos.remove(curso.getId());
    }
}
