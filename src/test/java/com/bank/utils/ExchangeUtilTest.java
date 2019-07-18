package com.bank.utils;

import java.net.URISyntaxException;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExchangeUtilTest extends CamelSpringTestSupport {
   
	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("application-config.xml");
	}
	
	@Test
	public void testGetQueryParameterDefaultValue() throws URISyntaxException {
		Exchange request = createExchangeWithBody("");
		assertEquals("000", ExchangeUtil.getQueryParameter(request, "Test Body", "000"));
	}
	
	@Test
	public void testGetQueryParameter() throws URISyntaxException {
		Exchange request = createExchangeWithBody("");
		request.getIn().setHeader(Exchange.HTTP_QUERY, "accountId=200");
		assertEquals("200", ExchangeUtil.getQueryParameter(request, "accountId", "000"));
	}
	@Test
	public void testCreateResponse() throws Exception {
		Exchange request = createExchangeWithBody("");
		ExchangeUtil.createResponse(request, "Test Body", 200);
		assertEquals(request.getOut().getHeader("CamelHttpResponseCode"), 200);
		System.out.println(request.getOut().getBody());
		assertEquals("\"Test Body\"", request.getOut().getBody());
	}
	
	@Test
	public void testConvertToJson() {
		assertNull(ExchangeUtil.convertToJson(null));
	}
	
	@Test
	public void testConvertToPojoNull() throws Exception {
		assertNull(ExchangeUtil.convertToPojo(null));
	}

}
