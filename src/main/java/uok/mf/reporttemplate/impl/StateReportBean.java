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

public class StateReportBean {

    private String id;
    private String name;
    private String noOfCases;

    public String getNoOfCases() {
        return noOfCases;
    }

    public void setNoOfCases(String noOfCases) {
        this.noOfCases = noOfCases;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("StateReportBean");
        sb.append("{id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", noOfCases='").append(noOfCases).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
