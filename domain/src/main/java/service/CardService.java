package service;

import entity.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CardRepository;

/**
 * Created by Imant on 28.05.17.
 */
@Service
public class CardService{

    @Autowired
    private CardRepository cardRepository;

    public void save(CardEntity cardEntity) {
        cardRepository.save(cardEntity);
    }

    public void delete(CardEntity cardEntity) {
        cardRepository.delete(cardEntity);
    }

    public CardEntity find(String cardNumber) {
        return cardRepository.findOne(cardNumber);
    }

    public void update(CardEntity cardEntity) {
        cardRepository.save(cardEntity);
    }
}
