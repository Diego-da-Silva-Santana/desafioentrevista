package com.projetoentrevista.entities;

import com.projetoentrevista.dto.DadosListagemPaisDTO;
import com.projetoentrevista.dto.PaisDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pais")
public class Pais {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome obrigatório")
    private String nome;
    @NotBlank(message = "Código internacional iso obrigátorio")
    private String codigoInternacionalIso;
    @NotBlank(message = "Continente obrigatório")
    private String continente;
    @NotNull(message = "População obrigatório")
    @Min(value = 10001, message = "A população deve ser maior ou igual a 10001")
    private Double populacao;
    @NotNull(message = " Data de criação obrigatório")
    @CreationTimestamp
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
