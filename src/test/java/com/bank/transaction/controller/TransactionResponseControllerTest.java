package com.bank.transaction.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionResponseControllerTest extends CamelSpringTestSupport {

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("application-config.xml");
	}
	
	@Test
	public void testProcess() throws Exception {
		TransactionResponseController byTypeResponseController = new TransactionResponseController();
		String content = new String(Files.readAllBytes(Paths.get("src\\test\\resources\\transactionsJson.txt")), "UTF-8");
		Exchange request = createExchangeWithBody(content);
		byTypeResponseController.process(request);
		assertNotNull(request.getOut().getBody());
	}
}
