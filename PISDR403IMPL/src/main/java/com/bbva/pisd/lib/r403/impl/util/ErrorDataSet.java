package com.bbva.pisd.lib.r403.impl.util;

import com.bbva.pisd.lib.r403.impl.util.life.addthird.ErrorExternalAddThird;

public enum ErrorDataSet {

    ERROR_LIFE_ADD_THIRD_MAP(ErrorHandlerType.EXTERNAL_RIMAC,"THIRD","validación agregar terceros",
            new ErrorExternalAddThird[]{ErrorExternalAddThird.COF000001,
                    ErrorExternalAddThird.PER005005,
                    ErrorExternalAddThird.PER005011,
                    ErrorExternalAddThird.PER005004,
                    ErrorExternalAddThird.PER005003,
                    ErrorExternalAddThird.PER008002,
                    ErrorExternalAddThird.PER008011,
                    ErrorExternalAddThird.PER008004,
                    ErrorExternalAddThird.PER009011,
                    ErrorExternalAddThird.PER009002,
                    ErrorExternalAddThird.PER009004,
                    ErrorExternalAddThird.PER010002,
                    ErrorExternalAddThird.PE016003,
                    ErrorExternalAddThird.PE011010,
                    ErrorExternalAddThird.UB010002,
                    ErrorExternalAddThird.PE008002,
                    ErrorExternalAddThird.PE009002});

    private final ErrorHandlerType typeError;
    private final String code;
    private final String description;
    private final ErrorExternalAddThird[] errors;

    ErrorDataSet(ErrorHandlerType typeError, String code, String description, ErrorExternalAddThird[] errors) {
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

    public ErrorExternalAddThird[] getErrors() {
        return errors;
    }
}
