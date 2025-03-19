/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PIntegrador.etapa2.controller;

import com.PIntegrador.etapa2.repository.AlunoEntity;
import com.PIntegrador.etapa2.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Pcs
 */

@Controller
public class AlunoController {
    
    @Autowired
    AlunoService alunoService;


    @GetMapping("/cadastroAluno")
    public String criarAlunoForm(Model model) {
        AlunoEntity escola = new AlunoEntity();
        model.addAttribute("aluno", escola);
        return "cadastroAluno";
    }
    
    
    @GetMapping("/tabela")
    public String viewHomePage(Model model) {
        model.addAttribute("listagemAlunos", alunoService.listarAlunos());
        return "listaAlunos";
    }
    

    @PostMapping("/salvarAluno")
    public String salvarAluno(@Valid @ModelAttribute("aluno") AlunoEntity escola, BindingResult result) {
        if (result.hasErrors()) {
            return "cadastroAluno";
        }

        if (escola.getId() == null) {
            alunoService.criarAluno(escola);
        } else {

            alunoService.atualizarAluno(escola.getId(), escola);
        }
        return "redirect:/tabela";
    }
    

    @GetMapping("/atualizarAlunoForm/{id}")
    public String atualizarAlunoForm(@PathVariable(value = "id") Integer id, Model model) {
        AlunoEntity escola = alunoService.getAlunoId(id);
        model.addAttribute("aluno", escola);
        return "atualizar";
    }
    
    
    @GetMapping("/deletarAluno/{id}")
    public String deletarAluno(@PathVariable(value = "id") Integer id) {
        alunoService.deletarAluno(id);
        return "redirect:/tabela";
    }
    
    
    
}
