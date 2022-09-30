package com.api.credsystem.manager.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultError {

    private int codigo;
    private String mensagem;
}
