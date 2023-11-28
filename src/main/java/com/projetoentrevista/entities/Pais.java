package com.projetoentrevista.entities;

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
    private  Double populacao;
    private LocalDateTime dataCriacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pais() {
    }

    public Pais(String nome, String codigoInternacionalIso, String continente, Double populacao, LocalDateTime dataCriacao) {
        this.nome = nome;
        this.codigoInternacionalIso = codigoInternacionalIso;
        this.continente = continente;
        this.populacao = populacao;
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoInternacionalIso() {
        return codigoInternacionalIso;
    }

    public void setCodigoInternacionalIso(String codigoInternacionalIso) {
        this.codigoInternacionalIso = codigoInternacionalIso;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public Double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Double populacao) {
        this.populacao = populacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
