package com.test.djackatron2.model;

public class TransferReciept {

	private String accountIdFrom;
	private String accountIdTo;
	private String totalTransferAmount;
	private String fee;
	
	public String getAccountIdFrom() {
		return accountIdFrom;
	}
	public void setAccountIdFrom(String accountIdFrom) {
		this.accountIdFrom = accountIdFrom;
	}
	public String getAccountIdTo() {
		return accountIdTo;
	}
	public void setAccountIdTo(String accountIdTo) {
		this.accountIdTo = accountIdTo;
	}
	public String getTotalTransferAmount() {
		return totalTransferAmount;
	}
	public void setTotalTransferAmount(String totalTransferAmount) {
		this.totalTransferAmount = totalTransferAmount;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	
}
