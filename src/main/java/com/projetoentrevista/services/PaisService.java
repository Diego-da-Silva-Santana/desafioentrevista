package com.projetoentrevista.services;

import com.projetoentrevista.dto.DadosListagemPaisDTO;
import com.projetoentrevista.dto.PaisDTO;
import com.projetoentrevista.entities.Pais;
import com.projetoentrevista.repositories.PaisRepository;
import com.projetoentrevista.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaisService {
    @Autowired
    private PaisRepository repository;

//    public PaisDTO listarPais(String codigoInternacinalIso){
//        Pais pais = repository.findById(codigoInternacinalIso).get();
//        PaisDTO dto = new PaisDTO(pais);
//        return dto;
//    }

    public PaisDTO listarPais(String codigoInternacinalIso) {
        Optional<Pais> optionalPais = repository.findByIdCodigoInternacional(codigoInternacinalIso);

        //PaisDTO dto = new PaisDTO(pais.get());
       // return pais.orElseThrow(() -> new ResourceNotFoundException(codigoInternacinalIso)).toPaisDTO();
       return optionalPais.orElseThrow(()-> new ResourceNotFoundException(codigoInternacinalIso)).toPaisDTO();
    }

    public List<DadosListagemPaisDTO> listagemPaises() {
        List<Pais> pais = repository.findAll();

        return pais.stream().map(Pais::toDadosListagemPaisDTO).collect(Collectors.toList());
    }

    public Pais adicionarPais(Pais pais) {

        return repository.save(pais);
    }
}
