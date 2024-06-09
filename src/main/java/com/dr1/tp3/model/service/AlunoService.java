package com.dr1.tp3.model.service;

import com.dr1.tp3.model.domain.Aluno;
import com.dr1.tp3.model.domain.Curso;
import com.dr1.tp3.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoService cursoService;

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
        Aluno aluno = buscarPorMatricula(matricula);
        alunoRepository.deleteById(aluno.getMatricula());
    }

    public void seInscrever(Integer matricula, Integer idCurso) throws Exception {
        Aluno aluno = buscarPorMatricula(matricula);
        Curso curso = cursoService.buscarPorId(idCurso);

        aluno.seInscrever(curso);
        alunoRepository.save(aluno);
    }

    public void removerInscricao(Integer matricula, Integer idCurso) throws Exception {
        Aluno aluno = buscarPorMatricula(matricula);
        Curso curso = cursoService.buscarPorId(idCurso);
        System.out.println(aluno +""+ curso);

        aluno.removerInscricao(curso);
        alunoRepository.save(aluno);
    }

    public Map<Integer, Curso> cursosInscritos(Integer matricula) throws Exception {
        Aluno aluno = buscarPorMatricula(matricula);
        return aluno.getCursos();
    }


}
