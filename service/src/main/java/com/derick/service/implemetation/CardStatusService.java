package com.derick.service.implemetation;

import com.derick.domain.CardStatus;
import com.derick.repository.StatusRepository;
import com.derick.service.ICardStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardStatusService implements ICardStatusService {
    @Autowired
    StatusRepository statusRepository;
    @Override
    public CardStatus countCardStatusByName(String name) {
        return statusRepository.countCardStatusByName(name);
    }

    @Override
    public CardStatus findCardStatusById(Long id) {
        return statusRepository.findCardStatusById(id);
    }
}
