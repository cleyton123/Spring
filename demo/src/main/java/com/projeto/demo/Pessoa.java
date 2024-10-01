package com.projeto.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private String nome;
}