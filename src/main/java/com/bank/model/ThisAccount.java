package com.bank.model;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

public @JsonIgnoreProperties(ignoreUnknown = true)
class ThisAccount {
	  private String id;
	  private ArrayList<Holder> holders = new ArrayList<Holder>();
	  private String number;
	  private String kind;
	  private String IBAN = null;
	  private String swift_bic = null;
	  private Bank BankObject;


	 // Getter Methods 

	  public String getId() {
	    return id;
	  }

	  public String getNumber() {
	    return number;
	  }

	  public String getKind() {
	    return kind;
	  }

	  public String getIBAN() {
	    return IBAN;
	  }

	  public String getSwift_bic() {
	    return swift_bic;
	  }

	  public Bank getBank() {
	    return BankObject;
	  }

	 // Setter Methods 

	  public void setId( String id ) {
	    this.id = id;
	  }

	  public void setNumber( String number ) {
	    this.number = number;
	  }

	  public void setKind( String kind ) {
	    this.kind = kind;
	  }

	  public void setIBAN( String IBAN ) {
	    this.IBAN = IBAN;
	  }

	  public void setSwift_bic( String swift_bic ) {
	    this.swift_bic = swift_bic;
	  }

	  public void setBank( Bank bankObject ) {
	    this.BankObject = bankObject;
	  }

	public ArrayList<Holder> getHolders() {
		return holders;
	}

	public void setHolders(ArrayList<Holder> holders) {
		this.holders = holders;
	}
	}
