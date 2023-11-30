package com.projetoentrevista.dto;

import jakarta.validation.constraints.NotBlank;

public class DadosListagemPaisDTO {
    @NotBlank
    private String nome;
    @NotBlank
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
