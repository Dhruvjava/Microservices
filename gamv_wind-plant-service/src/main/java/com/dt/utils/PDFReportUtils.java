package com.dt.utils;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.net.URL;

@Slf4j
public class PDFReportUtils {

    private static final String IMAGES_PATH = "classpath:/images/<FILE_NAME>";

    private static final String DOC_CONTENT_TYPE = "application/msword";

    public static URL getLogoURL(String path) {

        if (log.isDebugEnabled()) {
            log.debug("Executing getLogoURL(path) ->");
        }

        try {
            PathMatchingResourcePatternResolver resolver =
                            new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource(path);
            URL url = resource.getURL();
            log.info("url====" + url);
            return url;
        } catch (Exception ex) {
            log.error("Unable to load  file -->" + path);
            throw new RuntimeException("Unable to load file -->" + path, ex);
        }
    }

    public static Image getImageElement(float fitWidth, float fitHeight, String filename) {

        if (log.isDebugEnabled()) {
            log.debug("Executing getImageElement(fitWidth, fitHeight, path) ->");
        }

        try {
            String path = IMAGES_PATH.replace("<FILE_NAME>", filename);
            ImageData imageData = ImageDataFactory.create(getLogoURL(path));
            Image image = new Image(imageData);
            Style style = new Style();
            style.setVerticalAlignment(VerticalAlignment.TOP);
            image.addStyle(style);
            image.setHorizontalAlignment(HorizontalAlignment.LEFT);
            image.scaleAbsolute(fitWidth, fitHeight);
            return image;
        } catch (Exception e) {
            log.error("Exception in getImageElement(fitWidth, fitHeight, path) - " + e);
            return null;
        }
    }

    public static void copyTo(byte[] source, PdfDocument tPdfDoc) {

        if (log.isDebugEnabled()) {
            log.debug("Executing copyTo(SourceBytes, TargetPdfDocument) ->");
        }

        try {
            if (Utils.isEmpty(source) || tPdfDoc == null) {
                return;
            }
            byte[] input = source;
            PdfReader reader = new PdfReader(new ByteArrayInputStream(input));
            PdfDocument sPdfDoc = new PdfDocument(reader);
            sPdfDoc.copyPagesTo(1, sPdfDoc.getNumberOfPages(), tPdfDoc);
            sPdfDoc.close();
            reader.close();
        } catch (Exception e) {
            log.error("Exception in copyTo(SourceBytes, TargetPdfDocument) - " + e);
        }
    }

    public static byte[] convertImageToPdf(byte[] source, String title) {

        if (log.isDebugEnabled()) {
            log.debug("Executing convertImageToPdf(SourceBytes) ->");
        }
        try {
            if (Utils.isEmpty(source)) {
                return null;
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(bos);
            PdfDocument pdfDoc = new PdfDocument(writer);
            if (Utils.isNotEmpty(title)) {
                pdfDoc.addNewPage();
                addTitle(pdfDoc, title);
            }
            Document doc = new Document(pdfDoc);
            ImageData imageData = ImageDataFactory.create(source);
            Image image = new Image(imageData);
            doc.add(image);
            doc.close();
            pdfDoc.close();
            return bos.toByteArray();
        } catch (Exception e) {
            log.error("Exception in convertImageToPdf(SourceBytes) - " + e);
            return null;
        }
    }

    public static byte[] convertTextToPdf(byte[] source, String title) {

        if (log.isDebugEnabled()) {
            log.debug("Executing convertTextToPdf(SourceBytes) ->");
        }
        try {
            if (Utils.isEmpty(source)) {
                return null;
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(bos);
            PdfDocument pdfDoc = new PdfDocument(writer);
            if (Utils.isNotEmpty(title)) {
                pdfDoc.addNewPage();
                addTitle(pdfDoc, title);
            }
            Document doc = new Document(pdfDoc);
            String text = new String(source);
            doc.add(new Paragraph(text));
            doc.close();
            pdfDoc.close();
            return bos.toByteArray();
        } catch (Exception e) {
            log.error("Exception in convertImageToPdf(SourceBytes) - " + e);
            return null;
        }
    }

    public static byte[] convertDocToPdf(byte[] source, String contentType, String title) {

        if (log.isDebugEnabled()) {
            log.debug("Executing convertDocToPdf(SourceBytes) ->");
        }
        try {
            if (Utils.isEmpty(source) || Utils.isEmpty(contentType)) {
                return null;
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            if (!DOC_CONTENT_TYPE.equals(contentType)) {
                XWPFDocument document = new XWPFDocument(new ByteArrayInputStream(source));
                bos = new ByteArrayOutputStream();
                PdfConverter.getInstance().convert(document, bos, null);
                document.close();
            } else {
                HWPFDocument hwpfDocument = new HWPFDocument(new ByteArrayInputStream(source));
                org.w3c.dom.Document document =
                                DocumentBuilderFactory.newInstance().newDocumentBuilder()
                                                .newDocument();
                WordToHtmlConverter htmlConverter = new WordToHtmlConverter(document);
                htmlConverter.processDocument(hwpfDocument);

                StringWriter stringWriter = new StringWriter();
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "no");
                transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
                transformer.setOutputProperty(OutputKeys.METHOD, "html");
                transformer.transform(new DOMSource(htmlConverter.getDocument()),
                                new StreamResult(stringWriter));
                String html = stringWriter.toString();
                bos = new ByteArrayOutputStream();
                PdfWriter pdfWriter = new PdfWriter(bos);
                PdfDocument pdf = new PdfDocument(pdfWriter);
                ConverterProperties converterProperties = new ConverterProperties();
                FontProvider fontProvider = new DefaultFontProvider(true, true, false);
                converterProperties.setFontProvider(fontProvider);
                HtmlConverter.convertToPdf(html, pdf, converterProperties);
            }
            if (Utils.isNotEmpty(title)) {
                PdfWriter pdfWriter = new PdfWriter(bos);
                PdfDocument pdfDocument = new PdfDocument(new PdfReader(
                                new ByteArrayInputStream(bos.toByteArray())), pdfWriter);
                addTitle(pdfDocument, title);
                pdfDocument.close();
            }
            return bos.toByteArray();
        } catch (Exception e) {
            log.error("Exception in convertDocToPdf(SourceBytes) - " + e);
            return null;
        }
    }

    public static void addTitle(PdfDocument pdfDocument, String title) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addTitle(PdfDocument) ->");
        }
        try {
            if (pdfDocument != null) {
                Color color = new DeviceRgb(51, 51, 51);
                PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
                PdfPage page = pdfDocument.getFirstPage();
                Rectangle pageSize = page.getPageSizeWithRotation();
                PdfCanvas pdfCanvas = new PdfCanvas(page);
                Rectangle headerRect = new Rectangle(pageSize.getX() + 36, pageSize.getTop() - 10,
                                pageSize.getWidth() - 36, 20);
                Canvas headerCanvas = new Canvas(pdfCanvas, headerRect);
                Paragraph heading = new Paragraph(title).setFont(bold).setFontColor(color)
                                .setFontSize(12);
                headerCanvas.showTextAligned(heading, (headerRect.getWidth() / 2),
                                headerRect.getTop(), 1, TextAlignment.CENTER, VerticalAlignment.TOP,
                                0);
                headerCanvas.close();
            }
        } catch (Exception e) {
            log.error("Exception in addTitle(PdfDocument) - " + e);
        }
    }

