/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PIntegrador.etapa2.repository;

/**
 *
 * @author Pcs
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Pcs
 */

@Data

@Entity

@Table(name = "Aluno")

public class AlunoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @NotBlank(message = "Nome é Obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @NotNull(message = "")
    private int telefone;
    
    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;
    
    @NotNull()
    private int nascimento;
    
    @NotNull(message = "")
    private int senha;
    
}
