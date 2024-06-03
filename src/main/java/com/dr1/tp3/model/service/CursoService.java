package com.dr1.tp3.model.service;

import com.dr1.tp3.model.domain.Aluno;
import com.dr1.tp3.model.domain.Curso;
import com.dr1.tp3.model.repository.CursoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRespository cursoRepository;

    public void cadastrar(Curso curso){
        cursoRepository.save(curso);
    }

    public List<Curso> listar(){
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Integer id) throws Exception{
        Optional<Curso> curso = cursoRepository.findById(id);
        if(curso.isPresent()){
            return curso.get();
        }else {
            throw new Exception("Curso não encontrado.");
        }
    }

    public void alterar(Integer id, Curso cursoAlterado) throws Exception{
        Optional<Curso> curso = cursoRepository.findById(id);
        if(curso.isPresent()){
            curso.get().setId(id);
            curso.get().setNome(cursoAlterado.getNome());
            cursoRepository.save(curso.get());
        }else {
            throw new Exception("Curso não encontrado.");
        }
    }

    public void excluir(Integer id) throws Exception {
        Optional<Curso> curso = cursoRepository.findById(id);
        if(curso.isPresent()){
            cursoRepository.deleteById(id);
        }else{
            throw new Exception("Curso não encontrado.");
        }
    }
}
