package com.jpdev.bff_agendador_tarefas.business;


import com.jpdev.bff_agendador_tarefas.business.dtos.in.TarefasDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.out.TarefasDTOResponse;
import com.jpdev.bff_agendador_tarefas.business.enums.StatusNotificacao;
import com.jpdev.bff_agendador_tarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TarefasService {

    private final TarefasClient client;


    public TarefasDTOResponse gravaTarefa(String token, TarefasDTORequest dto) {
        return client.garavaTarefa(dto, token );
    }

    public List<TarefasDTOResponse> buscaTerefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return client.buscaTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefaPorEmail(String token) {
        return client.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaId(String id, String token) {
        client.deletaTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificacao status, String id, String token){
       return client.auteraStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token) {
        return client.updateTarefas(dto, id, token);
    }
}
