package com.bank.model;

public class Details {
	  private String type;
	  private String description;
	  private String posted;
	  private String completed;
	  New_balance New_balanceObject;
	  Value ValueObject;


	 // Getter Methods 

	  public String getType() {
	    return type;
	  }

	  public String getDescription() {
	    return description;
	  }

	  public String getPosted() {
	    return posted;
	  }

	  public String getCompleted() {
	    return completed;
	  }

	  public New_balance getNew_balance() {
	    return New_balanceObject;
	  }

	  public Value getValue() {
	    return ValueObject;
	  }

	 // Setter Methods 

	  public void setType( String type ) {
	    this.type = type;
	  }

	  public void setDescription( String description ) {
	    this.description = description;
	  }

	  public void setPosted( String posted ) {
	    this.posted = posted;
	  }

	  public void setCompleted( String completed ) {
	    this.completed = completed;
	  }

	  public void setNew_balance( New_balance new_balanceObject ) {
	    this.New_balanceObject = new_balanceObject;
	  }

	  public void setValue( Value valueObject ) {
	    this.ValueObject = valueObject;
	  }
	}
