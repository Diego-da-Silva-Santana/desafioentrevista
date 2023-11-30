package com.projetoentrevista.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object codigoInternacinalIso) {
        super("Codigo Internacional Iso " + codigoInternacinalIso + " não foi encontrado.");
    }


}
