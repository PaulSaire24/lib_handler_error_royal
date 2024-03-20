package com.bbva.pisd.lib.r403.impl.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.bbva.pisd.lib.r403.impl.util.Constants;

public class ErrorMap {

    public static Map<String,Object> getArgumentsForQuery(List<String> arrayCodes, String reference){
        Map<String,Object> arguments = new HashMap<>();
        for(int i = 0; i<arrayCodes.size();i++){
            arguments.put(Constants.CODE+(i+1),arrayCodes.get(i));
        }
        arguments.put(Constants.PRODUCT_TYPE,reference);
        return arguments;
    }
}
