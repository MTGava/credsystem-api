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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ClientRepository clientRepository;


    @Test
    public void retornarSucesso_AoListarTodosOsClientes() throws Exception {
        var client = new ClientModel();
        client.setCpf("123.456.789-10");
        client.setNome("Patricia Romano");
        client.setDtNascimento(Utils.formatDate("19/07/2002"));
        client.setEndereco("Rua Brasil, 97");
        client.setSalario(7000F);
        client.setCargo("Desenvolvedora Java");
        client.setDtRegistro(LocalDateTime.now(ZoneId.of("GMT-3")));
        clientRepository.save(client);
        Mockito.when(clientRepository.findAll()).thenReturn(List.of(client));
        this.mockMvc.perform(get("/usuario"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\": null, \"cpf\": \"123.456.789-10\", \"nome\": \"Patricia Romano\", \"dtNascimento\": \"2002-07-19T00:00:00.000+00:00\", \"endereco\": \"Rua Brasil, 97\", \"salario\": 7000.0, \"cargo\": \"Desenvolvedora Java\"}]"));
    }

    @Test
    public void retornarSucesso_AoCriarUsuario() throws Exception {
        var client = new ClientModel();
        client.setCpf("123.456.789-10");
        client.setNome("Patricia Romano");
        client.setDtNascimento(Utils.formatDate("19/07/2002"));
        client.setEndereco("Rua Brasil, 97");
        client.setSalario(7000F);
        client.setCargo("Desenvolvedora Java");
        client.setDtRegistro(LocalDateTime.now(ZoneId.of("GMT-3")));
        Mockito.when(clientRepository.save(Mockito.any())).thenReturn(client);
        this.mockMvc.perform(post("/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"cpf\": \"123.456.789-10\", \"nome\": \"Patricia Romano\", \"endereco\": \"Rua Brasil, 97\", \"salario\": 7000, \"cargo\": \"Desenvolvedora Java\", \"dtNascimento\": \"2002-07-19\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cpf").value("123.456.789-10"))
                .andExpect(content().json("{\"id\": null, \"cpf\": \"123.456.789-10\", \"nome\": \"Patricia Romano\", \"dtNascimento\": \"2002-07-19T00:00:00.000+00:00\", \"endereco\": \"Rua Brasil, 97\", \"salario\": 7000.0, \"cargo\": \"Desenvolvedora Java\"}"));
    }
}
