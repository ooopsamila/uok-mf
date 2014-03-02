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


package uok.mf.reporttemplate;

import java.util.List;

public interface ReportTemplate {

    public String getHeader();

    public void setHeader(String header);

    public String getSubHeader();

    public void setSubHeader(String subHeader);

    public String[] getColHeaders();

    public void setColHeaders(String[] colHeaders);

    public List<String[]> getData();

    public void setData(List<String[]> data);
}
