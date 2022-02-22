package itext.demo.invoice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;

import itext.demo.invoice.bean.BillDetail;
import itext.demo.invoice.bean.BillSummery;
import itext.demo.invoice.bean.CandidateDetail;
import itext.demo.invoice.bean.TransectionDetail;

@Service
public class Invoice {
  public static final String CREATED_PDF = "src/main/resources/invoice/Invoice.pdf";
  public static final String LOGO = "src/main/resources/ets.png";
  public static String getInvoice() throws DocumentException{
  
    try {
    	// Create new pdf file 
      PdfDocument pdf = new PdfDocument(new PdfWriter(CREATED_PDF));
      Document document = new Document(pdf);
     
      PdfFont headerFont = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
      PdfFont cellFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
      
      String para3 = "THIRD INVOICE";
      Paragraph paragraph3 = new Paragraph(para3).setTextAlignment(TextAlignment.RIGHT); 
      document.add(paragraph3);
      String para4 = "510-06";
      Paragraph paragraph4 = new Paragraph(para4).setFontSize(7).setTextAlignment(TextAlignment.RIGHT); 
      document.add(paragraph4);
      
      Table outer = new Table(2);
      
//      String para1 = "PAYMENT DUE UPON RECEIPT";
      String para2 = "To Ensure propeer credit to your account, enter the amount of any credit vouncher, the amount enclosed or credit card"
      		+ " information and return this portion of the invoice and your remittance for";
      
      String address = "\n ETS-Toaching & Learning Division \n P.O Box 6051 \n Princeton, NJ 08541-6051";
//      Paragraph paragraph1 = new Paragraph(para1).setWidth(250).setFontSize(10).setWidth(UnitValue.createPercentValue(50));             
      Paragraph paragraph2 = new Paragraph(para2).setWidth(UnitValue.createPercentValue(50)).setFontSize(7);    
//      document.add(paragraph1);
//      document.add(paragraph2);
      Table table5 = new Table(1);
      table5.addCell(getCell("PAYMENT DUE UPON RECEIPT", TextAlignment.LEFT));
      table5.addCell(getCell(para2, TextAlignment.LEFT)).setFontSize(7);
      table5.addCell(getCell(address, TextAlignment.CENTER)).setFontSize(7);
      outer.addCell(table5);
      
      Table innerOuter = new Table(1);
      
      Table table = new Table(2);
      table.setHorizontalAlignment(HorizontalAlignment.CENTER);
     
      table.addHeaderCell(new Cell()
           .add(new Paragraph("Candidate ID Number")
           .setFont(headerFont)) .setBackgroundColor(ColorConstants.LIGHT_GRAY));
      table.addHeaderCell(new Cell()
           .add(new Paragraph("Invoice Date")
           .setFont(headerFont)) .setBackgroundColor(ColorConstants.LIGHT_GRAY));

//      fill candidateDetail
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      CandidateDetail candidateDetail = new CandidateDetail();
      candidateDetail.setCandidateId("11419270");
      candidateDetail.setInvoiceDate(dateFormat.format(new Date()));
      
      table.addCell(new Cell().add(new Paragraph(candidateDetail.getCandidateId()).setFont(cellFont).setTextAlignment(TextAlignment.CENTER))).setTextAlignment(TextAlignment.CENTER);
      table.addCell(new Cell().add(new Paragraph(candidateDetail.getInvoiceDate()).setFont(cellFont).setTextAlignment(TextAlignment.CENTER))).setTextAlignment(TextAlignment.CENTER);
      innerOuter.addCell(table);
      
//      BillDetail Details 
      Table table1 = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
      table1.setMarginTop(10);
      table1.setBorder(new SolidBorder(1));
//      table1.setWidth(UnitValue.createPercentValue(50));
      table1.setHorizontalAlignment(HorizontalAlignment.RIGHT);
//      table1.setBorder(0);
      BillDetail billDetail = new BillDetail();
      billDetail.setBillAmount("60.00");
      billDetail.setMinusCreditVoucher("");
      billDetail.setDueAmount("60.00");
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Bill Amount:")));
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("$_________________"+billDetail.getBillAmount())).setUnderline());
      
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Minus Enclosed credit voucher(s):")));
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("$_____________________"+billDetail.getMinusCreditVoucher())).setUnderline());
      
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(" Amount Due:")));
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("$_________________"+billDetail.getDueAmount())).setUnderline());
      
