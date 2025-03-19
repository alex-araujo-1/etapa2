/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PIntegrador.etapa2.service;

import com.PIntegrador.etapa2.repository.AlunoEntity;
import com.PIntegrador.etapa2.repository.AlunoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pcs
 */

@Service
public class AlunoService {
    
    @Autowired
    AlunoRepository alunoRepository;

    public AlunoEntity criarAluno(AlunoEntity escola) {

        escola.setId(null);

        alunoRepository.save(escola);

        return escola;
    }

    public AlunoEntity atualizarAluno(Integer escolaId, AlunoEntity alunoRequest) {

        AlunoEntity escola = getAlunoId(escolaId);

        escola.setNome(alunoRequest.getNome());

        escola.setCpf(alunoRequest.getCpf());

        escola.setEmail(alunoRequest.getEmail());

        escola.setTelefone(alunoRequest.getTelefone());
        
        escola.setEndereco(alunoRequest.getEndereco());

        escola.setNascimento(alunoRequest.getNascimento());

        escola.setSenha(alunoRequest.getSenha());

        alunoRepository.save(escola);

        return escola;
    }

    public AlunoEntity getAlunoId(Integer escolaId) {

        return alunoRepository.findById(escolaId).orElse(null);
    }

    public List<AlunoEntity> listarAlunos() {

        return alunoRepository.findAll();
    }

    public void deletarAluno(Integer escolaId) {

        AlunoEntity escola = getAlunoId(escolaId);

        alunoRepository.deleteById(escola.getId());

    }
    
}
