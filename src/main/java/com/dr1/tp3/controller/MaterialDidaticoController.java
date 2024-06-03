package com.dr1.tp3.controller;

import com.dr1.tp3.model.domain.Curso;
import com.dr1.tp3.model.domain.MaterialDidatico;
import com.dr1.tp3.model.service.MaterialDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/material")
public class MaterialDidaticoController {
    @Autowired
    private MaterialDidaticoService materialDidaticoService;

    private final Map<String, String> mensagem = new HashMap<>();

    @PostMapping
    Object cadastrar(@RequestBody MaterialDidatico material) {
        try {
            materialDidaticoService.adicionar(material);
            mensagem.put("info", "Material cadastrado com sucesso!");
        }catch (Exception e) {
            mensagem.put("info", e.getMessage());
        }
        System.out.println(mensagem);
        return mensagem;
    }

    @GetMapping
    List<MaterialDidatico> listar() {
        return materialDidaticoService.listar();
    }

    @GetMapping("/{id}")
    Object buscarPorId(@PathVariable String id) {
        try {
            return materialDidaticoService.buscarPorId(id);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            mensagem.put("info", e.getMessage());
            return mensagem;
        }
    }

    @PutMapping("/{id}")
    Object alterar(@RequestBody MaterialDidatico materialDidatico, @PathVariable String id) {
        try {
            materialDidaticoService.alterar(id, materialDidatico);
            mensagem.put("info", "Alterado com sucesso!");
        }catch (Exception e) {
            mensagem.put("info", e.getMessage());
        }
        System.out.println(mensagem);
        return mensagem;
    }

    @DeleteMapping("/{id}")
    Object excluir(@PathVariable String id) {
        try {
            materialDidaticoService.excluir(id);
            mensagem.put("info", "Excluido com sucesso!");
        }catch (Exception e) {
            mensagem.put("info", e.getMessage());
        }
        System.out.println(mensagem);
        return mensagem;
    }
}
