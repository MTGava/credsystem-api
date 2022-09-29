package com.api.credsystem.manager.services;

import com.api.credsystem.manager.models.CardModel;
import com.api.credsystem.manager.models.ClientModel;
import com.api.credsystem.manager.repositories.CardRepository;
import com.api.credsystem.manager.services.exceptions.NotFoundException;
import com.api.credsystem.manager.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.Calendar;
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
        var client = clientService.findById(id);
        Date dtValidade = Date.from(card.getDtRegistro().toInstant(ZoneOffset.of("-3")));

        card.setNumero(Utils.generateRandomNumber(16));
        card.setDtValidade(setExpirationDate(dtValidade));
        card.setCvv(Utils.generateRandomNumber(3));
        card.setLimite(calculateLimit(client.getSalario()));
        card.setSaldo(card.getLimite());
        card.setAtivo(true);
        card.setUsuario(client);

        return save(card);
    }

    public Float calculateLimit(Float salary) {
        Float thirtyPercent = salary * 0.3F;
        Float limit = 0F;
        Float maxValue = 6667F;
        if (thirtyPercent > 2000F) {
            limit = 2000F;
        } else if (thirtyPercent < 300F) {
            limit = 300F;
        } else {
            Float setup;
            setup =  Math.round(salary / maxValue * 30F) / 100F;
            System.out.println(setup);
            limit = salary * setup;
        }

        return limit;
    }

    public Date setExpirationDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 5);
        return cal.getTime();
    }
}
