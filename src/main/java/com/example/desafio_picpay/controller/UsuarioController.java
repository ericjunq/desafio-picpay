package com.example.desafio_picpay.controller;

import com.example.desafio_picpay.dto.UsuarioDTO;
import com.example.desafio_picpay.dto.UsuarioResponseDTO;
import com.example.desafio_picpay.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioResponseDTO novoUsuario = usuarioService.criarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
}
