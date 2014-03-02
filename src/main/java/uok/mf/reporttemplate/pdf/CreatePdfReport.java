/*
 *   (C) Copyright 2008-2009 hSenid Software International (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 */

package uok.mf.reporttemplate.pdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uok.mf.reporttemplate.ReportBody;
import uok.mf.reporttemplate.ReportCreator;
import uok.mf.reporttemplate.ReportHeader;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreatePdfReport implements ReportCreator {

    private static final Logger logger = LoggerFactory.getLogger(CreatePdfReport.class);

    ReportHeader reportHeader;
    ReportBody reportBody;


    public CreatePdfReport(int tableColumns) {
        reportHeader = new PdfReportHeaderImpl();
        reportBody = new PdfReportBodyImpl(tableColumns);
    }

    public ReportHeader getReportHeader() {
        return reportHeader;
    }

    public ReportBody getReportBody() {
        return reportBody;
    }

    public void createReport(OutputStream outputStream) {
        try {
            creatPdf(outputStream);
        } catch (DocumentException e) {
            logger.error("Error creating the report", e);
        }
    }

    private void creatPdf(OutputStream outputStream) throws DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        creadeReportHeader(document);
        createReportBody(document);

        document.close();
    }

    private void creadeReportHeader(Document document) throws DocumentException {
        Paragraph header = new Paragraph(reportHeader.getReportHeaderString(),
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
        header.setAlignment(Element.ALIGN_CENTER);
        document.add(header);

        Paragraph paramString = new Paragraph(reportHeader.getReportParamString(),
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11));
        paramString.setAlignment(Element.ALIGN_CENTER);
        document.add(paramString);

        Paragraph emptyString = new Paragraph(" ",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11));
        emptyString.setAlignment(Element.ALIGN_CENTER);
        document.add(emptyString);

    }

    private void createReportBody(Document document) throws DocumentException {
        LinkedHashMap<String, Element> body = (LinkedHashMap<String, Element>) reportBody.getReportBodyElements();

        for (Iterator it = body.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            Element element = (Element) entry.getValue();
            document.add(element);
        }
    }
}
