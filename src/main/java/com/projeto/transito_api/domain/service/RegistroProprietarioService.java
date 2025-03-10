package com.projeto.transito_api.domain.service;

import com.projeto.transito_api.domain.repository.ProprietarioRepository;
import com.projeto.transito_api.domain.entities.Proprietario;
import com.projeto.transito_api.domain.exception.NegocioExeption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public Proprietario buscar(Long proprietarioId) {
       return proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new NegocioExeption("Proprietario não encontrado"));
    }

    @Transactional
    public Proprietario salvar(Proprietario proprietario) {
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();

        if (emailEmUso) {
            throw new NegocioExeption("Já existe um proprietário cadastrado com esse email.");
        }

        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(Long proprietarioId) {
        proprietarioRepository.deleteById(proprietarioId);
    }

}
