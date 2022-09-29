package com.api.credsystem.manager.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TransactionDto {

    @NotBlank
    @Size(max = 50)
    private String item;

    private String descricao;

    @NotBlank
    @Size(max = 6)
    private String senha;

    @NotNull
    private Float valor;

    @NotNull
    private Integer cartao;
}
