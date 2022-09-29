package com.api.credsystem.manager.services;

import com.api.credsystem.manager.models.ClientModel;
import com.api.credsystem.manager.repositories.ClientRepository;
import com.api.credsystem.manager.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientModel> findAll() {
        return clientRepository.findAll();
    }

    public ClientModel findById(Integer id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public ClientModel save(ClientModel client) {
        return clientRepository.save(client);
    }

    public void delete(Integer id) {
        try {
            clientRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e) {
            throw new NotFoundException(id);
        }
    }

    public ClientModel update(Integer id, ClientModel client) {
        try {
            ClientModel clientUpdate = findById(id);
            return clientRepository.save(client);
        } catch(EmptyResultDataAccessException e) {
            throw new NotFoundException(id);
        }
    }
}
