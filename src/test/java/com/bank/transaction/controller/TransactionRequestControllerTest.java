package com.bank.transaction.controller;

import org.apache.camel.Exchange;
import org.apache.camel.component.http.HttpOperationFailedException;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionRequestControllerTest  extends CamelSpringTestSupport {

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("application-config.xml");
	}
	@Ignore
	@Test
	public void testProcess() {
		Exchange request = createExchangeWithBody("");
		template.send("http://localhost:8081/bank-transaction-services/rs/v1/current-accounts/transactions?accountId=savings-kids-john", request);
		assertEquals(200,request.getOut().getHeader("CamelHttpResponseCode"));
		assertNotNull(request.getOut().getBody());
	}
	
	@Ignore
	@Test
	public void testProcessException() {
		Exchange request = createExchangeWithBody("");
		template.send("http://localhost:8081/bank-transaction-services/rs/v1/current-accounts/transactions", request);
		assertNull(request.getOut().getBody());
		assertEquals(HttpOperationFailedException.class, request.getException().getClass());
	}

}
