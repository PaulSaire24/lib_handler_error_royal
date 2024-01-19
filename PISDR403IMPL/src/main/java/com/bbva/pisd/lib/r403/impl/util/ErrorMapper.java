package com.bbva.pisd.lib.r403.impl.util;

public enum ErrorMapper {
    COT0002001("COT0002001",ErrorQuotationBBVA.BBVA00123457),
    COF0002003("COT0002002",ErrorQuotationBBVA.BBVA00123464),
    COF000001("COF000001",ErrorQuotationBBVA.BBVA00123465),
    PER005005("PER005005",ErrorQuotationBBVA.BBVA00123466),
    PER005011("PER005011",ErrorQuotationBBVA.BBVA00123467),
    PER005004("PER005004",ErrorQuotationBBVA.BBVA00123468),
    PER005003("PER005003",ErrorQuotationBBVA.BBVA00123469),
    PER008002("PER008002",ErrorQuotationBBVA.BBVA00123470),
    PER008011("PER008011",ErrorQuotationBBVA.BBVA00123471),
    PER008004("PER008004",ErrorQuotationBBVA.BBVA00123472),
    PER009011("PER009011",ErrorQuotationBBVA.BBVA00123473),
    PER009002("PER009002",ErrorQuotationBBVA.BBVA00123474);
    private final String code;
    private final ErrorQuotationBBVA error;

    ErrorMapper(String code, ErrorQuotationBBVA error) {
        this.code = code;
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public ErrorQuotationBBVA getError() {
        return error;
    }
}
