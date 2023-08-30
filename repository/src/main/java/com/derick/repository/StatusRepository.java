package com.derick.repository;

import com.derick.domain.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<CardStatus,Long> {
    CardStatus countCardStatusByName(String name);
    CardStatus findCardStatusById(Long id);
}
