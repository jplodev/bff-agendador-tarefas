package com.jpdev.bffagendadortarefas.infrastructure.client;


import com.jpdev.bffagendadortarefas.business.dto.EnderecoDTO;
import com.jpdev.bffagendadortarefas.business.dto.TelefoneDTO;
import com.jpdev.bffagendadortarefas.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @PostMapping
    UsuarioDTO gravaUsuario(@RequestBody UsuarioDTO dto);

    @PostMapping("/login")
    String login(@RequestBody UsuarioDTO dto);

    @GetMapping
   UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                   @RequestHeader("Authorization") String token);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable("email") String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTO atualizaUsuario(@RequestBody UsuarioDTO dto,
                               @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTO atualizaEnderecoUsuario(@RequestBody EnderecoDTO dto,
                                        @RequestParam("id") Long id,
                                        @RequestHeader("Authorization") String token);
    @PutMapping("/telefone")
    TelefoneDTO atualizaTelefoneUsuario(@RequestBody TelefoneDTO dto,
                                        @RequestParam("id") Long id,
                                        @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTO cadastraEndereco(@RequestBody EnderecoDTO dto,
                                 @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTO cadastraTelefone(@RequestBody TelefoneDTO dto,
                                 @RequestHeader("Authorization") String token);

}
