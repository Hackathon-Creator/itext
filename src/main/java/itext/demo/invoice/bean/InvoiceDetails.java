package itext.demo.invoice.bean;

import lombok.Data;

@Data
public class InvoiceDetails {

	CandidateDetail candidateDetail; 
	BillDetail BillDetail;
	TransectionDetail transectionDetail;
	BillSummery billSummery;
}
