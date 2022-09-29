package com.api.credsystem.manager.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TBL_CARTOES")
@Getter
@Setter
public class CardModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 16)
    private String numero;

    @Column(nullable = false, length = 50)
    private String nome;

//    @Column(nullable = false)
//    private Date dtValidade;

    @Column(nullable = false, length = 3)
    private String cvv;

    @Column(nullable = false, length = 6)
    private String senha;

    @Column(nullable = false)
    private Float limite;

    @Column(nullable = false)
    private Float saldo;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(nullable = false)
    private LocalDateTime dtRegistro;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private ClientModel usuario;
}
