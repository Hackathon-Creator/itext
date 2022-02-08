package itext.demo.invoice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import itext.demo.invoice.bean.BillDetail;
import itext.demo.invoice.bean.BillSummery;
import itext.demo.invoice.bean.CandidateDetail;
import itext.demo.invoice.bean.TransectionDetail;
import itextt.demo.simple.Employee;

public class Invoice {
  public static final String CREATED_PDF = "src/main/resources/invoice/Invoice.pdf";
  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<Employee>();
    employees.add(new Employee("Jack", "HR", 12000));
    employees.add(new Employee("Liza", "IT", 5000));
    employees.add(new Employee("Jeremy", "Finance", 9000));
    employees.add(new Employee("Frederick", "Accounts", 8000));
    try {
      PdfDocument pdf = new PdfDocument(new PdfWriter(CREATED_PDF));
      Document document = new Document(pdf);
      PdfFont headerFont = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
      PdfFont cellFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
      
      String para3 = "INVOICE";
      Paragraph paragraph3 = new Paragraph(para3).setTextAlignment(TextAlignment.RIGHT); 
      document.add(paragraph3);
      String para4 = "510-06";
      Paragraph paragraph4 = new Paragraph(para4).setFontSize(7).setTextAlignment(TextAlignment.RIGHT); 
      document.add(paragraph4);
      
      Table outer = new Table(2);
      
//      String para1 = "PAYMENT DUE UPON RECEIPT";
      String para2 = "To Ensure propeer credit to your account, enter the amount of any credit vouncher, the amount enclosed or credit card"
      		+ " information and return this portion of the invoice and your remittance for";
//      Paragraph paragraph1 = new Paragraph(para1).setWidth(250).setFontSize(10).setWidth(UnitValue.createPercentValue(50));             
      Paragraph paragraph2 = new Paragraph(para2).setWidth(UnitValue.createPercentValue(50)).setFontSize(7);    
//      document.add(paragraph1);
//      document.add(paragraph2);
      Table table5 = new Table(1);
      table5.addCell(getCell("PAYMENT DUE UPON RECEIPT", TextAlignment.LEFT));
      table5.addCell(getCell(para2, TextAlignment.LEFT)).setFontSize(7);
      outer.addCell(table5);
      
      Table innerOuter = new Table(1);
      
      Table table = new Table(2);
//      table.setMarginBottom(10);
//      table.setWidth(UnitValue.createPercentValue(50));
      table.setHorizontalAlignment(HorizontalAlignment.CENTER);
      // adding header
//      table.addHeaderCell(new Cell(1, 2)
//           .setTextAlignment(TextAlignment.CENTER)
//          
//           .add(new Paragraph("INVOICE")
//           .setFont(headerFont)));
    
     
     
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
      billDetail.setBillAmount("60");
      billDetail.setMinusCreditVoucher("");
      billDetail.setDueAmount("60");
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Bill Amount:")));
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("$__________"+billDetail.getBillAmount())).setUnderline());
      
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Minus Enclosed credit voucher(s):")));
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("$____________"+billDetail.getMinusCreditVoucher())).setUnderline());
      
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(" Amount Due:")));
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("$__________"+billDetail.getDueAmount())).setUnderline());
      
//      Table cashTb=new Table(2);
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Make your remittanc payable to")).setTextAlignment(TextAlignment.CENTER)).setFontSize(7);
      table1.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("the Praxis Series. DO NOT SEND CASH")).setTextAlignment(TextAlignment.CENTER)).setFontSize(7);
//      table1.addCell(cashTb);
 
      
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
      Table transTable = new Table(3).useAllAvailableWidth().setHeight(400);
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
         document.add(new Paragraph("Copyright © 2022 by Educational Testing Service. All rights reserved. ETS, the ETS logos, MEASURING THE POWER OF LEARNING and GRE are registered trademarks of Educational Testing Service (ETS) in the United States and other countries").setFontSize(6));

      document.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }  
  }
public static Cell getCell(String text, TextAlignment alignment) {
    Cell cell = new Cell().add(new Paragraph(text));
    cell.setPadding(0);
    cell.setTextAlignment(alignment);
    cell.setBorder(Border.NO_BORDER);
    return cell;
}
}