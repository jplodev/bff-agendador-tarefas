package com.jpdev.bffagendadortarefas.infrastructure.client;


import com.jpdev.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.jpdev.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.jpdev.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.jpdev.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.jpdev.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.jpdev.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.jpdev.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @PostMapping
    UsuarioDTOResponse gravaUsuario(@RequestBody UsuarioDTORequest dto);

    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest dto);

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable("email") String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizaUsuario(@RequestBody UsuarioDTORequest dto,
                                       @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEnderecoUsuario(@RequestBody EnderecoDTORequest dto,
                                                @RequestParam("id") Long id,
                                                @RequestHeader("Authorization") String token);
    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefoneUsuario(@RequestBody TelefoneDTORequest dto,
                                                @RequestParam("id") Long id,
                                                @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);

}
