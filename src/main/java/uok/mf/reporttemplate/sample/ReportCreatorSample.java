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

package uok.mf.reporttemplate.sample;


import uok.mf.reporttemplate.ReportBody;
import uok.mf.reporttemplate.ReportCreator;
import uok.mf.reporttemplate.ReportHeader;
import uok.mf.reporttemplate.excel.CreateExcelReport;
import uok.mf.reporttemplate.pdf.CreatePdfReport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReportCreatorSample {
    public static void main(String args[]) {

        ReportCreatorSample creatorSample = new ReportCreatorSample();

        // Creating pdf report.
        try {
            FileOutputStream outputStream = new FileOutputStream("MyFirstTable.pdf");
            ReportCreator creator = new CreatePdfReport(2);
            creatorSample.createReports(outputStream, creator);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Creating excel report.
        try {
            FileOutputStream outputStream = new FileOutputStream("MyFirstTable.xls");
            ReportCreator creator = new CreateExcelReport(2);
            creatorSample.createReports(outputStream, creator);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void createReports(OutputStream outputStream, ReportCreator creator) {
        ReportHeader reportHeader = creator.getReportHeader();
        reportHeader.addReportHeaderString("Historical Cases");
        reportHeader.addReportParamString("Report Date From 01/01/2008 To 02/02/2008");

        ReportBody reportBody = creator.getReportBody();
        reportBody.addReportTableHeader(new String[]{"General Information"});
        reportBody.addReportTableHeader(new String[]{" "});
        reportBody.addReportTableHeader(new String[]{"Parameter", "Value"});

        List<String[]> tableData1 = new ArrayList<String[]>();
        tableData1.add(new String[]{"Name :", "Rasika"});
        tableData1.add(new String[]{"Age :", "28"});
        reportBody.addReportTableData(tableData1);

        reportBody.addReportSubHeader(new String[]{"Address"});

        List<String[]> tableData2 = new ArrayList<String[]>();
        tableData2.add(new String[]{"Street :", "De Soysa Streed"});
        tableData2.add(new String[]{"Town :", "Colomb"});
        reportBody.addReportTableData(tableData2);

        creator.createReport(outputStream);
    }
}
