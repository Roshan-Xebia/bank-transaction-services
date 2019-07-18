package com.bank.transaction.controller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
			if (transType == null || transType.isEmpty()) {
				LOGGER.error("Invalid transaction type ");
				ExchangeUtil.createResponse(exchange, "Invalid transaction type", 400);
				exchange.getOut().setHeader("transType", "N");
			} else {
				exchange.setProperty("transType", transType);
			}
			
			String accountId = ExchangeUtil.getQueryParameter(exchange, "accountId", null);
			if (accountId == null || accountId.isEmpty()) {
				LOGGER.error("Invalid account id");
				ExchangeUtil.createResponse(exchange, "Invalid account id", 400);
				exchange.getOut().setHeader("accountId", "N");
			} else {
				exchange.getOut().setHeader("accountId", accountId);
			}
		}catch (Exception e) {
			exchange.getOut().setHeader("sysoutser", "Y");
			ExchangeUtil.createResponse(exchange, "System out of service", 500);
		}
		
	}

}
