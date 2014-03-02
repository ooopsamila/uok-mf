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

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import uok.mf.reporttemplate.ReportHeader;

public class ExcelReportHeaderImpl implements ReportHeader {
    HSSFWorkbook wb;
    Sheet sheet;

    public ExcelReportHeaderImpl(HSSFWorkbook wb, Sheet sheet) {
        this.wb = wb;
        this.sheet = sheet;
    }

    public void addReportHeaderString(String headerName) {
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);

        Row headerRow = sheet.createRow((short) 1);

        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 5));

        Cell headerCell = headerRow.createCell(1);
        headerCell.setCellValue(headerName);
        headerCell.setCellStyle(cellStyle);
        HSSFFont font = wb.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.BLACK.index);
        cellStyle.setFont(font);
    }

    public void addReportParamString(String paramString) {
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);

        Row headerRow = sheet.createRow((short) 2);

        sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 5));

        Cell headerCell = headerRow.createCell(1);
        headerCell.setCellValue(paramString);
        headerCell.setCellStyle(cellStyle);
        HSSFFont font = wb.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setFontHeightInPoints((short) 11);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.BLACK.index);
        cellStyle.setFont(font);
    }

    public String getReportHeaderString() {
        return null;
    }

    public String getReportParamString() {
        return null;
    }
}
