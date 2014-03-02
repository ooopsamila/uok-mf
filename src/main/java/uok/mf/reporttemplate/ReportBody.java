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

package uok.mf.reporttemplate;

import com.lowagie.text.Element;

import java.util.List;
import java.util.Map;

public interface ReportBody {
    void setReportTableColumns(int noOfColumns);
    int getReportTableColumns();
    void addReportTableHeader(String[] tableHeader);
    String[] getReportTableHeader();
    void addReportTableData(List<String[]> reportData);
    void addReportSubHeader(String[] tableSubHeader);
    Map<String, Element> getReportBodyElements();
}
