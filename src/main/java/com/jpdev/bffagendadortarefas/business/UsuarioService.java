package com.jpdev.bffagendadortarefas.business;

import com.jpdev.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.jpdev.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.jpdev.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.jpdev.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.jpdev.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.jpdev.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.jpdev.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.jpdev.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse gravaUsuario(UsuarioDTORequest dto){
        return client.gravaUsuario(dto);
    }


    public String autenticarUsuario(LoginDTORequest dto){
       return client.login(dto);
    }

    public UsuarioDTOResponse buscaUsuarioPorEmail(String token, String email){
       return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String token, String email){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaUsuario(String token, UsuarioDTORequest dto){
        return client.atualizaUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEnderecoUsuario(String token, Long id, EnderecoDTORequest dto){
       return client.atualizaEnderecoUsuario(dto, id, token);
    }

    public TelefoneDTOResponse atualizaTelefoneUsuario(String token, Long id, TelefoneDTORequest dto){
        return client.atualizaTelefoneUsuario(dto, id, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token , EnderecoDTORequest dto){
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
        return client.cadastraTelefone(dto, token);

    }


}
