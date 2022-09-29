package com.api.credsystem.manager.controllers;

import com.api.credsystem.manager.dtos.CreateCardDto;
import com.api.credsystem.manager.models.CardModel;
import com.api.credsystem.manager.services.CardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<List<CardModel>> findAll() {
        return new ResponseEntity<>(cardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardModel> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(cardService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        CardModel card = cardService.findById(id);
        if (card.getAtivo()) {
            card.setAtivo(false);
            cardService.save(card);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<CardModel> save(@RequestBody @Valid CreateCardDto createCardDto) {
        var card = new CardModel();
        BeanUtils.copyProperties(createCardDto, card);
        card.setDtRegistro(LocalDateTime.now(ZoneId.of("GMT-3")));

        return new ResponseEntity<>(cardService.generateCard(card, createCardDto.getUsuario()), HttpStatus.CREATED);
    }
}
