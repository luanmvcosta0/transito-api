package com.projeto.transito_api.api.controller;

import com.projeto.transito_api.entities.Proprietario;
import com.projeto.transito_api.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {


    //@Autowired                                                // --> É boa pratica utilizar contrutor para instanciar
    //private ProprietarioRepository proprietarioRepository;    // --> É boa pratica utilizar contrutor para instanciar


    private final ProprietarioRepository proprietarioRepository;

    @GetMapping("")
    public List<Proprietario> listar() {
        return proprietarioRepository.findAll();
    }

    @GetMapping(value = "/{proprietarioId}")
    public ResponseEntity<Proprietario> buscar(@PathVariable Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario adicionar(@RequestBody Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

}