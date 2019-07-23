package com.bank.transaction.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTotalAmountResponseControllerTest extends CamelSpringTestSupport {

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("application-config.xml");
	}
	
	@Test
	public void testProcessTotalAmount() throws Exception {
		TransactionTotalAmountResponseController responseController = new TransactionTotalAmountResponseController();
		String content = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("transactions.json").toURI())));
		Exchange request = createExchangeWithBody(content);
		request.setProperty("transType", "SANDBOX_TAN");
		responseController.process(request);
		assertEquals("{\"totalAmount\":10.0}", request.getOut().getBody());
	}
}
