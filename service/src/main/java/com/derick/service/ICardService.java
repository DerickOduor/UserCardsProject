package com.derick.service;

import com.derick.domain.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ICardService {
    Card save(Card card);
    Card findCardById(Long id);
    List<Card> findAll();
    void deleteCardById(Long id);
    List<Card> findByDescriptionContaining(Long id);
    List<Card> findByDescriptionContaining(Long userid,Long cardid);
}
