package com.jpdev.bff_agendador_tarefas.business;


import com.jpdev.bff_agendador_tarefas.business.dtos.in.EnderecoDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.in.LoginDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.in.TelefoneDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.in.UsuarioDTORequest;
import com.jpdev.bff_agendador_tarefas.business.dtos.out.EnderecoDTOResponse;
import com.jpdev.bff_agendador_tarefas.business.dtos.out.TelefoneDTOResponse;
import com.jpdev.bff_agendador_tarefas.business.dtos.out.UsuarioDTOResponse;
import com.jpdev.bff_agendador_tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaDadosUsuario(UsuarioDTORequest dto) {
        return client.salvaDadosUsuario(dto);
    }

    public String login(LoginDTORequest dto){
        return client.login(dto);
    }

    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token){
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaUsuario(String token, UsuarioDTORequest dto){
       return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long id, EnderecoDTORequest dto, String token){
        return client.atualizaEndereco(dto, id, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long id, TelefoneDTORequest dto, String token){
       return client.atualizaTelefone(dto, id, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){
       return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto) {
        return client.cadastraTelefone(dto, token);
    }
}
