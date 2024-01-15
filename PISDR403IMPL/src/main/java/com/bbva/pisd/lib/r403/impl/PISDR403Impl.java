package com.bbva.pisd.lib.r403.impl;

import com.bbva.pisd.lib.r403.impl.error.Error;
import com.bbva.pisd.lib.r403.impl.factory.FactoryErrors;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorRequestDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PISDR403Impl extends PISDR403Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(PISDR403Impl.class);

	@Override
	public List<ErrorResponseDTO> executeFindError(ErrorRequestDTO requestError) {
		LOGGER.info("request error: {0}",requestError);
		Error error = FactoryErrors.requestErrorFactory(requestError.getTypeErrorScope(), this.applicationConfigurationService, this.jdbcUtils);
		return error.findError(requestError.getDetails(),requestError.getTypeErrorScope());
	}
}
