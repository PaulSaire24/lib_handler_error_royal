package com.bbva.pisd.lib.r403.impl.util;

public enum ErrorQuotationBBVA {
    BBVA00123457("BBVA00123457","El campo producto es requerido","wrong"),
    BBVA00123464("BBVA00123464","El campo valor de datosParticulares en su elemento 1 debe contener como máximo 7 caracteres","Alert");
    private final String code;
    private final String message;
    private final String typeAlert;

    ErrorQuotationBBVA(String code, String details, String alert) {
        this.code = code;
        this.message = details;
        this.typeAlert = alert;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getTypeAlert() {
        return typeAlert;
    }
}
