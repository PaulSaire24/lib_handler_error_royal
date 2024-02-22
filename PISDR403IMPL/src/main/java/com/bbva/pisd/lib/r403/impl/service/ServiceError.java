package com.bbva.pisd.lib.r403.impl.service;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.pisd.lib.r403.impl.map.ErrorBean;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.DetailsErrorDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceError {

    private final ApplicationConfigurationService applicationConfigurationService;
    private final JdbcUtils jdbcUtils;

    public ServiceError(ApplicationConfigurationService applicationConfigurationService, JdbcUtils jdbcUtils) {
        this.applicationConfigurationService = applicationConfigurationService;
        this.jdbcUtils = jdbcUtils;
    }

    public ErrorResponseDTO findErrorEnum(List<DetailsErrorDTO> details, String type,Long httpCode){
        List<String> codeArray = details.stream().map(x -> x.getCode()).collect(Collectors.toList());
        //Método para obtener mensajes directos rimac
        List<String> messageArray = details.stream().map(x -> x.getValue()).collect(Collectors.toList());
        return ErrorBean.mapErrorResponseEnum(codeArray,messageArray,type,httpCode, applicationConfigurationService);
    }
}
