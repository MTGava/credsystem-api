package com.api.credsystem.manager.services;

import com.api.credsystem.manager.models.CardModel;
import com.api.credsystem.manager.models.ClientModel;
import com.api.credsystem.manager.repositories.CardRepository;
import com.api.credsystem.manager.services.exceptions.NotFoundException;
import com.api.credsystem.manager.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    ClientService clientService;

    public List<CardModel> findAll() {
        return cardRepository.findAll();
    }

    public CardModel findById(Integer id) {
        return cardRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public CardModel save(CardModel card) {
        return cardRepository.save(card);
    }

    public CardModel generateCard(CardModel card, Integer id) {
        System.out.println(id);
        var client = clientService.findById(id);
//        Date dtValidade = new Date("2023-12-31");
        card.setNumero(Utils.generateRandomNumber(16));
//        card.setDtValidade(dtValidade);
        card.setCvv(Utils.generateRandomNumber(3));
        card.setLimite(calculateLimit(client.getSalario()));
        card.setSaldo(card.getLimite());
        card.setAtivo(true);
        card.setUsuario(client);

        return save(card);
    }

    public Float calculateLimit(Float salary) {
        float limit;
        float thirtyPercent = salary * 1.3F;
        limit = thirtyPercent - salary;

        return limit;
    }
}
