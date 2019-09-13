package com.exercicio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @RequestMapping("/obterNomePessoa")
    public String getNomePessoa(@RequestParam(name = "id") int id) {
        Pessoa resultado = Pessoa.obterPessoas()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();
        return resultado.getNome();
    }

}