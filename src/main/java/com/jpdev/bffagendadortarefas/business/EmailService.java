package com.jpdev.bffagendadortarefas.business;

import com.jpdev.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.jpdev.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final EmailClient client;

    public void enviaEmail(TarefasDTOResponse dto){
        client.enviaEmail(dto);
    }
}
