package com.projeto.transito_api.repository;

import com.projeto.transito_api.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    //List<Veiculo> findById(String nome);

}
