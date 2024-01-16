package com.bbva.pisd.lib.r403.impl.util;

public enum ErrorHandlerType {
    EXTERNAL_RIMAC("RIMAC"),APX("APX"),HOST("HOST");
    private final String type;

    ErrorHandlerType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
