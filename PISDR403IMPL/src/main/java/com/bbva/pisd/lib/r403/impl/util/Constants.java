package com.bbva.pisd.lib.r403.impl.util;

public class Constants {


    public final class  ErrorType{
        public static final String ERROR_RIMAC = "RIMAC";
        public static final String ERROR_HOST = "HOST";
        public static final String ERROR_APX = "APX";
    }

        public static final String CODE = "CODE";
        public static final String DETAIL = "DETAIL";

        public static final String CATALOG_ELEMENT_DESC = "CATALOG_ELEMENT_DESC";
        public static final String CHANNEL = "CHANNEL";
        public static final String CATALOG_ELEMENT_ID = "CATALOG_ELEMENT_ID";
        public static final String QUERY_NAME = "PISD.QUERY_SELECT_ERROR_BY_CODES_AND_PRODUCT";

    public enum TypeError {

        FUNCTIONAL("ERRF", "001"),
        TECHNICAL("ERRT", "002"),
        DATA("ERRD", "003");
        private final String name;
        private final String code;

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        TypeError(String name, String code) {
            this.name = name;
            this.code = code;
        }
    }

    public static String getCodeByName(String name){
        TypeError[] val = TypeError.values();
        for (TypeError er: val) {
            if(er.getName().equalsIgnoreCase(name)){
                return er.getCode();
            }
        }
        return null;
    }

}