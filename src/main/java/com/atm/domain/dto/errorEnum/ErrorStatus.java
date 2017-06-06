package com.atm.domain.dto.errorEnum;

/**
 * Created by Imant on 31.05.17.
 */
public enum ErrorStatus {
    WRONG_CARD_NUMBER("WRONG_CARD_NUMBER"),
    BLOCKED_CARD("BLOCKED_CARD"),
    WRONG_CARD_PIN_CODE("WRONG_CARD_PIN_CODE"),
    WRONG_AMOUNT_OF_MONEY_TO_REMOVE("WRONG_AMOUNT_OF_MONEY_TO_REMOVE");

    private String massage;

    ErrorStatus(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}