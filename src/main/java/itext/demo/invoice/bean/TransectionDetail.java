package itext.demo.invoice.bean;

import lombok.Data;


public class TransectionDetail {

	private String date;
	private String transections;
	private String amount;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransections() {
		return transections;
	}
	public void setTransections(String transections) {
		this.transections = transections;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
