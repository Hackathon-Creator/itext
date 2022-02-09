package itext.demo.invoice.bean;

import lombok.Data;


public class InvoiceDetails {

	CandidateDetail candidateDetail; 
	BillDetail BillDetail;
	TransectionDetail transectionDetail;
	BillSummery billSummery;
	public CandidateDetail getCandidateDetail() {
		return candidateDetail;
	}
	public void setCandidateDetail(CandidateDetail candidateDetail) {
		this.candidateDetail = candidateDetail;
	}
	public BillDetail getBillDetail() {
		return BillDetail;
	}
	public void setBillDetail(BillDetail billDetail) {
		BillDetail = billDetail;
	}
	public TransectionDetail getTransectionDetail() {
		return transectionDetail;
	}
	public void setTransectionDetail(TransectionDetail transectionDetail) {
		this.transectionDetail = transectionDetail;
	}
	public BillSummery getBillSummery() {
		return billSummery;
	}
	public void setBillSummery(BillSummery billSummery) {
		this.billSummery = billSummery;
	}
	
}
