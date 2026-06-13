package com.example.desafio_picpay.mapper;

import com.example.desafio_picpay.dto.TransacaoDTO;
import com.example.desafio_picpay.entity.Transacao;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {

    public TransacaoDTO toDto(Transacao transacao){
        return new TransacaoDTO(transacao.getValor()
                , transacao.getSender().getId()
                , transacao.getReceiver().getId());
    }
}
