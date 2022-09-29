package com.api.credsystem.manager.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TBL_USUARIOS")
@Getter
@Setter
public class ClientModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true, length = 15)
    private String cpf;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false)
    private Date dtNascimento;

    @Column(nullable = false, length = 150)
    private String endereco;

    @Column(nullable = false)
    private Float salario;

    @Column(length = 50)
    private String cargo;

    @Column(nullable = false)
    private LocalDateTime dtRegistro;

    public void setDtRegistro(LocalDateTime dtRegistro) {
        this.dtRegistro = dtRegistro;
    }
}
