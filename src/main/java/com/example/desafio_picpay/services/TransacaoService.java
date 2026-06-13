package com.example.desafio_picpay.services;

import com.example.desafio_picpay.dto.TransacaoDTO;
import com.example.desafio_picpay.entity.Transacao;
import com.example.desafio_picpay.entity.Usuario;
import com.example.desafio_picpay.enums.RoleEnum;
import com.example.desafio_picpay.mapper.TransacaoMapper;
import com.example.desafio_picpay.repository.TransacaoRepository;
import com.example.desafio_picpay.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.nio.file.AccessDeniedException;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    private final UsuarioRepository usuarioRepository;

    private final TransacaoMapper transacaoMapper;

    @Transactional
    public TransacaoDTO criarTransacao(Long sender_id, Long receiver_id, BigDecimal valor) throws AccessDeniedException {
        Usuario sender = usuarioRepository.findById(sender_id)
                .orElseThrow(() -> new EntityNotFoundException("Pagador não encontrado"));

        Usuario receiver = usuarioRepository.findById(receiver_id)
                .orElseThrow(() -> new EntityNotFoundException("Recebedor não encontrado"));

        if (sender.getRole() == RoleEnum.LOGISTA){
            throw new AccessDeniedException("Usuário não tem permissão para essa ação");
        }

        if (sender.getSaldo().compareTo(valor) < 0){
        throw new IllegalArgumentException("Saldo insuficiente para essa transação");
        }

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject("https://util.devi.tools/api/v2/authorize", String.class);
        if (response == null || !response.contains("success")){
            throw new IllegalStateException("Transação não autorizada");
        }

        Transacao transacao = new Transacao();
        transacao.setSender(sender);
        transacao.setReceiver(receiver);
        transacao.setValor(valor);

        sender.setSaldo(sender.getSaldo().subtract(valor));
        usuarioRepository.save(sender);
        receiver.setSaldo(receiver.getSaldo().add(valor));
        usuarioRepository.save(receiver);

        Transacao salvarTransacao = transacaoRepository.save(transacao);

        return transacaoMapper.toDto(salvarTransacao);

    }
}
