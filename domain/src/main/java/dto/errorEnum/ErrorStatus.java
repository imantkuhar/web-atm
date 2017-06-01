package dto.errorEnum;

/**
 * Created by Imant on 31.05.17.
 */
public enum ErrorStatus {
    WRONG_CARD_NUMBER("WRONG_CARD_NUMBER"),
    WRONG_CARD_PIN("WRONG_CARD_PIN"),
    WRONG_AMOUNT_OF_MONEY_TO_REMOVE("WRONG_AMOUNT_OF_MONEY_TO_REMOVE");

    private String errorStatus;

    ErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorStatus() {
        return errorStatus;
    }
}