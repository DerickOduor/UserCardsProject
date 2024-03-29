package com.derick.application.dtos;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("cardResponse")
public class CardResponse {
    private boolean status;
    private String description;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
