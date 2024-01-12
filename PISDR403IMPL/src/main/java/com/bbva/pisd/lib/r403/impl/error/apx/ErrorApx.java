package com.bbva.pisd.lib.r403.impl.error.apx;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.pisd.lib.r403.impl.error.Error;
import com.bbva.pisd.lib.r403.impl.service.ServiceError;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;

import java.util.List;
import java.util.Map;

public class ErrorApx extends Error {
    private final ApplicationConfigurationService applicationConfigurationService;
    private final JdbcUtils jdbcUtils;

    public ErrorApx(ApplicationConfigurationService applicationConfigurationService, JdbcUtils jdbcUtils) {
        this.applicationConfigurationService = applicationConfigurationService;
        this.jdbcUtils = jdbcUtils;
    }

    @Override
    public List<ErrorResponseDTO> findError(Map<String,Object> codes, String type) {
        ServiceError serviceError = new ServiceError(applicationConfigurationService,jdbcUtils);
        return serviceError.findErrorEnum(codes,type);
    }
}