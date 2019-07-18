package com.bank.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OtherAccount {
  private String id;
  Holder HolderObject;
  private String number;
  private String kind = null;
  private String IBAN = null;
  private String swift_bic = null;
  Bank BankObject;
  Metadata MetadataObject;


 // Getter Methods 

  public String getId() {
    return id;
  }

  public Holder getHolder() {
    return HolderObject;
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

  public Metadata getMetadata() {
    return MetadataObject;
  }

 // Setter Methods 

  public void setId( String id ) {
    this.id = id;
  }

  public void setHolder( Holder holderObject ) {
    this.HolderObject = holderObject;
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

  public void setMetadata( Metadata metadataObject ) {
    this.MetadataObject = metadataObject;
  }
}