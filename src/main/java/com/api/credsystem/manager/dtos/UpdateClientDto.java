package com.api.credsystem.manager.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UpdateClientDto {

    private String cpf;

    @Size(max = 50)
    private String nome;

    private Date dtNascimento;

    @Size(max = 150)
    private String endereco;

    private Float salario;

    @Size(max = 50)
    private String cargo;
}
