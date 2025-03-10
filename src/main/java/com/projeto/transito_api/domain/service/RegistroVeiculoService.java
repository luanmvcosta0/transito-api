package com.projeto.transito_api.domain.service;

import com.projeto.transito_api.domain.repository.VeiculoRepository;
import com.projeto.transito_api.domain.entities.Proprietario;
import com.projeto.transito_api.domain.entities.StatusVeiculo;
import com.projeto.transito_api.domain.entities.Veiculo;
import com.projeto.transito_api.domain.exception.NegocioExeption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final RegistroProprietarioService registroProprietarioService;

    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo) {
        if (novoVeiculo.getId() != null) {
            throw new NegocioExeption("Veículo a ser cadastrado não deve possuir um id.");
        }

        boolean placaEmUso = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                .filter(veiculo -> !veiculo.equals(novoVeiculo))
                .isPresent();

        if (placaEmUso) {
            throw new NegocioExeption("Já existe um veiculo cadastrado com esta placa.");
        }


        Proprietario proprietario = registroProprietarioService.buscar(novoVeiculo.getProprietario().getId());


        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus(StatusVeiculo.REGULAR);
        novoVeiculo.setDataCadastro(LocalDateTime.now());


        return veiculoRepository.save(novoVeiculo);
    }


}
