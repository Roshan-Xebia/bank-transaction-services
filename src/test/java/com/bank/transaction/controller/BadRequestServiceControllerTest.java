package com.bank.transaction.controller;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BadRequestServiceControllerTest  extends CamelSpringTestSupport {

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("application-config.xml");
	}
	
	@Test
	public void testProcess() 
	   throws Exception {
		Exchange request = createExchangeWithBody("Call badRequestService");
		template.send("direct:/badRequestService", request);
		assertEquals("\"Bad Request, please provide correct input!\"", request.getOut().getBody());
		assertEquals(400,request.getOut().getHeader("CamelHttpResponseCode"));
	}

}