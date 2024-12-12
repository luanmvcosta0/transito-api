package com.projeto.transito_api.api.controller;

import com.projeto.transito_api.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping("/proprietarios")
    public List<Proprietario> listar() {
        Proprietario proprietario1 = new Proprietario();
        proprietario1.setId(1L);
        proprietario1.setNome("Luan");
        proprietario1.setEmail("luancosta@email.com");
        proprietario1.setTelefone("(81) 99988-7766");

        Proprietario proprietario2 = new Proprietario();
        proprietario2.setId(2L);
        proprietario2.setNome("Leticia");
        proprietario2.setEmail("leticiabuled@email.com");
        proprietario2.setTelefone("(81) 98765-4432");

        return Arrays.asList(proprietario1, proprietario2);

    }

}
