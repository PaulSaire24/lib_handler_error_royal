package com.bbva.pisd.lib.r403.impl.error.rimac;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.pisd.lib.r403.impl.error.Error;
import com.bbva.pisd.lib.r403.impl.service.ServiceError;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.DetailsErrorDTO;

import java.util.List;

public class ErrorRimac extends Error {

    private ApplicationConfigurationService applicationConfigurationService;
    private JdbcUtils jdbcUtils;

    public ErrorRimac(ApplicationConfigurationService applicationConfigurationService, JdbcUtils jdbcUtils) {
        this.applicationConfigurationService = applicationConfigurationService;
        this.jdbcUtils = jdbcUtils;
    }

    @Override
    public ErrorResponseDTO findError(List<DetailsErrorDTO> details, String type, Long httpCode) {
        ServiceError serviceError = new ServiceError(applicationConfigurationService,jdbcUtils);
        return serviceError.findErrorBD(details,type);
    }
}
