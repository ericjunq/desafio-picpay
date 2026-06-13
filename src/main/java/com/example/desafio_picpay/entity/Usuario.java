package com.example.desafio_picpay.entity;

import java.math.BigDecimal;

import com.example.desafio_picpay.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nomeCompleto;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String senha;

    @Column(unique = true, length = 11)
    private String cpf;

    @Column(unique = true, length = 14)
    private String cnpj;

    @Positive
    @NotNull
    @Column(nullable = false)
    private BigDecimal saldo = BigDecimal.ZERO;

    private RoleEnum role;
    
    
}
