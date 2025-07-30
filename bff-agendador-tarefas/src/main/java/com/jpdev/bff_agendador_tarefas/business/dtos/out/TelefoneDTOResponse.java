package com.jpdev.bff_agendador_tarefas.business.dtos.out;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TelefoneDTOResponse {

    private Long id;
    private String ddd;
    private String numero;
}
