package com.example.desafio_picpay.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(@NotBlank String nomeCompleto, @NotBlank String email, @NotBlank String senha,  String cpf, String cnpj) {
    
}
