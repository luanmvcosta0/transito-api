package com.projeto.transito_api.domain.repository;

import com.projeto.transito_api.domain.entities.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

    List<Proprietario> findByNome(String nome);
    Optional<Proprietario> findByEmail(String email);

}
