package com.projeto.transito_api.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    private String marca;
    private String modelo;
    private String placa;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataApreensao;

}
