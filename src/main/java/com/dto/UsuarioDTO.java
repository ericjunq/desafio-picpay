package com.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(@NotBlank String nomeCompleto, @NotBlank String email, @NotBlank String senha, @NotBlank String cpf) {
    
}
