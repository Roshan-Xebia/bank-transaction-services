package com.bank.transaction.controller;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.mapper.TransactionToTransactionDTOMapper;
import com.bank.model.TransactionDTO;
import com.bank.model.Transactions;
import com.bank.utils.ExchangeUtil;

/**
 * Response to get all transaction by account id request from process open bank data
 * @author Roshan
 *
 */
public class TransactionResponseController implements Processor{
	 private static final Logger LOGGER = LoggerFactory.getLogger(TransactionResponseController.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		 LOGGER.debug("In TransactionResponseController >>>");
		 try {
			 String responseBdy = exchange.getIn().getBody(String.class);
			 Transactions transactions=ExchangeUtil.convertToPojo(responseBdy);
			 List<TransactionDTO> transactionDTOList = TransactionToTransactionDTOMapper.buildTransactionDTOList(transactions);
			 ExchangeUtil.createResponse(exchange, transactionDTOList, 200);
		 }catch (Exception e) {
			 exchange.getOut().setHeader("sysoutser", "Y");
			 ExchangeUtil.createResponse(exchange, "System out of service", 404);
		}
	}
}
