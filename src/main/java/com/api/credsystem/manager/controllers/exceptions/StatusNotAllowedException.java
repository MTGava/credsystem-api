package com.api.credsystem.manager.controllers.exceptions;

public class StatusNotAllowedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public StatusNotAllowedException() {
        super("Status não permitido para o cartão!");
    }
}
