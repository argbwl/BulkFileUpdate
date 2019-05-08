package com.ab.model;

public class Bank {
	private int bankId;
	private String bankName;
	private String ifsCode;
	private int establishedYear;

	
	public Bank() {
		super();
	}

	public Bank(int bankId, String bankName, String ifsCode, int establishedYear) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.ifsCode = ifsCode;
		this.establishedYear = establishedYear;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfsCode() {
		return ifsCode;
	}

	public void setIfsCode(String ifsCode) {
		this.ifsCode = ifsCode;
	}

	public int getEstablishedYear() {
		return establishedYear;
	}

	public void setEstablishedYear(int establishedYear) {
		this.establishedYear = establishedYear;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", ifsCode=" + ifsCode + ", establishedYear="
				+ establishedYear + "]";
	}

}
