package com.bbva.pisd.lib.r403.impl.service;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.pisd.lib.r403.impl.map.ErrorMap;
import com.bbva.pisd.lib.r403.impl.repository.oracle.LeadBD;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.DetailsErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceError {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceError.class);

    private final ApplicationConfigurationService applicationConfigurationService;
    private final JdbcUtils jdbcUtils;

    public ServiceError(ApplicationConfigurationService applicationConfigurationService, JdbcUtils jdbcUtils) {
        this.applicationConfigurationService = applicationConfigurationService;
        this.jdbcUtils = jdbcUtils;
    }

    public ErrorResponseDTO findErrorBD(List<DetailsErrorDTO> details, String type){
        List<String> codeArray = details.stream().map(x -> x.getCode()).collect(Collectors.toList());
        LeadBD leadBD = new LeadBD(jdbcUtils);
        Map<String,Object> arguments = ErrorMap.getArgumentsForQuery(codeArray);
        LOGGER.info("ServiceError:: findErrrosBD argumets -> {}",arguments);
        String queryId = "PISD.QUERY_SELECT_ERROR_BY_".concat(String.valueOf(codeArray.size())).concat("_CODES");
        LOGGER.info("ServiceError:: findErrrosBD query Id -> {}",queryId);
        List<Map<String,Object>> resul = leadBD.executeGetListASingleRow(queryId,arguments);
        LOGGER.info("ServiceError:: result for database query -> {}",resul);
        System.out.println(resul);
        List<Map<String, String>> newList = new ArrayList<>();
        for (Map<String, Object> map : resul) {
            if (map.containsKey("CATALOG_ELEMENT_DESC")) {
                String desc = (String) map.get("CATALOG_ELEMENT_DESC");
                String[] parts = desc.split("\\|");
                if (parts.length == 2) {
                    String code = parts[0];
                    String detail = parts[1];
                    Map<String, String> newMap = new HashMap<>();
                    newMap.put("CODE", code);
                    newMap.put("DETAIL", detail);
                    newList.add(newMap);
                }
            }
        }
        LOGGER.info("ServiceError:: new List -> {}",newList);

        ErrorResponseDTO err = new ErrorResponseDTO();
        StringBuilder mes = new StringBuilder();
        for (Map<String,String> ref: newList) {
            mes = mes.append(" / ").append(ref.get("DETAIL"));
        }
        mes.delete(0,3);
        err.setCode(newList.get(0).get("CODE"));
        err.setMessage(String.valueOf(mes));
        err.setType(type);
        LOGGER.info("ServiceError:: response error DTO -> {}",err);

        return err;
    }
}
