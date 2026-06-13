package com.example.desafio_picpay.dto;

import java.math.BigDecimal;

public record TransacaoDTO(
        BigDecimal valor,
        Long sender_id,
        Long receiver_id
) {}
