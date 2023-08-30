package com.derick.service.implemetation;

import com.derick.domain.Card;
import com.derick.repository.CardRepository;
import com.derick.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService implements ICardService {
    @Autowired
    CardRepository cardRepository;
    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card findCardById(Long id) {
        return cardRepository.findCardById(id);
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public void deleteCardById(Long id) {
        cardRepository.deleteCardById(id);
    }

    @Override
    public List<Card> findByDescriptionContaining(Long id) {
        return cardRepository.findByDescriptionContaining(id);
    }

    @Override
    public List<Card> findByDescriptionContaining(Long userid, Long cardid) {
        return cardRepository.findByDescriptionContaining(userid, cardid);
    }
}
