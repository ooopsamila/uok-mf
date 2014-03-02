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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import uok.mf.reporttemplate.ReportTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ReportController implements Controller {
    private ReportViewer reportViewer;
    private Logger logger = LoggerFactory.getLogger(ReportController.class);

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        logger.info("Request came to the Report Controller");
        ReportTemplate report = (ReportTemplate) httpServletRequest.getSession().getAttribute("report");
        Map model = new HashMap();
        model.put("type", httpServletRequest.getParameter("type"));
        model.put("reportHeader", report.getHeader());
        model.put("reportParams", report.getSubHeader());
        model.put("reportColumn", report.getColHeaders());
        model.put("reportBeans", report.getData());
        return new ModelAndView(getReportViewer(), model);
    }

    public ReportViewer getReportViewer() {
        return reportViewer;
    }

    public void setReportViewer(ReportViewer reportViewer) {
        this.reportViewer = reportViewer;
    }
}
