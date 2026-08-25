package com.jpdev.bffagendadortarefas.business;

import com.jpdev.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.jpdev.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.jpdev.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    public String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora(){
        String token = login(paraRequestDTO());
        log.info("Iniciada a busca de tarefas");
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);
         List<TarefasDTOResponse> listaTarefas = tarefasService.
                 buscaTarefasPorPeriodo(token, horaFutura, horaFuturaMaisCinco);
         log.info("Tarefas encontradas " + listaTarefas);

         listaTarefas.forEach(tarefa -> {emailService.enviaEmail(tarefa);
             log.info("tarefas enviada para usuário " + tarefa.getEmailUsuario());
         tarefasService.alteraStatus(token, StatusNotificacaoEnum.NOTIFICADO, tarefa.getId());});
         log.info("Finalizado a busca de notificação de tarefas");
    }

    public String login(LoginDTORequest dto){
        return usuarioService.autenticarUsuario(dto);
    }

    public LoginDTORequest paraRequestDTO(){
        return LoginDTORequest.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
