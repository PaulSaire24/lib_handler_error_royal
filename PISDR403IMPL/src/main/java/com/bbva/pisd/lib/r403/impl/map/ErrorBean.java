package com.bbva.pisd.lib.r403.impl.map;

import com.bbva.pisd.lib.r403.impl.util.EnumsMethods;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class ErrorBean {


    public static ErrorResponseDTO mapErrorResponseEnum(List<String> codes, String type, Long httpCode){

        ErrorResponseDTO err = new ErrorResponseDTO();
        StringBuilder mes = new StringBuilder();

        if(codes.size()>1){
            for (String code :codes) {
                mes = mes.append(" / ").append(EnumsMethods.getMessageError(code));
            }
            mes.delete(0,3);
            err.setCode(EnumsMethods.getCodeError(codes.get(0)));
            err.setMessage(String.valueOf(mes));
            err.setType(type);
            err.setTypeAlert(EnumsMethods.getTypeAlertError(codes.get(codes.size()-1)));
            err.setHttpCode(httpCode);
        }else{
            err.setCode(EnumsMethods.getCodeError(codes.get(0)));
            err.setMessage(EnumsMethods.getMessageError(codes.get(0)));
            err.setTypeAlert(EnumsMethods.getTypeAlertError(codes.get(0)));
            err.setType(type);
            err.setHttpCode(httpCode);
        }

        return err;

    }
}
