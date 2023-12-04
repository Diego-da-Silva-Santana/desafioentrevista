package com.projetoentrevista.services;

import com.projetoentrevista.dto.DadosListagemPaisDTO;
import com.projetoentrevista.dto.PaisDTO;
import com.projetoentrevista.entities.Pais;
import com.projetoentrevista.exceptions.ResourceNotFoundException;
import com.projetoentrevista.exceptions.ResourceNotValidException;
import com.projetoentrevista.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return optionalPais.orElseThrow(() -> new ResourceNotFoundException("Código Internacional Iso " + codigoInternacinalIso + " não foi encontrado na base de dados.")).toPaisDTO();
    }

    public List<DadosListagemPaisDTO> listagemPaises() {
        List<Pais> pais = repository.findAll();
        return pais.stream().map(Pais::toDadosListagemPaisDTO).collect(Collectors.toList());
    }

    public PaisDTO adicionarPais(Pais pais) {
        if (repository.existsByCodigoInternacionalIso(pais.getCodigoInternacionalIso())) {
            throw new ResourceNotValidException("País com código internacional Iso " + pais.getCodigoInternacionalIso() + " já está cadastrado na base de dados");
        }
        Pais paisRetornado = repository.save(pais);
        PaisDTO paisDTO = new PaisDTO(paisRetornado);
        return paisDTO;
    }

    public void deletarpais(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("O ID " + id + " não foi encontrado na base de dados.");
        }
        repository.deleteById(id);
    }

}