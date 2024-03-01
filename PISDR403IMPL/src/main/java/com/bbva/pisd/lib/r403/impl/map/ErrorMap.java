package com.bbva.pisd.lib.r403.impl.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorMap {

    public static Map<String,Object> getArgumentsForQuery(List<String> arrayCodes){
        Map<String,Object> arguments = new HashMap<>();
        for(int i = 0; i<arrayCodes.size();i++){
            arguments.put("CODE"+(i+1),arrayCodes.get(i));
        }
        return arguments;
    }
}
