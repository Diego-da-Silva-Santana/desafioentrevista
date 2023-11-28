package com.projetoentrevista.dto;

import com.projetoentrevista.entities.Pais;

import java.time.LocalDateTime;

public class PaisDTO {

    private Long id;
    private String nome;
    private String codigoInternacionalIso;
    private String continente;
    private Double populacao;
    private LocalDateTime dataCriacao;

    public PaisDTO() {
    }

//    public PaisDTO(Pais pais) {
//        id = pais.getId();
//        nome = pais.getNome();
//        codigoInternacionalIso = pais.getCodigoInternacionalIso();
//        continente = pais.getContinente();
//        populacao = pais.getPopulacao();
//        dataCriacao = pais.getDataCriacao();
//
//    }

    public PaisDTO(Long id, String nome, String codigoInternacionalIso, String continente, Double populacao, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.codigoInternacionalIso = codigoInternacionalIso;
        this.continente = continente;
        this.populacao = populacao;
        this.dataCriacao = dataCriacao;
    }

    public PaisDTO(String nome, String codigoInternacionalIso, String continente, Double populacao, LocalDateTime dataCriacao) {
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

    public DadosListagemPaisDTO toDadosListagemPaisDTO(){
        return new DadosListagemPaisDTO(nome,codigoInternacionalIso);
    }
}
