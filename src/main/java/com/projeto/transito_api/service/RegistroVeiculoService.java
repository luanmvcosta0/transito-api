package com.projeto.transito_api.service;

import com.projeto.transito_api.entities.Proprietario;
import com.projeto.transito_api.entities.StatusVeiculo;
import com.projeto.transito_api.entities.Veiculo;
import com.projeto.transito_api.exception.NegocioExeption;
import com.projeto.transito_api.repository.ProprietarioRepository;
import com.projeto.transito_api.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ProprietarioRepository proprietarioRepository;

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

        Proprietario proprietario = proprietarioRepository.findById(novoVeiculo.getProprietario().getId())
                        .orElseThrow(() -> new NegocioExeption("Proprietario não encontrado"));

        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus(StatusVeiculo.REGULAR);
        novoVeiculo.setDataCadastro(LocalDateTime.now());


        return veiculoRepository.save(novoVeiculo);
    }


}
