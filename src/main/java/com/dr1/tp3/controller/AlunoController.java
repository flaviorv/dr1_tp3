package com.dr1.tp3.controller;

import com.dr1.tp3.model.domain.Aluno;
import com.dr1.tp3.model.domain.Curso;
import com.dr1.tp3.model.service.AlunoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    private final HashMap<String, String> mensagem = new HashMap<>();

    @PostMapping
    Object cadastrar(@RequestBody Aluno aluno) {
        try {
            alunoService.cadastrar(aluno);
            mensagem.put("mensagem", "Aluno cadastrado com sucesso!");
        }catch (Exception e) {
            mensagem.put("erro", e.getMessage());
        }
        System.out.println(mensagem);
        return mensagem;
    }

    @GetMapping
    List<Aluno> listar() {
        return alunoService.listar();
    }

    @GetMapping("/{matricula}")
    Object buscarPorMatricula(@PathVariable Integer matricula) {
        try {
            return alunoService.buscarPorMatricula(matricula);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            mensagem.put("erro", e.getMessage());
            return mensagem;
        }

    }

    @PutMapping("/{matricula}")
    Object alterar(@RequestBody Aluno aluno, @PathVariable Integer matricula) throws Exception{
        try {
            alunoService.alterar(matricula, aluno);
            mensagem.put("mensagem", "Alterado com sucesso!");
        }catch (Exception e) {
            mensagem.put("erro", e.getMessage());
        }
        System.out.println(mensagem);
        return mensagem;
    }

    @DeleteMapping("/{matricula}")
    Object excluir(@PathVariable Integer matricula) {
        try {
            alunoService.excluir(matricula);
            mensagem.put("mensagem", "Excluido com sucesso!");
        }catch (Exception e) {
            mensagem.put("erro", e.getMessage());
        }
        System.out.println(mensagem);
        return mensagem;
    }

    @PostMapping("/{matricula}")
    Object seInscrever(@PathVariable Integer matricula, @RequestParam("curso") Integer cursoId) {
        try {
            alunoService.seInscrever(matricula, cursoId);
            mensagem.put("mensagem", "Inscrição realizada com sucesso!");
        }catch (Exception e) {
            mensagem.put("erro", e.getMessage());
        }
        System.out.println(mensagem);
        return mensagem;
    }

}
