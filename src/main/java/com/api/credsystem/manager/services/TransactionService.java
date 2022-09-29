package com.api.credsystem.manager.services;

import com.api.credsystem.manager.models.CardModel;
import com.api.credsystem.manager.models.TransactionModel;
import com.api.credsystem.manager.repositories.TransactionRepository;
import com.api.credsystem.manager.services.exceptions.NoBalanceException;
import com.api.credsystem.manager.services.exceptions.PasswordInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardService cardService;

    public TransactionModel save(TransactionModel transaction, Integer id) {
        var card = cardService.findById(id);

        if (!(card.getSenha().equals(transaction.getSenha()))) {
             throw new PasswordInvalidException(id);
        }

        transaction.setSenha(null);

        if(transaction.getValor() > card.getSaldo()) {
            throw new NoBalanceException(card.getSaldo());
        }

        decrementBalance(transaction.getValor(), card);
        transaction.setCartao(card);
        return transactionRepository.save(transaction);
    }

    public void decrementBalance(Float value, CardModel card) {
        Float balance = card.getSaldo() - value;
        card.setSaldo(balance);
        cardService.save(card);
    }
}
