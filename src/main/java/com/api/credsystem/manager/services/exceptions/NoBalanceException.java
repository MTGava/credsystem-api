package com.api.credsystem.manager.services.exceptions;

public class NoBalanceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoBalanceException(Float balance) {
        super("Você não possui saldo disponível! Saldo disponível: " + balance);
    }
}
