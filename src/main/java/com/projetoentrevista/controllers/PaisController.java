package com.projetoentrevista.controllers;

import com.projetoentrevista.dto.DadosListagemPaisDTO;
import com.projetoentrevista.dto.PaisDTO;
import com.projetoentrevista.entities.Pais;
import com.projetoentrevista.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {
    @Autowired
    private PaisService service;

    @GetMapping(value = "/{codigoInternacinalIso}")
    public ResponseEntity<PaisDTO> listaPaisCodigoIso(@PathVariable String codigoInternacinalIso) {
        PaisDTO paisDTO = service.listarPais(codigoInternacinalIso);
        return ResponseEntity.ok().body(paisDTO);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemPaisDTO>> listagemPais() {
        List<DadosListagemPaisDTO> list = service.listagemPaises();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<PaisDTO> adicionarPais(@RequestBody Pais pais) {
        PaisDTO paisDTO = service.adicionarPais(pais);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).body(paisDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPais(@PathVariable Long id){
        service.deletarpais(id);
        return ResponseEntity.noContent().build();

    }

}