//      Table cashTb=new Table(2);
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Make your remittanc payable to")).setTextAlignment(TextAlignment.CENTER)).setFontSize(7);
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("the Praxis Series. DO NOT SEND CASH")).setTextAlignment(TextAlignment.CENTER)).setFontSize(7);
     
//      BaseFont base = BaseFont.createFont("C:\\Winodws\\fonts\\wingding_0.ttf", BaseFont.IDENTITY_H, false);
//      Font font = new Font(base, 16f, Font.BOLD);
//      char checked='\u00FE';
//      char unchecked='\u00A8';

     
//
////      PdfWriter.getInstance(document, new FileOutputStream(filename));
////
////      document.open();
//      // Here is how to add a checked checkbox
//      document.add(new Paragraph(String.valueOf(checked),font));
////      Here is an unchecked checkbox
//      document.add(new Paragraph(String.valueOf(unchecked)));
      
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Charge Card Account Number")).setTextAlignment(TextAlignment.LEFT)).setFontSize(7);
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Expiration Date")).setTextAlignment(TextAlignment.RIGHT)).setFontSize(7);

      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("_________________")).setTextAlignment(TextAlignment.LEFT)).setFontSize(7);
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("_________________")).setTextAlignment(TextAlignment.RIGHT)).setFontSize(7);
      
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Cardholder's Signature")).setTextAlignment(TextAlignment.LEFT)).setFontSize(7);
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("")).setTextAlignment(TextAlignment.LEFT)).setFontSize(7);

      innerOuter.addCell(table1);
      outer.addCell(innerOuter);
      document.add(outer);
      
      document.add(new Paragraph("______________________________________________________________________________")) ;
      
      Table innerTable = new Table(2);
      
      Table inner1 = new Table(1);
      inner1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(" Scores will not be released to you or your score recipients untill the amount due on this invoice, which "
      		+ " may include an outstanding balance for previous services, Is paid in full.")));
      innerTable.addCell(inner1).setFontSize(8);
      innerTable.addCell(table).setFontSize(8);
      
      document.add(innerTable);
      
      document.add(new Paragraph(" "));
//      transectionDetail
      TransectionDetail transectionDetail = new TransectionDetail();
      Table transTable = new Table(3).useAllAvailableWidth().setHeight(330);
      transTable.addHeaderCell(new Cell()
              .add(new Paragraph("Date")
              .setFont(headerFont)) .setBackgroundColor(ColorConstants.LIGHT_GRAY));
      transTable.addHeaderCell(new Cell()
              .add(new Paragraph("Transections")
              .setFont(headerFont)) .setBackgroundColor(ColorConstants.LIGHT_GRAY));

      transTable.addHeaderCell(new Cell()
                 .add(new Paragraph("Amount")
                 .setFont(headerFont)) .setBackgroundColor(ColorConstants.LIGHT_GRAY));
         
         transectionDetail.setDate(dateFormat.format(new Date()));
         transectionDetail.setTransections("FEE FOR CREDIT CARD CHARGEBACK");
         transectionDetail.setAmount("$"+"  "+ "30.00");
         
         transTable.addCell(new Cell().add(new Paragraph(transectionDetail.getDate()).setFont(cellFont).setTextAlignment(TextAlignment.CENTER))).setTextAlignment(TextAlignment.CENTER);
         transTable.addCell(new Cell().add(new Paragraph(transectionDetail.getTransections()).setFont(cellFont).setTextAlignment(TextAlignment.CENTER))).setTextAlignment(TextAlignment.CENTER);
         transTable.addCell(new Cell().add(new Paragraph(transectionDetail.getAmount()).setFont(cellFont).setTextAlignment(TextAlignment.CENTER))).setTextAlignment(TextAlignment.CENTER);
      
  
         document.add(transTable);
         document.add(new Paragraph(" "));
         
