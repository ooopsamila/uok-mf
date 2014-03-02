/*
 * (C) Copyright 2007-2008 hSenid Software International (Pvt) Limited.
 * All Rights Reserved.
 * <p/>
 * These materials are unpublished, proprietary, confidential source code of
 * hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 * of hSenid Software International (Pvt) Limited.
 * <p/>
 * hSenid Software International (Pvt) Limited retains all title to and intellectual
 * property rights in these materials.
 */


package uok.mf.reporttemplate.impl;


import uok.mf.reporttemplate.ReportTemplate;

import java.util.List;

/**
 * Date: Feb 12, 2010
 * Time: 1:36:28 PM
 * $LastChangedDate$
 * $LastChangedBy$
 * $LastChangedRevision$
 */
public class ReportTemplateImpl implements ReportTemplate {
    private String header;
    private String subHeader;
    private String[] colHeaders;
    private List<String[]> data;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public String[] getColHeaders() {
        return colHeaders;
    }

    public void setColHeaders(String[] colHeaders) {
        this.colHeaders = colHeaders;
    }

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }
}
