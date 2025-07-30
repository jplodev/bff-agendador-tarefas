package com.jpdev.bff_agendador_tarefas.business.dtos.in;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginDTORequest {

    private String email;
    private String senha;

}
