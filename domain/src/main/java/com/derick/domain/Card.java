package com.derick.domain;

import javax.persistence.*;

import com.derick.domain.exceptions.NullorEmptyException;
import lombok.Data;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "Card")
@Data
public class Card {
    public Card(){

    }
    public Card(String name,String color, String description) throws NullorEmptyException{
        if(name==null) throw new NullorEmptyException("Card name is not provided");
        String regexPattern = "^#([0-9A-Fa-f]{6})$";

        if(color!=null){
            if(!color.trim().equalsIgnoreCase("")){
                Pattern pattern = Pattern.compile(regexPattern);
                Matcher matcher = pattern.matcher(color);
                if (!matcher.matches()) {
                    throw new NullorEmptyException("Card color is invalid");
                }
            }
        }
        this.name=name;
        this.color=color;
        this.description=description;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String color;
    @Column
    private String description;
    @Column
    private Date creationdate;
//    @Column
//    private Long cardstatusid;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private CardStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
