package com.bbva.pisd.lib.r403;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import javax.annotation.Resource;

import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorRequestDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.DetailsErrorDTO;
import com.bbva.rbvd.dto.insuranceroyal.error.ErrorResponseDTO;
import com.bbva.rbvd.dto.insuranceroyal.mock.DummyData;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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

	private DummyData dummyData;

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
	public void executeFindErrorTest() {
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("COT0002001");
		details.setValue("El campo valor de datosParticulares en su elemento 1 debe contener como máximo 7 caracteres");
		error.setDetails(Collections.singletonList(details));
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_HOST);
		List<ErrorResponseDTO> listError = pisdR403.executeFindError(error);
		Assert.assertEquals(0, context.getAdviceList().size());
		Assert.assertTrue(listError.size()>0);
		Assert.assertNotNull(listError);
	}

	@Test
	public void executeFindErrorTestRimac() throws IOException {
		ErrorRequestDTO errorRe = DummyData.getInstance().getErrorRequestRoyal();
		List<ErrorResponseDTO> listError = pisdR403.executeFindError(errorRe);
		Assert.assertEquals(0, context.getAdviceList().size());
		Assert.assertTrue(listError.size()>0);
		Assert.assertNotNull(listError);
	}

	@Test
	public void executeFindErrorThirdTestRimac()  {
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
		List<ErrorResponseDTO> listError = pisdR403.executeFindError(error);
		System.out.println(listError);
		Assert.assertEquals(0, context.getAdviceList().size());
		//Assert.assertEquals(2,listError.size());
		Assert.assertNotNull(listError);
	}

	@Test
	public void executeFindErrorTestApx(){
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("PER008002");
		details.setValue("El campo apePaterno de persona en su elemento 1 es requerido");
		DetailsErrorDTO details1 = new DetailsErrorDTO();
		details1.setCode("PER008011");
		details1.setValue("El campo apePaterno de persona en su elemento 1 con valor \\\"@@\\\" no coincide para el patrón: a-zA-ZÀ-ÿ0-9_.&'\\\" -");
		List<DetailsErrorDTO> detailsList = new ArrayList<>();
		detailsList.add(details);
		detailsList.add(details1);
		error.setDetails(detailsList);
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_APX);
		List<ErrorResponseDTO> listError = pisdR403.executeFindError(error);
		System.out.println(listError);
		Assert.assertEquals(0, context.getAdviceList().size());
		//Assert.assertEquals(2,listError.size());
		Assert.assertNotNull(listError);
	}

	@Test
	public void testErrorRimacThird(){
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("PER009002");
		details.setValue("El campo apeMaterno de persona en su elemento 1 es requerido");
		DetailsErrorDTO details1 = new DetailsErrorDTO();
		details1.setCode("PER009011");
		details1.setValue("El campo apeMaterno de persona en su elemento 1 con valor \\\"@@\\\" no coincide para el patrón: a-zA-ZÀ-ÿ0-9_.&'\\\" -");
		DetailsErrorDTO details2 = new DetailsErrorDTO();
		details2.setCode("PER005005");
		details2.setValue("El campo nroDocumento de persona en su elemento 1 debe contener 8 caracteres");
		List<DetailsErrorDTO> detailsList = new ArrayList<>();
		detailsList.add(details);
		detailsList.add(details1);
		detailsList.add(details2);
		error.setDetails(detailsList);
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_RIMAC);
		List<ErrorResponseDTO> listError = pisdR403.executeFindError(error);
		System.out.println(listError);
		Assert.assertEquals(0, context.getAdviceList().size());
		//Assert.assertEquals(3,listError.size());
		Assert.assertNotNull(listError);
	}

	@Test
	public void testErrorPersonaRimacThird(){
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("PER009004");
		details.setValue("El campo apeMaterno de persona en su elemento 1 debe contener como máximo 30 caracteres");
		DetailsErrorDTO details1 = new DetailsErrorDTO();
		details1.setCode("PER010002");
		details1.setValue("El campo nombres de persona en su elemento 1 es requerido");
		List<DetailsErrorDTO> detailsList = new ArrayList<>();
		detailsList.add(details);
		detailsList.add(details1);
		error.setDetails(detailsList);
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_RIMAC);
		List<ErrorResponseDTO> listError = pisdR403.executeFindError(error);
		System.out.println(listError);
		Assert.assertEquals(0, context.getAdviceList().size());
		//Assert.assertEquals(2,listError.size());
		Assert.assertNotNull(listError);
	}

	@Test
	public void testFiveErrorPersonaRimacThird(){
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("PER009004");
		details.setValue("El campo apeMaterno de persona en su elemento 1 debe contener como máximo 30 caracteres");
		DetailsErrorDTO details1 = new DetailsErrorDTO();
		details1.setCode("PER010002");
		details1.setValue("El campo nombres de persona en su elemento 1 es requerido");
		DetailsErrorDTO details2 = new DetailsErrorDTO();
		details2.setCode("PER005005");
		details2.setValue("El campo nroDocumento de persona en su elemento 1 debe contener 8 caracteres");
		DetailsErrorDTO details3 = new DetailsErrorDTO();
		details3.setCode("PER005011");
		details3.setValue("El campo nroDocumento de persona en su elemento 1 con valor \\\"@\\\" no coincide para el patrón: 0-9");
		DetailsErrorDTO details4 = new DetailsErrorDTO();
		details4.setCode("PER005004");
		details4.setValue("El campo nroDocumento de persona en su elemento 1 debe contener como máximo 11 caracteres");
		List<DetailsErrorDTO> detailsList = new ArrayList<>();
		detailsList.add(details);
		detailsList.add(details1);
		detailsList.add(details2);
		detailsList.add(details3);
		detailsList.add(details4);
		error.setDetails(detailsList);
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_RIMAC);
		List<ErrorResponseDTO> listError = pisdR403.executeFindError(error);
		System.out.println(listError);
		Assert.assertEquals(0, context.getAdviceList().size());
		//Assert.assertEquals(2,listError.size());
		Assert.assertNotNull(listError);
	}
	@Test
	public void testOneErrorPersonaRimacThird(){
		ErrorRequestDTO error = new ErrorRequestDTO();
		error.setChannel("PIC");
		DetailsErrorDTO details = new DetailsErrorDTO();
		details.setCode("PER005005");
		details.setValue("El campo nroDocumento de persona en su elemento 1 debe contener 8 caracteres");
		List<DetailsErrorDTO> detailsList = new ArrayList<>();
		detailsList.add(details);
		error.setDetails(detailsList);
		error.setHttpCode(409L);
		error.setTypeErrorScope(Constants.ErrorType.ERROR_RIMAC);
		List<ErrorResponseDTO> listError = pisdR403.executeFindError(error);
		System.out.println(listError);
		Assert.assertEquals(0, context.getAdviceList().size());
		//Assert.assertEquals(2,listError.size());
		Assert.assertNotNull(listError);
	}

}
