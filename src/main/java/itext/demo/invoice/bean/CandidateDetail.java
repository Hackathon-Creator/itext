package itext.demo.invoice.bean;

import lombok.Data;


public class CandidateDetail {
	
	private String candidateId;
	private String invoiceDate;
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	

}
