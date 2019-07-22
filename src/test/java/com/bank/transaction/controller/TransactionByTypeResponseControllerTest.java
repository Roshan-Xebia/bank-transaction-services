package com.bank.transaction.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionByTypeResponseControllerTest extends CamelSpringTestSupport {

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("application-config.xml");
	}
	
	@Test
	public void testProcess() throws Exception {
		TransactionByTypeResponseController byTypeResponseController = new TransactionByTypeResponseController();
		String content = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("transactions.json").toURI())));
		Exchange request = createExchangeWithBody(content);
		request.setProperty("transType", "SANDBOX_TAN");
		byTypeResponseController.process(request);
		assertNotSame(content, request.getOut().getBody());
	}
}
