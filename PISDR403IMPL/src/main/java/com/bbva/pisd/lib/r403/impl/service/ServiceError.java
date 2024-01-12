package com.bbva.pisd.lib.r403.impl.service;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.pisd.lib.r403.impl.map.ErrorBean;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;

import java.util.List;
import java.util.Map;

public class ServiceError {

    private final ApplicationConfigurationService applicationConfigurationService;
    private final JdbcUtils jdbcUtils;

    public ServiceError(ApplicationConfigurationService applicationConfigurationService, JdbcUtils jdbcUtils) {
        this.applicationConfigurationService = applicationConfigurationService;
        this.jdbcUtils = jdbcUtils;
    }


    /*public List<ErrorResponseDTO> findErrorDataBase(Map<String,Object> codes, String channel){
        String[] codesArray = codes.keySet().toArray(new String[0]);
        Map<String,Object> arguments = ErrorMap.mapError(codesArray,channel);
        LeadBD leadBD = new LeadBD(jdbcUtils);
        Map<String, Object> mapResponse = leadBD.executeGetASingleRow(Constants.NameQuerys.QUERY_GET_ERROR_DATA_BASE, arguments);
        return  ErrorBean.mapErrorResponseBd(mapResponse);
    }*/

    public List<ErrorResponseDTO> findErrorEnum(Map<String,Object> codes, String type){
        String[] codesArray = codes.keySet().toArray(new String[0]);
        return ErrorBean.mapErrorResponseEnum(codesArray,type);
    }
}
