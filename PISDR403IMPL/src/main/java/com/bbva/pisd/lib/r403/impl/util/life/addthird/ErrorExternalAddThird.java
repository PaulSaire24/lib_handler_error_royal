package com.bbva.pisd.lib.r403.impl.util.life.addthird;


public enum ErrorExternalAddThird {
    COF000001("COF000001", ErrorBbvaAddThird.BBVA00123465),
    PER005005("PER005005", ErrorBbvaAddThird.BBVA00123466),
    PER005011("PER005011", ErrorBbvaAddThird.BBVA00123467),
    PER005004("PER005004", ErrorBbvaAddThird.BBVA00123468),
    PER005003("PER005003", ErrorBbvaAddThird.BBVA00123469),
    PER008002("PER008002", ErrorBbvaAddThird.BBVA00123470),
    PER008011("PER008011", ErrorBbvaAddThird.BBVA00123471),
    PER008004("PER008004", ErrorBbvaAddThird.BBVA00123472),
    PER009011("PER009011", ErrorBbvaAddThird.BBVA00123473),
    PER009002("PER009002", ErrorBbvaAddThird.BBVA00123474),
    PER009004("PER009004", ErrorBbvaAddThird.BBVA00123475),
    PER010002("PER010002", ErrorBbvaAddThird.BBVA00123476),
    PE016003("PE016003", ErrorBbvaAddThird.BBVA00123477),
    PE011010("PE011010", ErrorBbvaAddThird.BBVA00123478),
    UB010002("UB010002", ErrorBbvaAddThird.BBVA00123479);

    private final String code;
    private final ErrorBbvaAddThird error;

    ErrorExternalAddThird(String code, ErrorBbvaAddThird error) {
        this.code = code;
        this.error = error;
    }


    public String getCode() {
        return code;
    }

    public ErrorBbvaAddThird getError() {
        return error;
    }
}
