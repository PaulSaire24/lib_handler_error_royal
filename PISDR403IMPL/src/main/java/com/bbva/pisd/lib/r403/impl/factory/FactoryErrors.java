package com.bbva.pisd.lib.r403.impl.factory;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.pisd.lib.r403.impl.error.Error;
import com.bbva.pisd.lib.r403.impl.error.apx.ErrorApx;
import com.bbva.pisd.lib.r403.impl.error.host.ErrorHost;
import com.bbva.pisd.lib.r403.impl.error.rimac.ErrorRimac;
import com.bbva.pisd.lib.r403.impl.util.Constants;

public class FactoryErrors {
    private FactoryErrors() {}

    public static Error requestErrorFactory(String condition, ApplicationConfigurationService applicationConfigurationService, JdbcUtils jdbcUtils){
       if(Constants.ErrorType.ERROR_APX.equals(condition)){
           return new ErrorApx(applicationConfigurationService,jdbcUtils);
       } else if (Constants.ErrorType.ERROR_RIMAC.equals(condition)) {
           return new ErrorRimac(applicationConfigurationService,jdbcUtils);
       } else{
           return new ErrorHost(applicationConfigurationService,jdbcUtils);
       }
    }
}
