package com.projetoentrevista.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object codigoInternacinalIso) {
        super("Codigo Internacional Iso " + codigoInternacinalIso + " não foi encontrado.");
    }
}
