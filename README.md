Microservice for generate pdf file using with iText

The samples are all completely independent and self-contained. You can analyse them to get an understanding of how a particular method works, or you can use the snippets as a starting point for your own project.

Requirement
1. IDE (STS, Eclipse, Intellij etc.)
2. Maven
3. JDK 1.8

Import below two depedancy 

	<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>itext7-core</artifactId>
    <version>7.1.6</version>
    <type>pom</type>
  </dependency>
  <dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>itextpdf</artifactId>
    <version>5.5.13.2</version>
</dependency>

How to run this project
1. Do maven clean install
2. Run project (ItextSampleApplication.java)
How to generate pdf or How to use
 http://localhost:8082/index.html
 
 
API:
@RequestMapping(value = "/getInvoice",method = RequestMethod.GET,produces = "application/pdf",headers="Accept=*/*")
	public ResponseEntity<InputStreamResource>  getInvoice() throws FileNotFoundException 

Main Method
Invoice.getInvoice
You will get one html page and once you click generate button then your invoice will generate

Reference
1.	https://itextpdf.com/en
2.	https://kb.itextpdf.com/  
3.	installation-guidelines - https://kb.itextpdf.com/home/it7kb/installation-guidelines 
