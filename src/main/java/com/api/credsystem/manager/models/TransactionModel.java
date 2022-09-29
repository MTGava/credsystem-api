package com.api.credsystem.manager.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_TRANSACOES")
@Getter
@Setter
public class TransactionModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String item;

    @Column
    private String descricao;

    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    private LocalDateTime dtTransacao;

    @ManyToOne
    @JoinColumn(name = "cartao_id")
    private CardModel cartao;

    private String senha;
}
