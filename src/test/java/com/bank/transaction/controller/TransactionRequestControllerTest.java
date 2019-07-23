package com.bank.transaction.controller;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionRequestControllerTest  extends CamelSpringTestSupport {

	TransactionRequestController requestController = new TransactionRequestController();
	Exchange request = createExchangeWithBody("");
	
	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("application-config.xml");
	}
	
	@Test
	public void testProcessInvalidAccountId() throws Exception {
		request.getIn().setHeader("CamelHttpQuery","accountId=");
		requestController.process(request);
		assertEquals("{\"statusCode\":422,\"message\":\"Invalid account id.\"}", request.getOut().getBody());
	}
	
	@Test
	public void testProcess() throws Exception {
		request.getIn().setHeader("CamelHttpQuery","accountId=test");
		requestController.process(request);
		assertEquals("test", request.getOut().getHeader("accountId"));
	}
}
