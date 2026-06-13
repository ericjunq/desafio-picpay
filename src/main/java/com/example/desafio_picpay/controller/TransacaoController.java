package com.example.desafio_picpay.controller;

import com.example.desafio_picpay.dto.TransacaoDTO;
import com.example.desafio_picpay.services.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoDTO> criarTransacao(@RequestBody TransacaoDTO transacaoDTO) throws AccessDeniedException {
        TransacaoDTO novaTransacao = transacaoService.criarTransacao(
                transacaoDTO.sender_id()
                ,transacaoDTO.receiver_id(),
                transacaoDTO.valor());

        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
    }

}
