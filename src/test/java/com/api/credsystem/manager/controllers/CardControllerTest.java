package com.api.credsystem.manager.controllers;

import com.api.credsystem.manager.models.ClientModel;
import com.api.credsystem.manager.repositories.ClientRepository;
import com.api.credsystem.manager.utils.Utils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ClientRepository clientRepository;


    @Test
    public void retornarSucesso_AoListarTodosOsClientes() {
        var client = new ClientModel();
        Mockito.when(clientRepository.findAll()).thenReturn(List.of(client));
    }

    @Test
    public void retornarSucesso_AoBuscarUmCliente() {
        var client = new ClientModel();
        client.setCpf("123.456.789-10");
        client.setNome("Patricia Romano");
        client.setDtNascimento(Utils.formatDate("19/07/2002"));
        client.setEndereco("Rua Brasil, 97");
        client.setSalario(70000F);
        client.setCargo("Desenvolvedora Java");
        client.setDtRegistro(LocalDateTime.now(ZoneId.of("GMT-3")));
        clientRepository.save(client);
        Mockito.when(clientRepository.findById(1)).thenReturn(Optional.of(client));
    }

    @Test
    public void retornarSucesso_AoCriarUsuario() {
        var client = new ClientModel();
        client.setCpf("123.456.789-10");
        client.setNome("Patricia Romano");
        client.setDtNascimento(Utils.formatDate("19/07/2002"));
        client.setEndereco("Rua Brasil, 97");
        client.setSalario(70000F);
        client.setCargo("Desenvolvedora Java");
        client.setDtRegistro(LocalDateTime.now(ZoneId.of("GMT-3")));
        Mockito.when(clientRepository.save(Mockito.any())).thenReturn(client);
    }
    @Test
    public void retornarSucesso_AoDeletarUmCliente() {
        var client = new ClientModel();
        client.setCpf("123.456.789-10");
        client.setNome("Patricia Romano");
        client.setDtNascimento(Utils.formatDate("19/07/2002"));
        client.setEndereco("Rua Brasil, 97");
        client.setSalario(70000F);
        client.setCargo("Desenvolvedora Java");
        client.setDtRegistro(LocalDateTime.now(ZoneId.of("GMT-3")));
        clientRepository.save(client);
        clientRepository.deleteById(1);
    }

    @Test
    public void retornarSucesso_AoAtualizarUmCliente() {
        var client = new ClientModel();
        client.setCpf("123.456.789-10");
        client.setNome("Patricia Romano");
        client.setDtNascimento(Utils.formatDate("19/07/2002"));
        client.setEndereco("Rua Brasil, 97");
        client.setSalario(70000F);
        client.setCargo("Desenvolvedora Java");
        client.setDtRegistro(LocalDateTime.now(ZoneId.of("GMT-3")));
        clientRepository.save(client);

        client.setCargo("Desenvolvedora PL/SQL");
        Mockito.when(clientRepository.save(Mockito.any())).thenReturn(client);
    }
}
