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
 * To get the total amount of transaction 
 * @author Roshan
 *
 */
public class TransactionTotalAmountResponseController  implements Processor{
	 private static final Logger LOGGER = LoggerFactory.getLogger(TransactionByTypeResponseController.class);
		
	@Override
	public void process(Exchange exchange) throws Exception {
		 LOGGER.debug("In TransactionResponseController >>>");
		 String responseBdy = exchange.getIn().getBody(String.class);
		 String transType = exchange.getProperty("transType").toString();
		 Transactions transactions=ExchangeUtil.convertToPojo(responseBdy);
		 List<TransactionDTO> transactionDTOList = TransactionToTransactionDTOMapper.buildTransactionDTOList(transactions);
		 
		Double totalAmout = (double) transactionDTOList.stream()    
	                .filter(str -> transType.equalsIgnoreCase(str.getTransactionType()))   
	                .mapToDouble(o -> new Double(o.getTransactionAmount())).sum();
	                 
		ExchangeUtil.createResponse(exchange, totalAmout, 200);
	}
}