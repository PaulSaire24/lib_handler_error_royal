package com.bbva.pisd.lib.r403.impl.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.pisd.lib.r403.impl.util.Constants;


public class ErrorMap {

    private final ApplicationConfigurationService applicationConfigurationService;

    public ErrorMap(ApplicationConfigurationService applicationConfigurationService) {
        this.applicationConfigurationService = applicationConfigurationService;
    }

    public  Map<String,Object> getArgumentsForQuery(List<String> arrayCodes, String codeError,String channel){
        Map<String,Object> arguments = new HashMap<>();
        StringBuilder argumentsCodes = new StringBuilder();
        for (String code : arrayCodes){
            argumentsCodes.append("'").append(code).append("'").append(",");
        }
        if(argumentsCodes.length()>0){
            argumentsCodes = new StringBuilder(argumentsCodes.substring(1, argumentsCodes.length() - 2));
        }

        String shortCode = codeError.substring(0,4);
        arguments.put(Constants.CATALOG_ELEMENT_ID,argumentsCodes.toString());
        arguments.put(Constants.CHANNEL,channel.concat(this.applicationConfigurationService.getProperty(shortCode)));
        return arguments;
    }
}
