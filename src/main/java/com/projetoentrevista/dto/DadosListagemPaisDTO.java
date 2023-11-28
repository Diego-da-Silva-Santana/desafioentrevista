package com.projetoentrevista.dto;

import com.projetoentrevista.entities.Pais;

public class DadosListagemPaisDTO {

    private String nome;
    private String codigoInternacionalIso;

    public DadosListagemPaisDTO() {
    }
    public DadosListagemPaisDTO(Pais pais) {
        nome = pais.getNome();
        codigoInternacionalIso = pais.getCodigoInternacionalIso();
    }
    public DadosListagemPaisDTO(String nome, String codigoInternacionalIso) {
        this.nome = nome;
        this.codigoInternacionalIso = codigoInternacionalIso;
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
}
