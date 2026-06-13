package com.example.desafio_picpay.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Usuario sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Usuario receiver;

}
