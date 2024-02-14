package com.bbva.pisd.lib.r403.impl.util.life.quotation;


public enum ErrorExternalQuotation {

    COT0002001("COT0002001",ErrorBBVAQuotation.BBVA00123457),
    COF0002003("COF0002003", ErrorBBVAQuotation.BBVA00123464);

    private final String code;
    private final ErrorBBVAQuotation error;

    ErrorExternalQuotation(String code, ErrorBBVAQuotation error) {
        this.code = code;
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public ErrorBBVAQuotation getError() {
        return error;
    }

}
