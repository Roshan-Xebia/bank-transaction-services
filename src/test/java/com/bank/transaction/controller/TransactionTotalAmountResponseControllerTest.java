package com.bank.transaction.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.camel.Exchange;
import org.apache.camel.component.http.HttpOperationFailedException;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
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
		String content = new String(Files.readAllBytes(Paths.get("src\\test\\resources\\transactionsJson.txt")), "UTF-8");
		Exchange request = createExchangeWithBody(content);
		request.setProperty("transType", "SANDBOX_TAN");
		responseController.process(request);
		assertEquals("10.0", request.getOut().getBody());
	}

	@Ignore
	@Test
	public void testProcess() {
		Exchange request = createExchangeWithBody("");
		template.send("http://localhost:8081/bank-transaction-services/rs/v1/current-accounts/transaction/total-amount?transType=SANDBOX_TAN&accountId=savings-kids-john", request);
		assertEquals(200,request.getOut().getHeader("CamelHttpResponseCode"));
		assertNotNull(request.getOut().getBody());
	}
	
	@Ignore
	@Test
	public void testProcessException() {
		Exchange request = createExchangeWithBody("");
		template.send("http://localhost:8081/bank-transaction-services/rs/v1/current-accounts/transaction/total-amount?transType=SANDBOX_TAN", request);
		assertNull(request.getOut().getBody());
		assertEquals(HttpOperationFailedException.class, request.getException().getClass());
	}
}