package com.projeto.transito_api.api.controller;

import com.projeto.transito_api.entities.Proprietario;
import com.projeto.transito_api.exception.NegocioExeption;
import com.projeto.transito_api.repository.ProprietarioRepository;
import com.projeto.transito_api.service.RegistroProprietarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {


    //@Autowired                                                // --> É boa pratica utilizar contrutor para instanciar
    //private ProprietarioRepository proprietarioRepository;    // --> É boa pratica utilizar contrutor para instanciar


    private final RegistroProprietarioService registroProprietarioService;
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
    public Proprietario adicionar(@Valid @RequestBody Proprietario proprietario) {
        return registroProprietarioService.salvar(proprietario);
    }

    @PutMapping("/{proprietarioId}")
    public ResponseEntity<Proprietario> atualizar(@PathVariable Long proprietarioId, @Valid @RequestBody Proprietario proprietario) {
        if (!proprietarioRepository.existsById(proprietarioId)) {
            return ResponseEntity.notFound().build();
        }

        proprietario.setId(proprietarioId);
        Proprietario proprietarioAtualizado = registroProprietarioService.salvar(proprietario);

        return ResponseEntity.ok(proprietarioAtualizado);
    }

    @DeleteMapping("/{proprietarioId}")
    public ResponseEntity<Void> remover(@PathVariable Long proprietarioId) {
        if (!proprietarioRepository.existsById(proprietarioId)) {
            return ResponseEntity.notFound().build();
        }

        registroProprietarioService.excluir(proprietarioId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NegocioExeption.class)    // Metodo capaz de capturar exeções e dar respostas adequedas
    public ResponseEntity<String> capturar(NegocioExeption e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}