//         BillSummery
         
         BillSummery billSummery= new BillSummery();
         billSummery.setDate(dateFormat.format(new Date()));
         billSummery.setPriBalance("$"+"  "+ "30.00");
         billSummery.setNewCharge("$"+"  "+ "30.00");
         billSummery.setPaymentAdjust("$"+"  "+ "00.00");
         billSummery.setDueAmount("$"+"  "+ "60.00");
         Table footherTable = new Table(5).useAllAvailableWidth() ;
         
         footherTable.addHeaderCell(new Cell()
                 .add(new Paragraph("Date")
                 .setFont(headerFont)) .setBackgroundColor(ColorConstants.LIGHT_GRAY));
         footherTable.addHeaderCell(new Cell()
                 .add(new Paragraph("Previous Balance")
                 .setFont(headerFont)) .setBackgroundColor(ColorConstants.LIGHT_GRAY));

         footherTable.addHeaderCell(new Cell()
                    .add(new Paragraph("New Charges")
                    .setFont(headerFont)) .setBackgroundColor(ColorConstants.LIGHT_GRAY));
         footherTable.addHeaderCell(new Cell()
                 .add(new Paragraph("Payment Adjust")
                 .setFont(headerFont)) .setBackgroundColor(ColorConstants.LIGHT_GRAY));
         footherTable.addHeaderCell(new Cell()
                 .add(new Paragraph("Amount Due")
                 .setFont(headerFont)) .setBackgroundColor(ColorConstants.LIGHT_GRAY));

         footherTable.addCell(new Cell().add(new Paragraph(billSummery.getDate()).setFont(cellFont).setTextAlignment(TextAlignment.CENTER))).setTextAlignment(TextAlignment.CENTER);
         footherTable.addCell(new Cell().add(new Paragraph(billSummery.getPriBalance()).setFont(cellFont).setTextAlignment(TextAlignment.CENTER))).setTextAlignment(TextAlignment.CENTER);
         footherTable.addCell(new Cell().add(new Paragraph(billSummery.getNewCharge()).setFont(cellFont).setTextAlignment(TextAlignment.CENTER))).setTextAlignment(TextAlignment.CENTER);
      
         footherTable.addCell(new Cell().add(new Paragraph(billSummery.getPaymentAdjust()).setFont(cellFont).setTextAlignment(TextAlignment.CENTER))).setTextAlignment(TextAlignment.CENTER);
         footherTable.addCell(new Cell().add(new Paragraph(billSummery.getDueAmount()).setFont(cellFont).setTextAlignment(TextAlignment.CENTER))).setTextAlignment(TextAlignment.CENTER);
         document.add(footherTable.setFontSize(8));
      
         
         document.add(new Paragraph("______________________________________________________________________________")) ;
      // Creating an ImageData object 
//         String imageFile = "C:/itextExamples/javafxLogo.jpg"; 
//         Table buttom = new Table(2).useAllAvailableWidth() ;
         PdfPTable buttom = new PdfPTable(2);
         buttom.setWidths(new int[]{1, 2});
         ImageData data = ImageDataFactory.create(LOGO);
         Image img = new Image(data).setHeight(15).setWidth(15); 
         document.add(img);
         document.add(new Paragraph("Copyright © 2022 by Educational Testing Service. All rights reserved. ETS, the ETS logos, MEASURING THE POWER OF LEARNING and GRE are registered trademarks of Educational Testing Service (ETS) in the United States and other countries").setFontSize(6).setMarginTop(10));

      document.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }  
    return "Invoice is generated at location :- " +CREATED_PDF;
  }
public static Cell getCell(String text, TextAlignment alignment) {
    Cell cell = new Cell().add(new Paragraph(text));
    cell.setPadding(0);
    cell.setTextAlignment(alignment);
    cell.setBorder(Border.NO_BORDER);
    return cell;
}
}