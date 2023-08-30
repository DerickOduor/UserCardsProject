package com.derick.application.controllers;


import com.derick.application.dtos.AddCardRequest;
import com.derick.application.dtos.CardResponse;
import com.derick.application.dtos.UpdateCardRequest;
import com.derick.domain.Card;
import com.derick.domain.CardStatus;
import com.derick.domain.User;
import com.derick.service.ICardService;
import com.derick.service.ICardStatusService;
import com.derick.service.IUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    ICardService cardService;
    @Autowired
    IUserService userService;
    @Autowired
    ICardStatusService cardStatusService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards=new ArrayList<>();
        try{
            cards=cardService.findAll();
            return ResponseEntity.ok(cards);
        }catch (Exception ex){
            ex.printStackTrace();
            return (ResponseEntity<List<Card>>) ResponseEntity.badRequest();
        }
    }

    @GetMapping("/{userid}")
    public ResponseEntity<List<Card>> getAllUserCards(Long userid) {
        List<Card> cards=new ArrayList<>();
        try{
            cards=cardService.findByDescriptionContaining(userid);
            return ResponseEntity.ok(cards);
        }catch (Exception ex){
            ex.printStackTrace();
            return (ResponseEntity<List<Card>>) ResponseEntity.badRequest();
        }
    }

    @GetMapping("/{userid}/{cardid}")
    public ResponseEntity<List<Card>> getAllUserCard(Long userid,Long cardid) {
        List<Card> cards=new ArrayList<>();
        try{
            cards=cardService.findByDescriptionContaining(userid,cardid);
            return ResponseEntity.ok(cards);
        }catch (Exception ex){
            ex.printStackTrace();
            return (ResponseEntity<List<Card>>) ResponseEntity.badRequest();
        }
    }

    @PostMapping
    public ResponseEntity<CardResponse> createTask(@RequestBody AddCardRequest cardRequest) {
        CardResponse cardResponse=new CardResponse();
        Gson gson=new Gson();
        try{
            System.out.println(gson.toJson(cardRequest));
            User user=userService.findByUsername("derickuser1");
            CardStatus cardStatus=cardStatusService.findCardStatusById(1l);
            //System.out.println(gson.toJson(cardStatus));
            //CardStatus cardStatus_ = cardStatus.orElseThrow(() -> new IllegalStateException("No status found"));

            Card card=new Card(cardRequest.getName(),cardRequest.getColor(),cardRequest.getDescription());
            card.setUser(user);
            card.setStatus(cardStatus);
            cardService.save(card);
            return ResponseEntity.ok(cardResponse);
        }catch (Exception ex){
            ex.printStackTrace();
            return (ResponseEntity<CardResponse>) ResponseEntity.badRequest();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardResponse> updateTask(@PathVariable Long id, @RequestBody UpdateCardRequest cardRequest) {
        CardResponse cardResponse=new CardResponse();
        try{
            CardStatus cardStatus=cardStatusService.findCardStatusById(cardRequest.getStatusid())
                    ;
            Card card= cardService.findCardById(id);
            card.setColor(cardRequest.getColor());
            card.setName(cardRequest.getName());
            card.setDescription(cardRequest.getDescription());
            card.setStatus(cardStatus);
            return ResponseEntity.ok(cardResponse);
        }catch (Exception ex){
            ex.printStackTrace();
            return (ResponseEntity<CardResponse>) ResponseEntity.badRequest();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardResponse> deleteTask(@PathVariable Long id) {
        CardResponse cardResponse=new CardResponse();
        try{
            cardService.deleteCardById(id);
            return ResponseEntity.ok(cardResponse);
        }catch (Exception ex){
            ex.printStackTrace();
            return (ResponseEntity<CardResponse>) ResponseEntity.badRequest();
        }
    }
}