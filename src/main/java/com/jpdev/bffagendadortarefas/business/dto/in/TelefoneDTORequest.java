package com.jpdev.bffagendadortarefas.business.dto.in;

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
