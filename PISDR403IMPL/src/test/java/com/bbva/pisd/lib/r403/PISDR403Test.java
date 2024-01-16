package com.bbva.pisd.lib.r403;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import javax.annotation.Resource;

import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorRequestDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.DetailsErrorDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bbva.pisd.lib.r403.impl.util.Constants;

import java.util.Collections;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/PISDR403-app.xml",
		"classpath:/META-INF/spring/PISDR403-app-test.xml",
		"classpath:/META-INF/spring/PISDR403-arc.xml",
		"classpath:/META-INF/spring/PISDR403-arc-test.xml" })
public class PISDR403Test {

	@Spy
	private Context context;

	@Resource(name = "pisdR403")
	private PISDR403 pisdR403;

	@Mock
	private JdbcUtils jdbcUtils;

	@Resource(name = "applicationConfigurationService")
	private ApplicationConfigurationService applicationConfigurationService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.pisdR403;
		if(this.pisdR403 instanceof Advised){
			Advised advised = (Advised) this.pisdR403;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeFindErrorTest(){
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("COT0002001");
		details.setValue("El campo valor de datosParticulares en su elemento 1 debe contener como máximo 7 caracteres");
		error.setDetails(Collections.singletonList(details));
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_HOST);
		pisdR403.executeFindError(error);
		Assert.assertEquals(0, context.getAdviceList().size());
	}

	@Test
	public void executeFindErrorTestRimac(){
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("COT0002001");
		details.setValue("El campo valor de datosParticulares en su elemento 1 debe contener como máximo 7 caracteres");
		error.setDetails(Collections.singletonList(details));
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_RIMAC);
		pisdR403.executeFindError(error);
		Assert.assertEquals(0, context.getAdviceList().size());
	}

	@Test
	public void executeFindErrorTestApx(){
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("COT0002001");
		details.setValue("El campo valor de datosParticulares en su elemento 1 debe contener como máximo 7 caracteres");
		error.setDetails(Collections.singletonList(details));
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_APX);
		pisdR403.executeFindError(error);
		Assert.assertEquals(0, context.getAdviceList().size());
	}
/*
	@Test
	public void testErrorBd(){
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setChannel("PIC");
		errorDTO.setCode("1245663");
		errorDTO.setTypeErrorScope(Constants.ErrorType.ERROR_APX);
		pisdR403.executeFindError(errorDTO);
		when(jdbcUtils.queryForMap(anyString(),anyMap())).thenThrow(new NoResultException("error"));
		Assert.assertEquals(0, context.getAdviceList().size());
	}*/
	
}
