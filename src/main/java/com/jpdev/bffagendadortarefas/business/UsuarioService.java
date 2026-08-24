package com.jpdev.bffagendadortarefas.business;

import com.jpdev.bffagendadortarefas.business.dto.EnderecoDTO;
import com.jpdev.bffagendadortarefas.business.dto.TelefoneDTO;
import com.jpdev.bffagendadortarefas.business.dto.UsuarioDTO;
import com.jpdev.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTO gravaUsuario(UsuarioDTO dto){
        return client.gravaUsuario(dto);
    }


    public String autenticarUsuario(UsuarioDTO dto){
       return client.login(dto);
    }

    public UsuarioDTO buscaUsuarioPorEmail(String token, String email){
       return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String token, String email){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTO atualizaUsuario(String token, UsuarioDTO dto){
        return client.atualizaUsuario(dto, token);
    }

    public EnderecoDTO atualizaEnderecoUsuario(String token, Long id, EnderecoDTO dto){
       return client.atualizaEnderecoUsuario(dto, id, token);
    }

    public TelefoneDTO atualizaTelefoneUsuario(String token, Long id, TelefoneDTO dto){
        return client.atualizaTelefoneUsuario(dto, id, token);
    }

    public EnderecoDTO cadastraEndereco(String token , EnderecoDTO dto){
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTO cadastraTelefone(String token, TelefoneDTO dto){
        return client.cadastraTelefone(dto, token);

    }


}
