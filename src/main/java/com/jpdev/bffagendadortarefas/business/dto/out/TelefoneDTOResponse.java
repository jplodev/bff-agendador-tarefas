package com.jpdev.bffagendadortarefas.business.dto.out;

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
