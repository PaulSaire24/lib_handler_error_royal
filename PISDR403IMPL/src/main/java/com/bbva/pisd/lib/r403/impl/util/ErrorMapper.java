package com.bbva.pisd.lib.r403.impl.util;

public enum ErrorMapper {
    COF000001("COF000001",ErrorAddThird.BBVA00123465),
    PER005005("PER005005",ErrorAddThird.BBVA00123466),
    PER005011("PER005011",ErrorAddThird.BBVA00123467),
    PER005004("PER005004",ErrorAddThird.BBVA00123468),
    PER005003("PER005003",ErrorAddThird.BBVA00123469),
    PER008002("PER008002",ErrorAddThird.BBVA00123470),
    PER008011("PER008011",ErrorAddThird.BBVA00123471),
    PER008004("PER008004",ErrorAddThird.BBVA00123472),
    PER009011("PER009011",ErrorAddThird.BBVA00123473),
    PER009002("PER009002",ErrorAddThird.BBVA00123474),
    PER009004("PER009004",ErrorAddThird.BBVA00123475),
    PER010002("PER010002",ErrorAddThird.BBVA00123476);

    private final String code;
    private final ErrorAddThird error;

    ErrorMapper(String code, ErrorAddThird error) {
        this.code = code;
        this.error = error;
    }


    public String getCode() {
        return code;
    }

    public ErrorAddThird getError() {
        return error;
    }
}
