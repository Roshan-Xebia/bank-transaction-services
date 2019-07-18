package com.bank.transaction.controller;

import org.apache.camel.Exchange;
import org.apache.camel.component.http.HttpOperationFailedException;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionByTypeRequestControllerTest extends CamelSpringTestSupport {

	TransactionByTypeRequestController requestController = new TransactionByTypeRequestController();
	Exchange request = createExchangeWithBody("");
	
	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("application-config.xml");
	}
	
	@Test
	public void testProcessInvalidAccountId() throws Exception {
		request.setProperty("accountId", "");
		request.setProperty("transType", "");
		requestController.process(request);
		assertEquals("\"Invalid account id\"", request.getOut().getBody());
	}
	
	@Test
	public void testProcessInvalidTransType() throws Exception {
		request.setProperty("accountId", "test");
		request.setProperty("transType", "");
		requestController.process(request);
		assertEquals("\"Invalid account id\"", request.getOut().getBody());
	}
	
	@Ignore
	@Test
	public void testProcessWithHttp() {
		template.send("http://localhost:8081/bank-transaction-services/rs/v1/current-accounts/transactionsbytype?transType=SANDBOX_TAN&accountId=savings-kids-john", request);
		assertEquals(200,request.getOut().getHeader("CamelHttpResponseCode"));
		assertNotNull(request.getOut().getBody());
	}
	
	@Ignore
	@Test
	public void testProcessException() {
		template.send("http://localhost:8081/bank-transaction-services/rs/v1/current-accounts/transactionsbytype?transType=SANDBOX_TAN", request);
		assertNull(request.getOut().getBody());
		assertEquals(HttpOperationFailedException.class, request.getException().getClass());
	}

}
