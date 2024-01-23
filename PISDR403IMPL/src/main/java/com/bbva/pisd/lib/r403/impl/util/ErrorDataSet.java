package com.bbva.pisd.lib.r403.impl.util;

public enum ErrorDataSet {
    ERROR_QUOTATION(ErrorHandlerType.EXTERNAL_RIMAC,"COT","servicio cotizacion",
            new ErrorMapper[]{ErrorMapper.COT0002001,
                    ErrorMapper.COF0002003}),
    ERROR_THIRD_VALIDATION(ErrorHandlerType.EXTERNAL_RIMAC,"THIRD","validación agregar terceros",
            new ErrorMapper[]{ErrorMapper.COF000001,
                    ErrorMapper.PER005005,
                    ErrorMapper.PER005011,
                    ErrorMapper.PER005004,
                    ErrorMapper.PER005003,
                    ErrorMapper.PER008002,
                    ErrorMapper.PER008011,
                    ErrorMapper.PER008004,
                    ErrorMapper.PER009011,
                    ErrorMapper.PER009002});

    private final ErrorHandlerType typeError;
    private final String code;
    private final String description;
    private final ErrorMapper[] errors;

    ErrorDataSet(ErrorHandlerType typeError, String code, String description, ErrorMapper[] errors) {
        this.typeError = typeError;
        this.code = code;
        this.description = description;
        this.errors = errors;
    }

    public ErrorHandlerType getTypeError() {
        return typeError;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public ErrorMapper[] getErrors() {
        return errors;
    }
}
