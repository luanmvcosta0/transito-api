package com.projeto.transito_api.api.controller;

import com.projeto.transito_api.entities.Veiculo;
import com.projeto.transito_api.exception.NegocioExeption;
import com.projeto.transito_api.repository.VeiculoRepository;
import com.projeto.transito_api.service.RegistroVeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    //@Autowired  Aqui eu so não uso o Autowired porque estou usando o @AllArgsConstructor do lombok.
    private final VeiculoRepository veiculoRepository;
    private final RegistroVeiculoService registroVeiculoService;


    @GetMapping("")
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    @GetMapping(value = "/{veiculoId}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return registroVeiculoService.cadastrar(veiculo);
    }

    @ExceptionHandler(NegocioExeption.class)    // Metodo capaz de capturar exeções e dar respostas adequedas
    public ResponseEntity<String> capturar(NegocioExeption e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}