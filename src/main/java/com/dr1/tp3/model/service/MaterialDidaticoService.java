package com.dr1.tp3.model.service;

import com.dr1.tp3.model.domain.MaterialDidatico;
import com.dr1.tp3.model.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialDidaticoService {
    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    public void adicionar(MaterialDidatico materialDidatico){
        materialDidaticoRepository.save(materialDidatico);
    }

    public List<MaterialDidatico> listar(){
        return materialDidaticoRepository.findAll();
    }

    public MaterialDidatico buscarPorId(String id) throws Exception{
        Optional<MaterialDidatico> material = materialDidaticoRepository.findById(id);
        if(material.isPresent()){
            return material.get();
        }else {
            throw new Exception("Material não encontrado.");
        }
    }

    public void alterar(String id, MaterialDidatico materialDidatico) throws Exception{
        Optional<MaterialDidatico> material = materialDidaticoRepository.findById(id);
        if(material.isPresent()){
            material.get().setId(id);
            material.get().setDescricao(materialDidatico.getDescricao());
            materialDidaticoRepository.save(material.get());
        }else {
            throw new Exception("Material não encontrado.");
        }
    }

    public void excluir(String id) throws Exception {
        MaterialDidatico material = buscarPorId(id);
        materialDidaticoRepository.deleteById(material.getId());
    }
}
