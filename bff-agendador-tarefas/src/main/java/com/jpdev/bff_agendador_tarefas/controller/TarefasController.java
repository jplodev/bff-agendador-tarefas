package com.jpdev.bff_agendador_tarefas.controller;


import com.jpdev.bff_agendador_tarefas.business.TarefasService;
import com.jpdev.bff_agendador_tarefas.business.dtos.in.TarefasDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.out.TarefasDTOResponse;
import com.jpdev.bff_agendador_tarefas.business.enums.StatusNotificacao;
import com.jpdev.bff_agendador_tarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefas")
@Tag(name = "Tarefas", description = "Cadastra tarefas de usuário")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salvar tarefas de usuários", description = "Cria uma nova tarefa de usuário")
    @ApiResponse(responseCode = "200", description = "Tarefa salvo com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TarefasDTOResponse> garavaTarefa(@RequestBody TarefasDTORequest dto,
                                                           @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.gravaTarefa(token, dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca tarefas por período", description = "Busca tarefas cadastradas por período")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas salvo com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name= "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.buscaTerefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Busca listas tarefas por email de usuário", description = "Busca tarefas cadastradas por email de usuário")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas salvo com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaTarefasPorEmail(@RequestHeader(name= "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.buscaTarefaPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefas por Id", description = "Deleta tarefas cadastrada por Id")
    @ApiResponse(responseCode = "200", description = "Tarefas deletada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id,
                                                  @RequestHeader(name= "Authorization", required = false) String token) {
        tarefasService.deletaTarefaId(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status de tarefas", description = "Altera status tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefas alteradas")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TarefasDTOResponse> auteraStatusNotificacao(@RequestParam("status") StatusNotificacao status,
                                                                      @RequestParam("id") String id,
                                                                      @RequestHeader(name= "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.alteraStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados de tarefas", description = "Altera dados tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefas alteradas")
    @ApiResponse(responseCode = "500", description = "Erro de Servidor")
    public ResponseEntity<TarefasDTOResponse> updateTarefas(@RequestBody TarefasDTORequest dto, @RequestParam("id") String id,
                                                            @RequestHeader(name= "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id, token));
    }
}
