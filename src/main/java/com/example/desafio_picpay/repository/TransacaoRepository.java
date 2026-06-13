package com.example.desafio_picpay.repository;

import com.example.desafio_picpay.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
