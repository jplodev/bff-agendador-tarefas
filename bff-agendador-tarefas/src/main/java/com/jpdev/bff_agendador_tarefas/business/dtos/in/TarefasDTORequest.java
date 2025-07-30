package com.jpdev.bff_agendador_tarefas.business.dtos.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jpdev.bff_agendador_tarefas.business.enums.StatusNotificacao;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TarefasDTORequest {

    private String nomeTarefa;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;

}
