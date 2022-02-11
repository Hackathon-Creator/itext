package itext.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import itext.demo.invoice.Invoice;

@RestController
public class InvoiceController {
	
	@Autowired
	Invoice invoice;
	
	
	@RequestMapping(value = "/getInvoice",method = RequestMethod.GET,produces = "application/pdf",headers="Accept=*/*")
	public ResponseEntity<InputStreamResource>  getInvoice() throws FileNotFoundException, DocumentException {
		 
		invoice.getInvoice();
		File file = new File("src/main/resources/invoice/Invoice.pdf"); // change to relative path
		InputStream inputStream = new FileInputStream(file);
		 HttpHeaders responseHeaders = new HttpHeaders();
	        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
//	        responseHeaders.setContentLength(contentLengthOfStream);
	        responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
	        // just in case you need to support browsers
	        responseHeaders.put("Content-Disposition", Collections.singletonList("attachment; filename=somefile.pdf"));
	        return new ResponseEntity<InputStreamResource> (inputStreamResource,
	                                   responseHeaders,
	                                   HttpStatus.OK);
	}

}
