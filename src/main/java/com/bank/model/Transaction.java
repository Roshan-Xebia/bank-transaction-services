package com.bank.model;

public class Transaction {
	  private String id;
	  ThisAccount This_accountObject;
	  OtherAccount Other_accountObject;
	  Details DetailsObject;
	  Metadata MetadataObject;


	 // Getter Methods 

	  public String getId() {
	    return id;
	  }

	  public ThisAccount getThis_account() {
	    return This_accountObject;
	  }

	  public OtherAccount getOther_account() {
	    return Other_accountObject;
	  }

	  public Details getDetails() {
	    return DetailsObject;
	  }

	  public Metadata getMetadata() {
	    return MetadataObject;
	  }

	 // Setter Methods 

	  public void setId( String id ) {
	    this.id = id;
	  }

	  public void setThis_account( ThisAccount this_accountObject ) {
	    this.This_accountObject = this_accountObject;
	  }

	  public void setOther_account( OtherAccount other_accountObject ) {
	    this.Other_accountObject = other_accountObject;
	  }

	  public void setDetails( Details detailsObject ) {
	    this.DetailsObject = detailsObject;
	  }

	  public void setMetadata( Metadata metadataObject ) {
	    this.MetadataObject = metadataObject;
	  }
	}
	
	
	
	
	class Bank {
		  private String national_identifier;
		  private String name;


		 // Getter Methods 

		  public String getNational_identifier() {
		    return national_identifier;
		  }

		  public String getName() {
		    return name;
		  }

		 // Setter Methods 

		  public void setNational_identifier( String national_identifier ) {
		    this.national_identifier = national_identifier;
		  }

		  public void setName( String name ) {
		    this.name = name;
		  }
		}
	
	class New_balance {
	  private String currency;
	  private String amount = null;


	 // Getter Methods 

	  public String getCurrency() {
	    return currency;
	  }

	  public String getAmount() {
	    return amount;
	  }

	 // Setter Methods 

	  public void setCurrency( String currency ) {
	    this.currency = currency;
	  }

	  public void setAmount( String amount ) {
	    this.amount = amount;
	  }
	}
	
	
	
	
	
