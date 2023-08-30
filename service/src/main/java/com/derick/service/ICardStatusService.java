package com.derick.service;

import com.derick.domain.CardStatus;

import java.util.Optional;

public interface ICardStatusService {
    CardStatus countCardStatusByName(String name);
    CardStatus findCardStatusById(Long id);
}
