package com.api.credsystem.manager.services.exceptions;

public class PasswordInvalidException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PasswordInvalidException(Integer id) {
        super("Senha inválida para o cartão: " + id);
    }
}
