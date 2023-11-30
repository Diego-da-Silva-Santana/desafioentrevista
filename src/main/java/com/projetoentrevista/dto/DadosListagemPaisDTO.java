package com.projetoentrevista.dto;

public class DadosListagemPaisDTO {

    private String nome;

    private String codigoInternacionalIso;

    public DadosListagemPaisDTO() {
    }

    public DadosListagemPaisDTO(String nome, String codigoInternacionalIso) {
        this.nome = nome;
        this.codigoInternacionalIso = codigoInternacionalIso;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoInternacionalIso() {
        return codigoInternacionalIso;
    }

}
