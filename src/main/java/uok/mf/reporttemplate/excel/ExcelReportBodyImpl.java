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

import com.lowagie.text.Element;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import uok.mf.reporttemplate.ReportBody;

import java.util.List;
import java.util.Map;

public class ExcelReportBodyImpl implements ReportBody {

    HSSFWorkbook wb;
    Sheet sheet;
    int tableColumns = 0;
    int dataNextInsertRow = 4;

    public ExcelReportBodyImpl(int tableColumns, HSSFWorkbook wb, Sheet sheet) {
        this.tableColumns = tableColumns;
        this.wb = wb;
        this.sheet = sheet;
    }

    public void setReportTableColumns(int noOfColumns) {
        this.tableColumns = noOfColumns;
    }

    public int getReportTableColumns() {
        return tableColumns;
    }

    public void addReportTableHeader(String[] tableHeader) {
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
        HSSFFont font = wb.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setFontHeightInPoints((short) 10);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.BLACK.index);
        cellStyle.setFont(font);
        Row tableHeaderRow = sheet.createRow((short) dataNextInsertRow);

        if (tableHeader.length > 0 && tableHeader.length < tableColumns) {
            sheet.addMergedRegion(new CellRangeAddress(dataNextInsertRow, dataNextInsertRow, 1, tableColumns));
            Cell headerCell = tableHeaderRow.createCell(1);
            headerCell.setCellValue(tableHeader[0]);
            headerCell.setCellStyle(cellStyle);
        }else{
            for (int j = 0; j < tableHeader.length; j++) {
                Cell dataCell = tableHeaderRow.createCell(j+1);
                dataCell.setCellValue(tableHeader[j]);
                dataCell.setCellStyle(cellStyle);
            }
        }
        dataNextInsertRow++;
        
    }

    public String[] getReportTableHeader() {
        return new String[0];
    }

    public void addReportTableData(List<String[]> reportData) {
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_LEFT);

        for (int i = dataNextInsertRow; i < reportData.size() + dataNextInsertRow; i++) {
            Row tableDataRow = sheet.createRow((short) i);
            String[] row = reportData.get(i - dataNextInsertRow);

            for (int j = 0; j < row.length; j++) {
                Cell dataCell = tableDataRow.createCell(j+1);
                dataCell.setCellValue(row[j]);
                dataCell.setCellStyle(cellStyle);
            }
        }

        dataNextInsertRow = reportData.size()  + dataNextInsertRow;
    }

    public void addReportSubHeader(String[] tableSubHeader) {
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_LEFT);

        Row tableHeaderRow = sheet.createRow((short) dataNextInsertRow);

        if (tableSubHeader.length > 0 && tableSubHeader.length < tableColumns) {
            sheet.addMergedRegion(new CellRangeAddress(dataNextInsertRow, dataNextInsertRow, 1, dataNextInsertRow));
            Cell headerCell = tableHeaderRow.createCell(1);
            headerCell.setCellValue(tableSubHeader[0]);
            headerCell.setCellStyle(cellStyle);
        } else {
            for (int j = 0; j < tableSubHeader.length; j++) {
                Cell dataCell = tableHeaderRow.createCell(j+1);
                dataCell.setCellValue(tableSubHeader[j]);
                dataCell.setCellStyle(cellStyle);
            }
        }

        dataNextInsertRow++;
    }

    public Map<String, Element> getReportBodyElements() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
