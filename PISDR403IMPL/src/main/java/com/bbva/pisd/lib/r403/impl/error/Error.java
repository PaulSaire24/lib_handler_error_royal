package com.bbva.pisd.lib.r403.impl.error;

import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;

import java.util.List;
import java.util.Map;

public abstract class Error {

    public abstract List<ErrorResponseDTO> findError(Map<String,Object> codes, String type);

}
