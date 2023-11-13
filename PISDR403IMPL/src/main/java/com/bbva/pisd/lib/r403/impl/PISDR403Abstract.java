package com.bbva.pisd.lib.r403.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.pisd.lib.r403.PISDR403;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class PISDR403Abstract extends AbstractLibrary implements PISDR403 {

	protected ApplicationConfigurationService applicationConfigurationService;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

}