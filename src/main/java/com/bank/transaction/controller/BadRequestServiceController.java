package com.bank.transaction.controller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.model.ErrorResponse;
import com.bank.utils.ExchangeUtil;
/**
 * Handle the bad request
 * @author Roshan
 *
 */
public class BadRequestServiceController  implements Processor{
	 private static final Logger LOGGER = LoggerFactory.getLogger(BadRequestServiceController.class);
		
	@Override
	public void process(Exchange exchange) throws Exception {
		 LOGGER.debug("In BadRequestServiceController >>>");
		 try {
			 ErrorResponse errorResponse = new ErrorResponse();
			 errorResponse.setStatusCode(422);
			 errorResponse.setMessage("Invalid accountId.");
			 ExchangeUtil.createResponse(exchange, errorResponse, 422);
		 }catch (Exception e) {
			 exchange.getOut().setHeader("sysoutser", "Y");
			 ExchangeUtil.createResponse(exchange, "System out of service", 500);
		}
	}
}
