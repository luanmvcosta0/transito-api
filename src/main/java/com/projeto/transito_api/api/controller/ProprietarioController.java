package com.projeto.transito_api.api.controller;

import com.projeto.transito_api.entities.Proprietario;
import com.projeto.transito_api.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

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


}
