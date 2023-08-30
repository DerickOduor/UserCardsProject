package com.derick.repository;

import com.derick.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends /*CrudRepository*/JpaRepository<Card,Long> {
    Card save(Card card);
    Card findCardById(Long id);
    List<Card> findAll();
    void deleteCardById(Long id);
    @Query("SELECT c FROM Card c WHERE c.user.id = :id")
    List<Card> findByDescriptionContaining(Long id);
    @Query("SELECT c FROM Card c WHERE c.user.id = :userid and c.id = :cardid")
    List<Card> findByDescriptionContaining(Long userid,Long cardid);
}