package com.api.credsystem.manager.services.exceptions;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundException(Integer id) {
        super("Dados não encontrados: " + id);
    }
}
