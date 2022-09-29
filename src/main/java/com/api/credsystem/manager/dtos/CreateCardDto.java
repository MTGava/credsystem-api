package com.api.credsystem.manager.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateCardDto {

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotNull
    @Size(max = 6)
    private String senha;

    @NotNull
    private Integer usuario;
}
