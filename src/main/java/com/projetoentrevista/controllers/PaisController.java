package com.projetoentrevista.controllers;

import com.projetoentrevista.dto.DadosListagemPaisDTO;
import com.projetoentrevista.dto.PaisDTO;
import com.projetoentrevista.entities.Pais;
import com.projetoentrevista.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {
    @Autowired
    private PaisService service;

    @GetMapping(value = "/{codigoInternacinalIso}")
    public ResponseEntity<PaisDTO> listaPaisCodigoIso(@PathVariable String codigoInternacinalIso) {
        PaisDTO paisDTO = service.listarPais(codigoInternacinalIso);

        return ResponseEntity.ok().body(paisDTO);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemPaisDTO>> listagemPais(){
        List<DadosListagemPaisDTO> list = service.listagemPaises();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Pais> adicionarPais(@RequestBody Pais pais){
        pais = service.adicionarPais(pais);

        return ResponseEntity.ok().body(pais);
    }


}
