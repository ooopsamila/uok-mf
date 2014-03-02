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
package uok.mf.reporttemplate.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;
import uok.mf.reporttemplate.ReportBody;
import uok.mf.reporttemplate.ReportCreator;
import uok.mf.reporttemplate.ReportHeader;
import uok.mf.reporttemplate.excel.CreateExcelReport;
import uok.mf.reporttemplate.pdf.CreatePdfReport;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ReportViewer implements View {

    private static final String CONTENT_TYPE = "text/plain";
    private static final String XLS_CONTENT_TYPE = "application/vnd.ms-excel";
    private static final String PDF_CONTENT_TYPE = "application/pdf";
    private Logger logger = LoggerFactory.getLogger(ReportViewer.class);

    public String getContentType() {
        return CONTENT_TYPE;
    }

    public void render(Map map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String type = (String) map.get("type");
            String reportHeader = (String) map.get("reportHeader");
            String reportParams = (String) map.get("reportParams");
            String[] reportColumn = (String[]) map.get("reportColumn");

            ServletOutputStream outputStream = null;
            String fileName = reportHeader.trim().replaceAll(" ", "-");
            response.reset();
            response.setHeader("Cache-Control", "max-age=0");
            response.setContentType((type.equals("pdf") ? PDF_CONTENT_TYPE : XLS_CONTENT_TYPE));
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "." + type);
            response.setHeader("Pragma", "public");
            outputStream = response.getOutputStream();

            List<String[]> reportBeanList = (List<String[]>) map.get("reportBeans");
            createReportsLevel1(outputStream, reportBeanList, reportHeader, reportParams, reportColumn, type);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            logger.error("Data rendering error.", e);
        }
    }

    public void createReportsLevel1(ServletOutputStream outputStream, List<String[]> tableData, String reportHeaderString, String reportParams, String[] colHeaders, String type) {
        int numberOfColumns = colHeaders.length;
        ReportCreator creator = (type.equals("pdf")) ? new CreatePdfReport(numberOfColumns) : new CreateExcelReport(numberOfColumns);

        ReportHeader reportHeader = creator.getReportHeader();
        reportHeader.addReportHeaderString(reportHeaderString);
        reportHeader.addReportParamString(reportParams);

        ReportBody reportBody = creator.getReportBody();
        reportBody.addReportTableHeader(colHeaders);

        reportBody.addReportTableData(tableData);
        creator.createReport(outputStream);
    }
}
