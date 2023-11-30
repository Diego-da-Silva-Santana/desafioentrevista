package com.projetoentrevista.services;

import com.projetoentrevista.dto.DadosListagemPaisDTO;
import com.projetoentrevista.dto.PaisDTO;
import com.projetoentrevista.entities.Pais;
import com.projetoentrevista.exceptions.ResourceNotFoundException;
import com.projetoentrevista.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaisService {
    @Autowired
    private PaisRepository repository;

    public PaisDTO listarPais(String codigoInternacinalIso) {
        Optional<Pais> optionalPais = repository.findByCodigoInternacionalIso(codigoInternacinalIso.toUpperCase());

        return optionalPais.orElseThrow(() -> new ResourceNotFoundException(codigoInternacinalIso)).toPaisDTO();
    }

    public List<DadosListagemPaisDTO> listagemPaises() {
        List<Pais> pais = repository.findAll();

        return pais.stream().map(Pais::toDadosListagemPaisDTO).collect(Collectors.toList());
    }

    public PaisDTO adicionarPais(Pais pais) {
        Pais paisSalvo = repository.save(pais);
        PaisDTO paisDTO = new PaisDTO(paisSalvo);

        return paisDTO;
    }

    public void deletarpais(Long id) {
        try {
            repository.findById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}