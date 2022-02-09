package itext.demo.invoice.bean;

import lombok.Data;


public class BillSummery {

	private String date;
	private String priBalance;
	private String newCharge;
	private String paymentAdjust;
	private String dueAmount;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPriBalance() {
		return priBalance;
	}
	public void setPriBalance(String priBalance) {
		this.priBalance = priBalance;
	}
	public String getNewCharge() {
		return newCharge;
	}
	public void setNewCharge(String newCharge) {
		this.newCharge = newCharge;
	}
	public String getPaymentAdjust() {
		return paymentAdjust;
	}
	public void setPaymentAdjust(String paymentAdjust) {
		this.paymentAdjust = paymentAdjust;
	}
	public String getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}
	
	
}
