/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PIntegrador.etapa2.controller;

import com.PIntegrador.etapa2.model.Aluno;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pcs
 */
@Controller
public class AlunoController {

    private List<Aluno> alunos = new ArrayList();

    @GetMapping("/cadastroAluno")
    public String exibirAluno(Model model) {

        model.addAttribute("dados", new Aluno());
        return "cadastroAluno";
    }

    @PostMapping("/cadastroAluno")
    public String cadastrarAluno(@ModelAttribute Aluno cadastro, Model model) {

        alunos.add(new Aluno(cadastro.getId(), cadastro.getNome(), cadastro.getCpf(), cadastro.getEmail(),
                cadastro.getTelefone(), cadastro.getEndereço(), cadastro.getNascimento(), cadastro.getSenha()));
        model.addAttribute("dados", cadastro);

        return "consultaDadosAluno";
    }

    @GetMapping("/listaAlunos")
    public String listarAlunos(Model model, Aluno cadastro) {

        model.addAttribute("dado", alunos);
        return "listaAlunos";
    }

    @GetMapping("/consultaDadosAluno")
    public String exibirConsultaAluno(Model model) {

        model.addAttribute("dados", new Aluno());
        return "consultaDadosAluno";
    }


        /*@GetMapping("/usuario")
        public String getUserById(@RequestParam Long id, Model model) {
            Aluno user = alunos.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
            model.addAttribute("usuario", user);
            return "usuario";
        }*/
    

}
