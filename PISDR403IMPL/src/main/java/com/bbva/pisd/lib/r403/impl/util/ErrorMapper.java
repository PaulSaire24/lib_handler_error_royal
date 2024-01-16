package com.bbva.pisd.lib.r403.impl.util;

public enum ErrorMapper {
    COT0002001("COT0002001",ErrorQuotationBBVA.C0012345),
    COF0002003("COT0002002",ErrorQuotationBBVA.C0012346);
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
