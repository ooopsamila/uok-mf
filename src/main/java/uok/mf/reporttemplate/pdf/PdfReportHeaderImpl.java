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


import uok.mf.reporttemplate.ReportHeader;
import uok.mf.reporttemplate.impl.ReportConstants;

import java.util.Hashtable;
import java.util.Map;

public class PdfReportHeaderImpl implements ReportHeader {
    Map<String, String> header = new Hashtable<String, String>();

    public void addReportHeaderString(String headerName) {
        header.put(ReportConstants.REPORT_HEADER_1, headerName);
    }

    public void addReportParamString(String paramString) {
        header.put(ReportConstants.REPORT_HEADER_2, paramString);
    }

    public String getReportHeaderString() {
        return header.get(ReportConstants.REPORT_HEADER_1);
    }

    public String getReportParamString() {
        return header.get(ReportConstants.REPORT_HEADER_2);
    }
}