    // public static byte[] convertExcelToPdf(byte[] source) {
    //
    // if (log.isDebugEnabled()) {
    // log.debug("Executing convertExcelToPdf(SourceBytes) ->");
    // }
    // try {
    // if (Utils.isEmpty(source)) {
    // return null;
    // }
    // // Read workbook into XSSFWorkbook
    // XSSFWorkbook my_xls_workbook = new XSSFWorkbook(new ByteArrayInputStream(source));
    // int n = my_xls_workbook.getNumberOfSheets();
    // for (int i = 0; i < n; i++) {
    // XSSFSheet sheet =my_xls_workbook.getSheetAt(i);
    // int rn = sheet.getLastRowNum();
    // for (int r = 0; i < rn; i++) {
    // XSSFRow row = sheet.getRow(r);
    // if (row == null) {
    // continue;
    // }
    //
    // }
    //
    //
    //
    //
    // }
    //
    //
    //
    // // Read worksheet into HSSFSheet
    // HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
    // // To iterate over the rows
    // Iterator<Row> rowIterator = my_worksheet.iterator();
    // // We will create output PDF document objects at this point
    // Document iText_xls_2_pdf = new Document();
    // PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("Excel2PDF_Output.pdf"));
    // iText_xls_2_pdf.open();
    // // we have two columns in the Excel sheet, so we create a PDF table with two columns
    // // Note: There are ways to make this dynamic in nature, if you want to.
    // PdfPTable my_table = new PdfPTable(2);
    // // We will use the object below to dynamically add new data to the table
    // PdfPCell table_cell;
    // // Loop through rows.
    // while (rowIterator.hasNext()) {
    // Row row = rowIterator.next();
    // Iterator<Cell> cellIterator = row.cellIterator();
    // while (cellIterator.hasNext()) {
    // Cell cell = cellIterator.next(); // Fetch CELL
    // switch (cell.getCellType()) { // Identify CELL type
    // // you need to add more code here based on
    // // your requirement / transformations
    // case Cell.CELL_TYPE_STRING:
    // // Push the data from Excel to PDF Cell
    // table_cell = new PdfPCell(new Phrase(cell.getStringCellValue()));
    // // feel free to move the code below to suit to your needs
    // my_table.addCell(table_cell);
    // break;
    // }
    // // next line
    // }
    //
    // }
    // // Finally add the table to PDF document
    // iText_xls_2_pdf.add(my_table);
    // iText_xls_2_pdf.close();
    // // we created our pdf file..
    // input_document.close(); // close xls
    //
    //
    //
    // return bos.toByteArray();
    // } catch (Exception e) {
    // log.error("Exception in convertExcelToPdf(SourceBytes) - " + e);
    // return null;
    // }
    // }
}
