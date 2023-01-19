package com.poc.exception;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */
    ERR_MCS_POST_TITLE_EMPTY("Error occurred - Post title shouldn't be NULL or EMPTY"),
    ERR_MCS_POST_ID_EMPTY("Error occurred - Post id shouldn't be NULL or EMPTY"),
    ERR_MCS_COMMENT_TEXT_EMPTY("Error occurred - Comment text shouldn't be NULL or EMPTY"),
    ERR_MCS_POST_NOT_FOUND("Error occurred - No Post found with this id"),
    ERR_MCS_COMMENT_NOT_FOUND("Error occurred - No Comment found with this id");

    private final String errorMessage;

    private ErrorsEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return " errorMessage : " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
