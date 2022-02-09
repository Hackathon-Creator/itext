package itext.demo.invoice.bean;

import lombok.Data;


public class BillDetail {

	private String billAmount;
	private String minusCreditVoucher;
	private String dueAmount;
	private String paymentEnclosed;
	private String visa;
	private String masterCard;
	
	private String chargecardAccountNumber;

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	public String getMinusCreditVoucher() {
		return minusCreditVoucher;
	}

	public void setMinusCreditVoucher(String minusCreditVoucher) {
		this.minusCreditVoucher = minusCreditVoucher;
	}

	public String getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getPaymentEnclosed() {
		return paymentEnclosed;
	}

	public void setPaymentEnclosed(String paymentEnclosed) {
		this.paymentEnclosed = paymentEnclosed;
	}

	public String getVisa() {
		return visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public String getMasterCard() {
		return masterCard;
	}

	public void setMasterCard(String masterCard) {
		this.masterCard = masterCard;
	}

	public String getChargecardAccountNumber() {
		return chargecardAccountNumber;
	}

	public void setChargecardAccountNumber(String chargecardAccountNumber) {
		this.chargecardAccountNumber = chargecardAccountNumber;
	}
	
	
	
}
