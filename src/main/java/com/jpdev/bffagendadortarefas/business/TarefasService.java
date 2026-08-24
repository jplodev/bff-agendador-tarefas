package com.jpdev.bffagendadortarefas.business;

import com.jpdev.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.jpdev.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.jpdev.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import com.jpdev.bffagendadortarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TarefasService {

    private final TarefasClient client;

    public TarefasDTOResponse gravaTaarefa(String token, TarefasDTORequest dto){
        return client.gravaTarefa(dto, token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorPeriodo(String token , LocalDateTime dataInicial, LocalDateTime dataFinal){
       return client.buscaTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token){
        return client.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String token, String id){
       client.deletaTarefasPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(String token, StatusNotificacaoEnum status, String id){
        return client.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefa(String token, TarefasDTORequest dto, String id) {
        return client.updateTarefa(dto, id, token);
    }
}


