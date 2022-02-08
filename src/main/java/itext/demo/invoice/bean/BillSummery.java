package itext.demo.invoice.bean;

import lombok.Data;

@Data
public class BillSummery {

	private String date;
	private String priBalance;
	private String newCharge;
	private String paymentAdjust;
	private String dueAmount;
}
