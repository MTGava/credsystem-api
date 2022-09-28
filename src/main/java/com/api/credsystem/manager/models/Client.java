package com.api.credsystem.manager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TBL_USUARIOS")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 15)
    private String cpf;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false)
    private Date dtNascimento;

    @Column(nullable = false, length = 150)
    private String endereco;

    @Column(nullable = false)
    private Integer salario;

    @Column(nullable = true, length = 50)
    private String cargo;

}
