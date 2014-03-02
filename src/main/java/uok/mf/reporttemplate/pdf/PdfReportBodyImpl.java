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

import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import uok.mf.reporttemplate.ReportBody;
import uok.mf.reporttemplate.impl.ReportConstants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PdfReportBodyImpl implements ReportBody {
    Map<String, Element> body = new LinkedHashMap<String, Element>();
    int tableColumns = 0;
    int tableCount = 0;


    public PdfReportBodyImpl(int tableColumns) {
        this.tableColumns = tableColumns;
    }

    public void setReportTableColumns(int tableColumns) {
        this.tableColumns = tableColumns;
    }

    public int getReportTableColumns() {
        return tableColumns;
    }

    public void addReportTableHeader(String[] tableHeader) {
        PdfPTable table = new PdfPTable(tableColumns);

        if (tableHeader.length > 0 && tableHeader.length < tableColumns) {
            PdfPCell cell = new PdfPCell(new Paragraph(tableHeader[0], FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(tableColumns);
            table.addCell(cell);

        } else {
            for (String anAReportHeader : tableHeader) {
                PdfPCell cell = new PdfPCell(new Paragraph(anAReportHeader, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
                table.addCell(cell);
            }
        }

        body.put(ReportConstants.REPORT_BODY_HEADER + tableCount, table);
        tableCount++;
    }

    public String[] getReportTableHeader() {
        return new String[0];
    }

    public void addReportTableData(List<String[]> reportData) {
        PdfPTable table = new PdfPTable(tableColumns);
        for (String[] aReportData : reportData) {
            for (String anAReportData : aReportData) {
                PdfPCell cell = new PdfPCell(new Paragraph(anAReportData));
                table.addCell(cell);
            }
        }
        body.put(ReportConstants.REPORT_BODY_DATA_TABLE + tableCount, table);
        tableCount++;
    }

    public void addReportSubHeader(String[] tableSubHeader) {
        PdfPTable table = new PdfPTable(tableColumns);

        if (tableSubHeader.length > 0 && tableSubHeader.length < tableColumns) {
            PdfPCell cell = new PdfPCell(new Paragraph(tableSubHeader[0]));
            cell.setColspan(tableColumns);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        } else {

            for (String anAReportData : tableSubHeader) {
                PdfPCell cell = new PdfPCell(new Paragraph(anAReportData));
                table.addCell(cell);
            }
        }
        body.put(ReportConstants.REPORT_BODY_SUB_HEADER + tableCount, table);
        tableCount++;
    }

    public Map<String, Element> getReportBodyElements() {
        return body;
    }
}
