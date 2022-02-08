package itext.demo.invoice.bean;

import lombok.Data;

@Data
public class BillDetail {

	private String billAmount;
	private String minusCreditVoucher;
	private String dueAmount;
	private String paymentEnclosed;
	private String visa;
	private String masterCard;
	
	private String chargecardAccountNumber;
	
}
