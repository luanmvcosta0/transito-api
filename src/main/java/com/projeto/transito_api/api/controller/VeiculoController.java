package com.projeto.transito_api.api.controller;

import com.projeto.transito_api.entities.Veiculo;
import com.projeto.transito_api.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    //@Autowired  Aqui eu so não uso o Autowired porque estou usando o @AllArgsConstructor do lombok.
    private final VeiculoRepository veiculoRepository;

    @GetMapping("")
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

}