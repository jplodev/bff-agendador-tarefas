package com.jpdev.bff_agendador_tarefas.business;


import com.jpdev.bff_agendador_tarefas.business.dtos.in.TarefasDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.out.TarefasDTOResponse;
import com.jpdev.bff_agendador_tarefas.business.enums.StatusNotificacao;
import com.jpdev.bff_agendador_tarefas.infrastructure.client.EmailClient;
import com.jpdev.bff_agendador_tarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final EmailClient client;

    public void enviaEmail(TarefasDTOResponse dto){
        client.enviaEmail(dto);
    }

}
