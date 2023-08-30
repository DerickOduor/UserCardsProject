package com.derick.domain;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "CardStatus")
@Data
public class CardStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards;
}
