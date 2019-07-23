package com.bank.transaction.controller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bank.model.ErrorResponse;
import com.bank.utils.ExchangeUtil;

/**
 * Get all transaction by account id request from process open bank
 * @author Roshan
 *
 */
@Component
public class TransactionRequestController implements Processor {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionRequestController.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		try {
			String accountId = ExchangeUtil.getQueryParameter(exchange, "accountId", null);
			if (accountId == null || accountId.isEmpty()) {
				LOGGER.error("TransactionRequestController: Invalid account id ");
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setStatusCode(422);
				errorResponse.setMessage("Invalid account id.");
				ExchangeUtil.createResponse(exchange, errorResponse, 422);
				exchange.getOut().setHeader("accountId", "N");
			} else {
				exchange.getOut().setHeader("accountId", accountId);
				exchange.getOut().setHeader("current-accounts-transactions-openbank", accountId);
			}
		}catch (Exception e) {
			exchange.getOut().setHeader("sysoutser", "Y");
			ExchangeUtil.createResponse(exchange, "System out of service", 500);
		}	
	}
}
