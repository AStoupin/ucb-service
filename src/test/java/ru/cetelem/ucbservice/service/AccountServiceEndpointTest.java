package ru.cetelem.ucbservice.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.cetelem.ucbservice.api.schema.*;
import ru.cetelem.ucbservice.config.TestConfig;

;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class AccountServiceEndpointTest {
	
	@Autowired
	@Qualifier("ucbServiceClient")
	private UcbService ucbServiceClient;
	private InvokeRequest ucbServiceInvokeRequest;
	
	@Before
	public void setUp() throws Exception {
		
		ObjectFactory objectFactory = new ObjectFactory();
		ucbServiceInvokeRequest = objectFactory.createInvokeRequest();
		ucbServiceInvokeRequest.setUcbInvokeModeCode(UcbInvokeModeCode.ONLINE);
		ucbServiceInvokeRequest.setCreditBureauRequest(objectFactory.createCreditBureauRequest());
		//ucbServiceInvokeRequest.
	}

	@Test
	public void testGetAccountDetails() throws Exception {
		
		InvokeResponse response = ucbServiceClient.invoke(ucbServiceInvokeRequest);
		assertTrue(response.getOut()!= null);
		/*assertTrue(response.getAccountDetails().getAccountNumber().equals("12345"));
		assertTrue(response.getAccountDetails().getAccountName().equals("Joe Bloggs"));
		assertTrue(response.getAccountDetails().getAccountBalance() == 3400);
		assertTrue(response.getAccountDetails().getAccountStatus().equals(EnumAccountStatus.ACTIVE));*/
	}

}