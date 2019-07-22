package com.bank.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bank.model.Details;
import com.bank.model.Holder;
import com.bank.model.Metadata;
import com.bank.model.OtherAccount;
import com.bank.model.ThisAccount;
import com.bank.model.Transaction;
import com.bank.model.TransactionDTO;
import com.bank.model.Transactions;
import com.bank.model.Value;
/**
 * Mapper class transactions to transaction DTO
 * and provide filter on transaction type
 * @author Roshan
 */
public class TransactionToTransactionDTOMapper {
	public static List<TransactionDTO> buildTransactionDTOList(Transactions transactions) {
		 TransactionDTO transactionDTO = null;
		 ThisAccount thisAccount = null;
		 OtherAccount otherAccount = null;
		 Holder holder = null;
		 Metadata metadata = null;
		 ArrayList<Object> images = null;
		 Details details = null;
		 Value value = null;
		 
		 List<TransactionDTO> transactionDTOList = new ArrayList<>();
		 for(Transaction transaction : transactions.getTransactions()) {
			 
			 thisAccount = transaction.getThis_account();
			 otherAccount = transaction.getOther_account();
			 details = transaction.getDetails();
			 
			 transactionDTO = new TransactionDTO();
			 transactionDTO.setId(transaction.getId());
			 if(isNotNull(thisAccount)) {
				 transactionDTO.setAccountId(thisAccount.getNumber()); 
			 }
			 if(isNotNull(otherAccount)) {
				 transactionDTO.setCounterpartyAccount(otherAccount.getNumber());
				 holder = otherAccount.getHolder();
				 transactionDTO.setCounterpartyName(isNotNull(holder) ? holder.getName() : "");
				 metadata = otherAccount.getMetadata();
				 images = isNotNull(metadata) ? metadata.getImages() : null;
				 transactionDTO.setCounterPartyLogoPath(isNotNull(images) ? isNotNull(images.get(0)) ? images.get(0).toString() : "" : ""); 
			 }
			 if(isNotNull(details)) {
				 value = transaction.getDetails().getValue();
				 if(isNotNull(value)) {
					 transactionDTO.setInstructedAmount(value.getAmount());
					 transactionDTO.setInstructedCurrency(value.getCurrency());
					 transactionDTO.setTransactionAmount(isNotNull(value.getAmount())? value.getAmount() : "0.0d" );
					 transactionDTO.setTransactionCurrency(value.getCurrency());
				 }
				 transactionDTO.setTransactionType(transaction.getDetails().getType());
				 transactionDTO.setDescription(transaction.getDetails().getDescription());
			 }
			 transactionDTOList.add(transactionDTO);
		}
		return transactionDTOList;
	 }
	
	 public static List<TransactionDTO> filterTransactionByTranType(List<TransactionDTO> transactionDTOList, String transType){
		 if(isNotNull(transType)) {
			 transactionDTOList = transactionDTOList.stream()    
		                .filter(str -> transType.equalsIgnoreCase(str.getTransactionType()))   
		                .collect(Collectors.toList()); 
		 }
		 return transactionDTOList;
	 }
	 
	 public static boolean isNotNull(Object obj) {
		 return obj != null;
	 }
}
