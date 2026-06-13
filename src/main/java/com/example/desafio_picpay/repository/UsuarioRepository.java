package com.example.desafio_picpay.repository;


import com.example.desafio_picpay.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail (String email);
    boolean existsByCpf (String cpf);
    boolean existsByCnpj (String cnpj);
}
