package com.projeto.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.demo.Pessoa;
import com.projeto.demo.PessoaRepositorio;
import com.projeto.demo.PessoaDTO;
@RestController
@RequestMapping("/pessoa")
public class Controlador {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setIdade(pessoaDTO.getIdade());
        pessoaRepositorio.save(pessoa);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepositorio.findById(id).orElse(null);
        if (pessoa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoa);
    }
}
