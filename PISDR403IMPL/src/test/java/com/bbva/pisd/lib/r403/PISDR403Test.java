package com.bbva.pisd.lib.r403;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import javax.annotation.Resource;

import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.pisd.lib.r403.impl.PISDR403Impl;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorRequestDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.DetailsErrorDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;
import com.bbva.rbvd.dto.insuranceroyal.mock.DummyData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bbva.pisd.lib.r403.impl.util.Constants;

import java.io.IOException;
import java.util.Map;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/PISDR403-app.xml",
		"classpath:/META-INF/spring/PISDR403-app-test.xml",
		"classpath:/META-INF/spring/PISDR403-arc.xml",
		"classpath:/META-INF/spring/PISDR403-arc-test.xml" })
public class PISDR403Test {

	@Spy
	private Context context;

	@InjectMocks
	private  PISDR403Impl pisdR403;

	@Mock
	private JdbcUtils jdbcUtils;

	private DummyData dummyData;

	@Resource(name = "applicationConfigurationService")
	private ApplicationConfigurationService applicationConfigurationService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		jdbcUtils = mock(JdbcUtils.class);
		pisdR403.setJdbcUtils(jdbcUtils);
		getObjectIntrospection();
		when(applicationConfigurationService.getProperty("enableRimacErrorMessage")).thenReturn("false");
		when(applicationConfigurationService.getDefaultProperty("rimacMessageSeparator"," / ")).thenReturn("|");
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
	public void executeFindErrorTest() {
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("COT0002001");
		details.setValue("El campo valor de datosParticulares en su elemento 1 debe contener como máximo 7 caracteres");
		error.setDetails(Collections.singletonList(details));
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_HOST);

		List<Map<String, Object>> listResponse = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		response.put("CATALOG_ELEMENT_DESC", "BBVA00123478|La fecha de nacimiento debe tener un formato válido");
		listResponse.add(response);

		when(jdbcUtils.queryForList(anyString(), anyMap())).thenReturn(listResponse);

		ErrorResponseDTO err = pisdR403.executeFindError(error);
		Assert.assertEquals(0, context.getAdviceList().size());
		//Assert.assertTrue(err.size()>0);
		Assert.assertNotNull(err);
	}

	@Test
	public void executeFindErrorTestRimac() throws IOException {
		ErrorRequestDTO errorRe = DummyData.getInstance().getErrorRequestRoyal();
		List<Map<String, Object>> listResponse = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		response.put("CATALOG_ELEMENT_DESC", "BBVA00123478|La fecha de nacimiento debe tener un formato válido");
		listResponse.add(response);

		when(jdbcUtils.queryForList(anyString(), anyMap())).thenReturn(listResponse);

		ErrorResponseDTO err = pisdR403.executeFindError(errorRe);
		Assert.assertEquals(0, context.getAdviceList().size());
		//Assert.assertTrue(err.size()>0);
		Assert.assertNotNull(err);
	}

	@Test
	public void executeGetListASingleRow_OK() {
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("PER005005");
		details.setValue("El campo nroDocumento de persona en su elemento 1 debe contener 8 caracteres");
		DetailsErrorDTO details1 = new DetailsErrorDTO();
		details1.setCode("PER005004");
		details1.setValue("El campo nroDocumento de persona en su elemento 1 debe contener como máximo 11 caracteres");
		List<DetailsErrorDTO> detailsList = new ArrayList<>();
		detailsList.add(details);
		detailsList.add(details1);
		error.setDetails(detailsList);
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_RIMAC);

		List<Map<String, Object>> listResponse = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		response.put("CATALOG_ELEMENT_DESC", "BBVA00123478|La fecha de nacimiento debe tener un formato válido");
		listResponse.add(response);

		when(jdbcUtils.queryForList(anyString(), anyMap())).thenReturn(listResponse);

		ErrorResponseDTO err= pisdR403.executeFindError(error);

		assertNotNull(err);
	}

	@Test
	public void executeGetListASingleRow_OK_apx() {
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("PER005005");
		details.setValue("El campo nroDocumento de persona en su elemento 1 debe contener 8 caracteres");
		DetailsErrorDTO details1 = new DetailsErrorDTO();
		details1.setCode("PER005004");
		details1.setValue("El campo nroDocumento de persona en su elemento 1 debe contener como máximo 11 caracteres");
		List<DetailsErrorDTO> detailsList = new ArrayList<>();
		detailsList.add(details);
		detailsList.add(details1);
		error.setDetails(detailsList);
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_APX);

		List<Map<String, Object>> listResponse = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		response.put("CATALOG_ELEMENT_DESC", "BBVA00123478|La fecha de nacimiento debe tener un formato válido");
		listResponse.add(response);

		when(jdbcUtils.queryForList(anyString(), anyMap())).thenReturn(listResponse);

		ErrorResponseDTO err= pisdR403.executeFindError(error);

		assertNotNull(err);
	}


}
