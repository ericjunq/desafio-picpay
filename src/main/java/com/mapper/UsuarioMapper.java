package com.mapper;

import com.dto.UsuarioDTO;
import com.dto.UsuarioResponseDTO;
import com.entity.Usuario;

public class UsuarioMapper {

    public Usuario toEntity(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(dto.nomeCompleto());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setCpf(dto.cpf());

        return usuario;
    }
    
    public UsuarioResponseDTO responseDTO(Usuario usuario){
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNomeCompleto());
    }
}
