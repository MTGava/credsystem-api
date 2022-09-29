package com.api.credsystem.manager.controllers;

import com.api.credsystem.manager.dtos.CreateClientDto;
import com.api.credsystem.manager.dtos.UpdateClientDto;
import com.api.credsystem.manager.models.ClientModel;
import com.api.credsystem.manager.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientModel>> findAll() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientModel> save(@RequestBody @Valid CreateClientDto createClientDto) {
        var client = new ClientModel();
        BeanUtils.copyProperties(createClientDto, client);
        client.setDtRegistro(LocalDateTime.now(ZoneId.of("GMT-3")));
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientModel> update(@PathVariable Integer id, @RequestBody @Valid UpdateClientDto updateClientDto) {
        ClientModel clientModel = clientService.findById(id);
        BeanUtils.copyProperties(updateClientDto, clientModel);
        return new ResponseEntity<>(clientService.save(clientModel), HttpStatus.OK);
    }
}
