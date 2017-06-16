package com.atm.domain.dto.errorEnum;

/**
 * Created by Imant on 31.05.17.
 */
public enum ErrorStatus {
    WRONG_CARD_NUMBER("WRONG CARD NUMBER"),
    BLOCKED_CARD("THIS CARD IS BLOCKED"),
    WRONG_CARD_PIN_CODE("WRONG PIN CODE"),
    WRONG_AMOUNT_OF_MONEY_TO_REMOVE("WRONG AMOUNT OF MONEY TO REMOVE");

    private String massage;

    ErrorStatus(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}