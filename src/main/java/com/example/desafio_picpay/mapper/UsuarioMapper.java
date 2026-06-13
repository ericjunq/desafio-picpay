package com.example.desafio_picpay.mapper;

import com.example.desafio_picpay.dto.UsuarioDTO;
import com.example.desafio_picpay.dto.UsuarioResponseDTO;
import com.example.desafio_picpay.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(dto.nomeCompleto());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());

        return usuario;
    }
    
    public UsuarioResponseDTO toDto(Usuario usuario){
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNomeCompleto(), usuario.getRole());
    }
}
