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

package uok.mf.reporttemplate.excel;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uok.mf.reporttemplate.ReportBody;
import uok.mf.reporttemplate.ReportCreator;
import uok.mf.reporttemplate.ReportHeader;

import java.io.IOException;
import java.io.OutputStream;

public class CreateExcelReport implements ReportCreator {

    private static final Logger logger = LoggerFactory.getLogger(CreateExcelReport.class);

    ReportHeader reportHeader;
    ReportBody reportBody;
    HSSFWorkbook wb;
    Sheet sheet;

    public CreateExcelReport(int tableColumns) {
        wb = new HSSFWorkbook();
        sheet = wb.createSheet();

        reportHeader = new ExcelReportHeaderImpl(wb, sheet);
        reportBody = new ExcelReportBodyImpl(tableColumns, wb, sheet);
    }

    public ReportHeader getReportHeader() {
        return reportHeader;
    }

    public ReportBody getReportBody() {
        return reportBody;
    }

    public void createReport(OutputStream outputStream) {
        try {
            wb.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            logger.error("Error creating the report", e);
        }
    }
}
