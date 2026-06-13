package com.example.desafio_picpay.services;

import com.example.desafio_picpay.dto.UsuarioDTO;
import com.example.desafio_picpay.dto.UsuarioResponseDTO;
import com.example.desafio_picpay.entity.Usuario;
import com.example.desafio_picpay.enums.RoleEnum;
import com.example.desafio_picpay.mapper.UsuarioMapper;
import com.example.desafio_picpay.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioMapper mapper;

    private final UsuarioRepository repository;

    public UsuarioResponseDTO criarUsuario(UsuarioDTO dto){

        boolean temCpf = dto.cpf() != null  && !dto.cpf().isBlank();
        boolean temCnpj = dto.cnpj() != null  && !dto.cnpj().isBlank();

        if (temCnpj == temCpf){
            throw new IllegalArgumentException("Você deve ser cadastrar com um cpf ou cnpj");
        }

        verificarDuplicidadeDados(dto);

        Usuario usuario = mapper.toEntity(dto);

        if (temCpf){
            usuario.setCpf(dto.cpf());
            usuario.setRole(RoleEnum.USUARIO);
        }

        if (temCnpj){
            usuario.setCnpj(dto.cnpj());
            usuario.setRole(RoleEnum.LOGISTA);
        }

        usuario.setSaldo(BigDecimal.ZERO);

        BigDecimal valor = new BigDecimal("1500");

        usuario.setSaldo(usuario.getSaldo().add(valor));

        Usuario salvarUsuario = repository.save(usuario);

        return mapper.toDto(salvarUsuario);

    }

    public void verificarDuplicidadeDados(UsuarioDTO dto){
        if (repository.existsByEmail(dto.email())){
            throw new IllegalStateException("Email já cadastrado");
        }

        if (repository.existsByCpf(dto.cpf())){
            throw new IllegalStateException("CPF já cadastrado");
        }

        if (repository.existsByCnpj(dto.cnpj())){
            throw new IllegalStateException("CNPJ já cadastrado");
        }
    }
}
