package com.projetoentrevista.entities;

import com.projetoentrevista.dto.DadosListagemPaisDTO;
import com.projetoentrevista.dto.PaisDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String codigoInternacionalIso;
    private String continente;
    private Double populacao;
    private LocalDateTime dataCriacao;

    public Pais() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoInternacionalIso() {
        return codigoInternacionalIso;
    }

    public String getContinente() {
        return continente;
    }

    public Double getPopulacao() {
        return populacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public PaisDTO toPaisDTO() {
        return new PaisDTO(id, nome, codigoInternacionalIso, continente, populacao, dataCriacao);
    }

    public DadosListagemPaisDTO toDadosListagemPaisDTO() {
        return new DadosListagemPaisDTO(nome, codigoInternacionalIso);
    }

}
