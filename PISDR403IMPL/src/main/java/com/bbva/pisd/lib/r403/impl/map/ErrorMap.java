package com.bbva.pisd.lib.r403.impl.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.bbva.pisd.lib.r403.impl.util.Constants;

public class ErrorMap {

    public static Map<String,Object> getArgumentsForQuery(List<String> arrayCodes, String reference){
        Map<String,Object> arguments = new HashMap<>();
        StringBuilder argumentsCodes = new StringBuilder();
        for (String code : arrayCodes){
            argumentsCodes.append("'").append(code).append("'").append(",");
        }
        if(argumentsCodes.length()>0){
            argumentsCodes.deleteCharAt(argumentsCodes.length()-1);
        }
        arguments.put(Constants.Columns.CATALOG_ELEMENT_ID,argumentsCodes.toString());
        arguments.put(Constants.Columns.PRODUCT_TYPE,reference);
        return arguments;
    }
}
