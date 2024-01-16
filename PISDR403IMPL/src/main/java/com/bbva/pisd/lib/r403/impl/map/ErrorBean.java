package com.bbva.pisd.lib.r403.impl.map;

import com.bbva.pisd.lib.r403.impl.util.EnumsMethods;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class ErrorBean {


    public static List<ErrorResponseDTO> mapErrorResponseEnum(List<String> codes, String type, Long httpCode){

        List<ErrorResponseDTO> errorsResponse = new ArrayList<>();

        for (String code: codes) {
            ErrorResponseDTO err = new ErrorResponseDTO();
            err.setCode(EnumsMethods.getCodeError(code));
            err.setMessage(EnumsMethods.getMessageError(code));
            err.setTypeAlert(EnumsMethods.getTypeAlertError(code));
            err.setType(type);
            err.setHttpCode(httpCode);
            errorsResponse.add(err);
        }
        return errorsResponse;

    }
}
