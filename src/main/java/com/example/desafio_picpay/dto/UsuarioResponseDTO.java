package com.example.desafio_picpay.dto;

import com.example.desafio_picpay.enums.RoleEnum;

public record UsuarioResponseDTO(Long id, String nomeCompleto, RoleEnum role) {
    
}
