package com.jpdev.bff_agendador_tarefas.business.dtos.in;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TelefoneDTORequest {


    private String ddd;
    private String numero;
}
