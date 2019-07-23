package com.bank.transaction.controller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.model.ErrorResponse;
import com.bank.utils.ExchangeUtil;

/**
 * Get the transaction by transaction type request verify inputs and process
 * @author Roshan
 *
 */
public class TransactionByTypeRequestController implements Processor {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionByTypeRequestController.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		try {
			String transType = ExchangeUtil.getQueryParameter(exchange, "transType", null);
			String accountId = ExchangeUtil.getQueryParameter(exchange, "accountId", null);
			if (transType == null || transType.isEmpty()) {
				LOGGER.error("TransactionByTypeRequestController: Invalid transaction type ");
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setStatusCode(422);
				errorResponse.setMessage("Invalid transaction type.");
				ExchangeUtil.createResponse(exchange, errorResponse, 422);
				exchange.getOut().setHeader("transType", "N");
			} else if (accountId == null || accountId.isEmpty()) {
				LOGGER.error("TransactionByTypeRequestController: Invalid account id");
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setStatusCode(422);
				errorResponse.setMessage("Invalid account id.");
				ExchangeUtil.createResponse(exchange, errorResponse, 422);
				exchange.getOut().setHeader("accountId", "N");
			} else {
				exchange.setProperty("transType", transType);
				exchange.getOut().setHeader("accountId", accountId);
			}
		}catch (Exception e) {
			exchange.getOut().setHeader("sysoutser", "Y");
			ExchangeUtil.createResponse(exchange, "System out of service", 500);
		}
	}
}
