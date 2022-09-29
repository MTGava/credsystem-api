package com.api.credsystem.manager.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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
