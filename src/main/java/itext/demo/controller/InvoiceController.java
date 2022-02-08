package itext.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import itext.demo.invoice.Invoice;

@RestController
public class InvoiceController {
	
	@Autowired
	Invoice invoice;
	@GetMapping(value = "/getInvoice")
	public String getInvoice() {
		
		return Invoice.getInvoice();
		
	}

}
