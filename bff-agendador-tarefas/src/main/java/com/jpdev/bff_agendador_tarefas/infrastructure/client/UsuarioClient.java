package com.jpdev.bff_agendador_tarefas.infrastructure.client;


import com.jpdev.bff_agendador_tarefas.business.dtos.in.EnderecoDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.in.LoginDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.in.TelefoneDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.in.UsuarioDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.out.EnderecoDTOResponse;
import com.jpdev.bff_agendador_tarefas.business.dtos.out.TelefoneDTOResponse;
import com.jpdev.bff_agendador_tarefas.business.dtos.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaDadosUsuario(@RequestBody UsuarioDTORequest dto);

    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest dto);

    @DeleteMapping("/{email}")
    Void deletaUsuarioPorEmail(@PathVariable("email") String email,
                               @RequestHeader("Authorization") String token);


    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto, @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto, @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);
}
