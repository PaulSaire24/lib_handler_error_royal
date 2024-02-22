package com.bbva.pisd.lib.r403.impl.map;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.pisd.lib.r403.impl.PISDR403Impl;
import com.bbva.pisd.lib.r403.impl.util.EnumsMethods;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ErrorBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorBean.class);
    private static final String GENERIC_RIMAC_ERROR_CODE = "RBVD10094948";

    public static ErrorResponseDTO mapErrorResponseEnum(List<String> codes, List<String> messages, String type, Long httpCode, ApplicationConfigurationService applicationConfigurationService){

        ErrorResponseDTO err = new ErrorResponseDTO();
        StringBuilder mes = new StringBuilder();
        String separatorConfig = applicationConfigurationService.getDefaultProperty("rimacMessageSeparator"," / ");
        boolean enableGenericMessages = Boolean.parseBoolean(applicationConfigurationService.getProperty("enableRimacErrorMessage"));
        LOGGER.info("Is enabled generic rimac messages {}", enableGenericMessages);
        if (!enableGenericMessages) {
            if (codes.size() > 1) {
                for (String code : codes) {
                    mes =  mes.append(separatorConfig).append(EnumsMethods.getMessageError(code));
                }
                mes.delete(0, separatorConfig.length());
                err.setCode(EnumsMethods.getCodeError(codes.get(0)));
                err.setMessage(mes.toString());
                err.setType(type);
                err.setTypeAlert(EnumsMethods.getTypeAlertError(codes.get(codes.size() - 1)));
                err.setHttpCode(httpCode);
            } else {
                err.setCode(EnumsMethods.getCodeError(codes.get(0)));
                err.setMessage(EnumsMethods.getMessageError(codes.get(0)));
                err.setTypeAlert(EnumsMethods.getTypeAlertError(codes.get(0)));
                err.setType(type);
                err.setHttpCode(httpCode);
            }

        }else {
            if (codes.size() > 1) {
                for (String message : messages) {
                    mes = mes.append(separatorConfig).append(message);
                }
                mes.delete(0, separatorConfig.length());
                err.setCode(GENERIC_RIMAC_ERROR_CODE);
                err.setMessage(mes.toString());
                err.setType(type);
                err.setTypeAlert(codes.get(codes.size() - 1));
                err.setHttpCode(httpCode);
            } else {
                err.setCode(GENERIC_RIMAC_ERROR_CODE);
                err.setMessage(messages.get(0));
                err.setTypeAlert(codes.get(0));
                err.setType(type);
                err.setHttpCode(httpCode);
            }
        }
        LOGGER.info("ErrorBean response output {}", err);
        return err;

    }
}
