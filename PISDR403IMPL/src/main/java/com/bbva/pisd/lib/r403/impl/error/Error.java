package com.bbva.pisd.lib.r403.impl.error;

import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.DetailsErrorDTO;

import java.util.List;

public abstract class Error {

    public abstract ErrorResponseDTO findError(List<DetailsErrorDTO> details, String code, String channel);

}
