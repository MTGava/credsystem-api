package com.api.credsystem.manager.controllers.exceptions;

public class CardIsBlockedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CardIsBlockedException() {
        super("Não foi possível registrar a transação pois o cartão se encontra cancelado!");
    }
}
