package com.dr1.tp3.model.service;

import com.dr1.tp3.model.domain.Aluno;
import com.dr1.tp3.model.domain.Curso;
import com.dr1.tp3.model.repository.AlunoRepository;
import com.dr1.tp3.model.repository.CursoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoRespository cursoRespository;

    public void cadastrar(Aluno aluno){
        alunoRepository.save(aluno);
    }

    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    public Aluno buscarPorMatricula(Integer matricula) throws Exception{
        Optional<Aluno> aluno = alunoRepository.findById(matricula);
        if(aluno.isPresent()){
            return aluno.get();
        }else {
            throw new Exception("Aluno não encontrado.");
        }
    }

    public void alterar(Integer matricula, Aluno alunoAlterado) throws Exception{
        Optional<Aluno> aluno = alunoRepository.findById(matricula);
        if(aluno.isPresent()){
            aluno.get().setMatricula(matricula);
            aluno.get().setNome(alunoAlterado.getNome());
            alunoRepository.save(aluno.get());
        }else {
            throw new Exception("Aluno não encontrado.");
        }
    }

    public void excluir(Integer matricula) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(matricula);
        if(aluno.isPresent()){
            alunoRepository.deleteById(matricula);
        }else{
            throw new Exception("Aluno não encontrado.");
        }
    }

    public void seInscrever(Integer matricula, Integer idCurso) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(matricula);
        Optional<Curso> curso = cursoRespository.findById(idCurso);
        if(aluno.isPresent() && curso.isPresent()){
            aluno.get().seInscrever(curso.get());
            alunoRepository.save(aluno.get());
        }else if(aluno.isEmpty()){
            throw new Exception("Aluno não encontrado.");
        }else {
            throw new Exception("Curso não encontrado.");
        }
    }
}
