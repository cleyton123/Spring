package com.projeto.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "projeto")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Column(name ="nome", nullable = false)
    private String nome;
}