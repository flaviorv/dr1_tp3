package com.dr1.tp3.controller;

import com.dr1.tp3.model.domain.Curso;
import com.dr1.tp3.model.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    private final Map<String, String> mensagem = new HashMap<>();

    @PostMapping
    Object cadastrar(@RequestBody Curso curso) {
        try {
            cursoService.cadastrar(curso);
            mensagem.put("info", "Curso cadastrado com sucesso!");
        }catch (Exception e) {
            mensagem.put("info", e.getMessage());
        }
        System.out.println(mensagem);
        return mensagem;
    }

    @GetMapping
    List<Curso> listar() {
        return cursoService.listar();
    }

    @GetMapping("/{id}")
    Object buscarPorId(@PathVariable Integer id) {
        try {
            return cursoService.buscarPorId(id);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            mensagem.put("info", e.getMessage());
            return mensagem;
        }
    }

    @PutMapping("/{id}")
    Object alterar(@RequestBody Curso curso, @PathVariable Integer id) {
        try {
            cursoService.alterar(id, curso);
            mensagem.put("info", "Alterado com sucesso!");
        }catch (Exception e) {
            mensagem.put("info", e.getMessage());
        }
        System.out.println(mensagem);
        return mensagem;
    }

    @DeleteMapping("/{id}")
    Object excluir(@PathVariable Integer id) {
        try {
            cursoService.excluir(id);
            mensagem.put("info", "Excluido com sucesso!");
        }catch (Exception e) {
            mensagem.put("info", e.getMessage());
        }
        System.out.println(mensagem);
        return mensagem;
    }
}
