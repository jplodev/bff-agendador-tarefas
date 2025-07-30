package com.jpdev.bff_agendador_tarefas.infrastructure.client;


import com.jpdev.bff_agendador_tarefas.business.dtos.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    void enviaEmail(@RequestBody TarefasDTOResponse dto);
}

