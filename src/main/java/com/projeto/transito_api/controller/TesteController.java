package com.projeto.transito_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TesteController {

    @GetMapping("/teste")
    public String testando() {
        return "Testando 123";
    }

}
