package com.bbva.pisd.lib.r403;

import com.bbva.rbvd.dto.insuranceroyal.error.ErrorRequestDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;


public interface PISDR403 {

	ErrorResponseDTO executeFindError(ErrorRequestDTO requestError);

}
