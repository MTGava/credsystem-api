package com.api.credsystem.manager.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class CreateClientDto {

    @NotBlank
    private String cpf;

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotNull
    private Date dtNascimento;

    @NotBlank
    @Size(max = 150)
    private String endereco;

    @NotNull
    private Float salario;

    @Size(max = 50)
    private String cargo;
}
