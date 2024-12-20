package com.projeto.transito_api.api.controller;

import com.projeto.transito_api.entities.Proprietario;
import com.projeto.transito_api.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class ProprietarioController {


    //@Autowired                                                // --> É boa pratica utilizar contrutor para instanciar (
    //private ProprietarioRepository proprietarioRepository;    // --> É boa pratica utilizar contrutor para instanciar


    private final ProprietarioRepository proprietarioRepository;

    @GetMapping("/proprietarios")
    public List<Proprietario> listar() {
        return proprietarioRepository.findAll();
    }

    @GetMapping("/proprietariosNomeCompleto")
    public List<Proprietario> listarPorNome() {
        return proprietarioRepository.findByNome("Luan Costa");
    }

    @GetMapping("/proprietariosLetra")
    public List<Proprietario> listarPorLetra() {
        return proprietarioRepository.findByNomeContaining("Bu");
    }

    @GetMapping(value = "/proprietarios/{proprietarioId}")
    public ResponseEntity<Proprietario> buscar(@PathVariable Long proprietarioId) {
        Optional<Proprietario> proprietario = proprietarioRepository.findById(proprietarioId);

        if (proprietario.isPresent()) {
            return ResponseEntity.ok(proprietario.get());
        }

        return ResponseEntity.notFound().build();
    }

}
