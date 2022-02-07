package itextt.demo.simple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

public class PDFWithTable {
  public static final String CREATED_PDF = "C:\\Users\\bipsr\\Desktop\\Invoice.pdf";
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
      Table table = new Table(3);
      table.setWidth(UnitValue.createPercentValue(100));
      // adding header
      table.addHeaderCell(new Cell(1, 3)
           .setTextAlignment(TextAlignment.CENTER)
           .setBackgroundColor(ColorConstants.LIGHT_GRAY)
           .add(new Paragraph("Employee Information")
           .setFont(headerFont)));
      table.addHeaderCell(new Cell()
           .add(new Paragraph("Name")
           .setFont(headerFont)));
      table.addHeaderCell(new Cell()
           .add(new Paragraph("Dept")
           .setFont(headerFont)));
      table.addHeaderCell(new Cell()
           .add(new Paragraph("Salary")
           .setFont(headerFont)));
      // adding rows
      for(Employee emp : employees) {
        table.addCell(new Cell()
             .add(new Paragraph(emp.getName())
             .setFont(cellFont)));
        table.addCell(new Cell()
             .add(new Paragraph(emp.getDept())
             .setFont(cellFont)));
        table.addCell(new Cell()
             .add(new Paragraph(Integer.toString(emp.getSalary()))
             .setFont(cellFont)));
      }
      document.add(table);
      document.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }  
  }
}