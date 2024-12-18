package com.projeto.transito_api.repository;

import com.projeto.transito_api.entities.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

    List<Proprietario> findByNome(String nome);
    List<Proprietario> findByNomeContaining(String nome);   //O que passar aqui vai puxar por alguma parte do nome, por conta deste 'Containing'

}
