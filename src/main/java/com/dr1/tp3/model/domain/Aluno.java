package com.dr1.tp3.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private List<Curso> cursos = new ArrayList<>();

    public void seInscrever(Curso curso){
        cursos.add(curso);
    }
}
