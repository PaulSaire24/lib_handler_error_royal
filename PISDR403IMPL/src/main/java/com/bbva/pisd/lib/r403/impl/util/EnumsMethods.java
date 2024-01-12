package com.bbva.pisd.lib.r403.impl.util;

public class EnumsMethods {

    private EnumsMethods() {}
    public static String getCodeError(String code){
        ErrorDataSet[] arrayEnums = ErrorDataSet.values();
        for (ErrorDataSet ob :arrayEnums) {
            for (ErrorMapper er:ob.getErrors()) {
                if(code.equals(er.getCode())){
                    return er.getError().getCode();
                }
            }

        }
        return  null;
    }

    public static String getMessageError(String code){
        ErrorDataSet[] arrayEnums = ErrorDataSet.values();
        for (ErrorDataSet ob :arrayEnums) {
            for (ErrorMapper er:ob.getErrors()) {
                if(code.equals(er.getCode())){
                    return er.getError().getMessage();
                }
            }

        }
        return  null;
    }

    public static String getTypeAlertError(String code){
        ErrorDataSet[] arrayEnums = ErrorDataSet.values();
        for (ErrorDataSet ob :arrayEnums) {
            for (ErrorMapper er:ob.getErrors()) {
                if(code.equals(er.getCode())){
                    return er.getError().getTypeAlert();
                }
            }

        }
        return  null;
    }

}
