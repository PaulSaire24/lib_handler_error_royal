package com.bbva.pisd.lib.r403.impl.util;

public enum ErrorQuotationBBVA {
    BBVA00123457("BBVA00123457","El campo producto es requerido","wrong"),
    BBVA00123464("BBVA00123464","El campo valor de datosParticulares en su elemento 1 debe contener como máximo 7 caracteres","Alert"),
    BBVA00123465("BBVA00123465","No existe el valor de equivalencia para el tipo de documento enviado.","internal server error"),
    BBVA00123466("BBVA00123466","El campo nroDocumento de persona en su elemento 1 debe contener 8 caracteres","Not Found"),
    BBVA00123467("BBVA00123467","El campo nroDocumento de persona en su elemento 1 con valor \\\"@\\\" no coincide para el patrón: 0-9","Forbidden"),
    BBVA00123468("BBVA00123468","El campo nroDocumento de persona en su elemento 1 debe contener como máximo 11 caracteres","Unauthorized"),
    BBVA00123469("BBVA00123469","El campo nroDocumento de persona en su elemento 1 debe contener al menos 5 caracteres","Bad Request"),
    BBVA00123470("BBVA00123470","El campo apePaterno de persona en su elemento 1 es requerido","Request Timeout"),
    BBVA00123471("BBVA00123471","El campo apePaterno de persona en su elemento 1 con valor \\\"@@\\\" no coincide para el patrón: a-zA-ZÀ-ÿ0-9_.&'\\\" -","Not Acceptable"),
    BBVA00123472("BBVA00123472","El campo apePaterno de persona en su elemento 1 debe contener como máximo 30 caracteres","TimeOut"),
    BBVA00123473("BBVA00123473","El campo apeMaterno de persona en su elemento 1 con valor \\\"@@\\\" no coincide para el patrón: a-zA-ZÀ-ÿ0-9_.&'\\\" -","Conflict"),
    BBVA00123474("BBVA00123474","El campo apeMaterno de persona en su elemento 1 es requerido","Bad Gateway");

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
