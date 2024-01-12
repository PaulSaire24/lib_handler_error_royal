package com.bbva.pisd.lib.r403.impl.util;

public enum ErrorQuotationBBVA {
    C0012345("C0012345","El campo producto es requerido","wrong"),
    C0012346("C0012346","El campo valor de datosParticulares en su elemento 1 debe contener como máximo 7 caracteres","wrong");

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
