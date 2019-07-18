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
 * Response to get transaction by transaction type request to provide 
 * processed open bank transaction data for requested account id and transaction type
 * @author Roshan
 *
 */
public class TransactionByTypeResponseController implements Processor {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionByTypeResponseController.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.debug("In TransactionResponseController >>>");
		String responseBdy = exchange.getIn().getBody(String.class);
		
		String transType = exchange.getProperty("transType").toString();
		Transactions transactions = ExchangeUtil.convertToPojo(responseBdy);
		List<TransactionDTO> transactionDTOList = TransactionToTransactionDTOMapper.buildTransactionDTOList(transactions);
		transactionDTOList = TransactionToTransactionDTOMapper.filterTransactionByTranType(transactionDTOList, transType);
		ExchangeUtil.createResponse(exchange, transactionDTOList, 200);
	}
}
