package com.dt.utils;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.dt.constants.CellTypeConstants;
import com.dt.constants.StringConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelReportsUtils {

    private static final String DECIMAL_FORMAT = "#,##0.00";

    private static final String TMPL_PATH = "classpath:/tmpl_excel/{fileName}";

    public static void addCell(XSSFWorkbook workbook, XSSFRow row, XSSFSheet spreadsheet,
                    int columnIndex, String cellValue, boolean bold) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->");
        }

        try {
            XSSFFont font = workbook.createFont();
            font.setBold(bold);
            XSSFCellStyle style = workbook.createCellStyle();
            if (bold) {
                style.setAlignment(HorizontalAlignment.CENTER);
            }
            style.setFont(font);
            XSSFCell cell = row.createCell(columnIndex);
            cell.setCellStyle(style);
            cell.setCellValue(cellValue);
            style.setWrapText(true);
            if (spreadsheet != null) {
                spreadsheet.autoSizeColumn(columnIndex);
            }

        } catch (Exception e) {
            log.error("Exception in addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->"
                            + e);
        }
    }

    public static void addCell(XSSFWorkbook workbook, XSSFRow row, XSSFSheet spreadsheet,
                    int columnIndex, int cellValue, boolean bold) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->");
        }

        try {
            XSSFFont font = workbook.createFont();
            font.setBold(bold);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            XSSFCell cell = row.createCell(columnIndex);
            cell.setCellStyle(style);
            cell.setCellValue(cellValue);
            style.setWrapText(true);
            if (spreadsheet != null) {
                spreadsheet.autoSizeColumn(columnIndex);
            }
        } catch (Exception e) {
            log.error("Exception in addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->"
                            + e);
        }
    }

    public static void addCell(XSSFWorkbook workbook, XSSFRow row, XSSFSheet spreadsheet,
                    int columnIndex, double cellValue, boolean bold) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->");
        }

        try {
            XSSFFont font = workbook.createFont();
            font.setBold(bold);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            XSSFCell cell = row.createCell(columnIndex);
            cell.setCellStyle(style);
            cell.setCellValue(cellValue);
            style.setWrapText(true);
            if (spreadsheet != null) {
                spreadsheet.autoSizeColumn(columnIndex);
            }
        } catch (Exception e) {
            log.error("Exception in addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->"
                            + e);
        }
    }

    public static void addCell(XSSFWorkbook workbook, XSSFRow row, XSSFSheet spreadsheet,
                    int columnIndex, Date cellValue, boolean bold) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->");
        }

        try {
            XSSFFont font = workbook.createFont();
            font.setBold(bold);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            XSSFCell cell = row.createCell(columnIndex);
            cell.setCellStyle(style);

            if (cellValue != null) {
                XSSFDataFormat format = workbook.createDataFormat();
                style.setDataFormat(format.getFormat(LocalDateTimeUtils.ddDotMMDotyyyy));
                cell.setCellValue(cellValue);
            } else {
                cell.setCellValue(StringConstants.EMPTY);
            }
            style.setWrapText(true);
            if (spreadsheet != null) {
                spreadsheet.autoSizeColumn(columnIndex);
            }
        } catch (Exception e) {
            log.error("Exception in addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->"
                            + e);
        }
    }

    public static void addTitleRow(XSSFWorkbook workbook, XSSFSheet spreadsheet,
                    CellRangeAddress range, String title) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addTitleRow(XSSFWorkbook, XSSFSheet, CellRangeAddress, title) ->");
        }

        try {
            XSSFRow headerRow = spreadsheet.createRow(range.getFirstRow());
            XSSFFont titleFont = workbook.createFont();
            titleFont.setBold(true);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(titleFont);
            style.setAlignment(HorizontalAlignment.CENTER);
            XSSFCell cell = headerRow.createCell(range.getFirstColumn());
            cell.setCellStyle(style);
            cell.setCellValue(title);
            style.setWrapText(true);

            spreadsheet.addMergedRegion(range);

        } catch (Exception e) {
            log.error("Exception in addTitleRow(XSSFWorkbook, XSSFSheet, CellRangeAddress, title) ->"
                            + e);
        }
    }

    public static String getExcelTitle(String str1, String str2) {

        if (log.isDebugEnabled()) {
            log.debug("Executing getExcelTitle(String str1, String str2) ->");
        }

        try {
            String title = StringConstants.EMPTY;
            if (Utils.isNotEmpty(str1)) {
                title += str1 + StringConstants.SPACE + StringConstants.HYPHEN
                                + StringConstants.SPACE;
            }
            if (Utils.isNotEmpty(str2)) {
                title += Utils.getValidString(str2) + StringConstants.SPACE + StringConstants.HYPHEN
                                + StringConstants.SPACE;
            }
            String titleStr = Utils.getValidString(title) + LocalDateTimeUtils.convertLdtToString(
                            LocalDateTime.now(), LocalDateTimeUtils.dd_MMM_yyyy_HH_mm_ss);
            return titleStr.toUpperCase();
        } catch (Exception e) {
            log.error("Exception getExcelTitle(String str1, String str2 ) ->" + e);
            return StringConstants.EMPTY;
        }
    }

    public static void copyRow(XSSFSheet p_sheet, int p_sourceRowNum, int p_targetRowNum) {

        if (log.isDebugEnabled()) {
            log.debug("Executing copyRow(XSSFSheet p_sheet, int p_sourceRowNum, int p_targetRowNum) ->");
        }

        try {
            // Get the source / new row
            XSSFRow l_rowTarget = p_sheet.getRow(p_targetRowNum);
            XSSFRow l_rowSource = p_sheet.getRow(p_sourceRowNum);

            // If the row exist in destination, push down all rows by 1 else create a new row
            if (l_rowTarget != null) {
                p_sheet.shiftRows(p_targetRowNum, p_sheet.getLastRowNum(), 1);
            } else {
                l_rowTarget = p_sheet.createRow(p_targetRowNum);
            }

            l_rowTarget.setHeight(l_rowSource.getHeight());

            // Loop through source columns to add to new row
            for (int i = 0; i < l_rowSource.getLastCellNum(); i++) {
                // Grab a copy of the old/new cell
                XSSFCell l_cellOld = l_rowSource.getCell(i);
                XSSFCell l_cellNew = l_rowTarget.createCell(i);

                // If the old cell is null jump to next cell
                if (l_cellOld == null) {
                    l_cellNew = null;
                    continue;
                }

                // Use old cell style
                XSSFCellStyle l_style = l_cellOld.getCellStyle();
                // l_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                l_cellNew.setCellStyle(l_style);

                // If there is a cell comment, copy
                if (l_cellNew.getCellComment() != null) {
                    l_cellNew.setCellComment(l_cellOld.getCellComment());
                }

                // If there is a cell hyperlink, copy
                if (l_cellOld.getHyperlink() != null) {
                    l_cellNew.setHyperlink(l_cellOld.getHyperlink());
                }
            }
        } catch (Exception e) {
            log.error("Exception copyRow(XSSFSheet p_sheet, int p_sourceRowNum, int p_targetRowNum) ->"
                            + e);
        }
    }

    public static XSSFRow getCopyRow(XSSFSheet sheet, int sourceRowIndex, int targetRowIndex) {

        if (log.isDebugEnabled()) {
            log.debug("Executing getCopyRow(XSSFSheet sheet, int sourceRowIndex, int targetRowIndex) ->");
        }

        try {
            // Get the source / new row
            XSSFRow rowTarget = sheet.getRow(targetRowIndex);
            XSSFRow rowSource = sheet.getRow(sourceRowIndex);

            // If the row exist in destination, return that row else
            // create a new row
            if (rowTarget != null) {
                return rowTarget;
            }
            rowTarget = sheet.createRow(targetRowIndex);
            rowTarget.setHeight(rowSource.getHeight());

            short h = rowTarget.getHeight();
            log.debug("height : " + h);

            // Loop through source columns to add to new row
            for (int i = 0; i < rowSource.getLastCellNum(); i++) {
                // Grab a copy of the old/new cell
                XSSFCell l_cellOld = rowSource.getCell(i);
                XSSFCell l_cellNew = rowTarget.createCell(i);

                // If the old cell is null jump to next cell
                if (l_cellOld == null) {
                    l_cellNew = null;
                    continue;
                }

                // Use old cell style
                XSSFCellStyle l_style = l_cellOld.getCellStyle();
                // l_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                l_cellNew.setCellStyle(l_style);

                // If there is a cell comment, copy
                if (l_cellNew.getCellComment() != null) {
                    l_cellNew.setCellComment(l_cellOld.getCellComment());
                }

                // If there is a cell hyperlink, copy
                if (l_cellOld.getHyperlink() != null) {
                    l_cellNew.setHyperlink(l_cellOld.getHyperlink());
                }
            }
            return rowTarget;
        } catch (Exception e) {
            log.error("Exception getCopyRow(XSSFSheet sheet, int sourceRowIndex, int targetRowIndex) ->"
                            + e);
            return null;
        }
    }

    public static XSSFRow getCopyRow(XSSFSheet sourceSheet, XSSFSheet tagetSheet,
                    int sourceRowIndex, int targetRowIndex) {

        if (log.isDebugEnabled()) {
            log.debug("Executing getCopyRow(XSSFSheet sheet, XSSFSheet tagetSheet , int sourceRowIndex, int targetRowIndex) ->");
        }

        try {
            // Get the source / new row
            XSSFRow rowTarget = tagetSheet.getRow(targetRowIndex);
            XSSFRow rowSource = sourceSheet.getRow(sourceRowIndex);

            // If the row exist in destination, return that row else
            // create a new row
            if (rowTarget != null) {
                return rowTarget;
            }
            rowTarget = tagetSheet.createRow(targetRowIndex);
            rowTarget.setHeight(rowSource.getHeight());

            // Loop through source columns to add to new row
            for (int i = 0; i < rowSource.getLastCellNum(); i++) {
                // Grab a copy of the old/new cell
                XSSFCell l_cellOld = rowSource.getCell(i);
                XSSFCell l_cellNew = rowTarget.createCell(i);

                // If the old cell is null jump to next cell
                if (l_cellOld == null) {
                    l_cellNew = null;
                    continue;
                }

                // Use old cell style
                XSSFCellStyle l_style = l_cellOld.getCellStyle();
                // l_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                l_cellNew.setCellStyle(l_style);

                // If there is a cell comment, copy
                if (l_cellNew.getCellComment() != null) {
                    l_cellNew.setCellComment(l_cellOld.getCellComment());
                }

                // If there is a cell hyperlink, copy
                if (l_cellOld.getHyperlink() != null) {
                    l_cellNew.setHyperlink(l_cellOld.getHyperlink());
                }
            }
            return rowTarget;
        } catch (Exception e) {
            log.error("Exception getCopyRow(XSSFSheet sheet, XSSFSheet tagetSheet, int sourceRowIndex, int targetRowIndex) ->"
                            + e);
            return null;
        }
    }

    public static void addEmptyCell(XSSFWorkbook workbook, XSSFRow row, XSSFSheet spreadsheet,
                    int columnIndex, boolean bold, int cellType) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->");
        }

        try {
            XSSFFont font = workbook.createFont();
            font.setBold(bold);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            XSSFCell cell = row.createCell(columnIndex);
            style.setWrapText(true);
            cell.setCellStyle(style);
            if (cellType == CellTypeConstants.DATE) {
                XSSFDataFormat format = workbook.createDataFormat();
                style.setDataFormat(format.getFormat(LocalDateTimeUtils.ddDotMMDotyyyy));
            }
            if (cellType == CellTypeConstants.DOUBLE) {
                XSSFDataFormat format = workbook.createDataFormat();
                style.setDataFormat(format.getFormat(DECIMAL_FORMAT));
            }
            if (cellType == CellTypeConstants.TIME) {
                XSSFDataFormat format = workbook.createDataFormat();
                style.setDataFormat(format.getFormat(LocalDateTimeUtils.HH_mm));
            }
        } catch (Exception e) {
            log.error("Exception in addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->"
                            + e);
        }
    }

    public static void addFormStatusCellValue(XSSFRow row, int columnIndex, String cellValue) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addFormStatusCellValue(XSSFRow row, int columnIndex, String cellValue) ->");
        }

        try {
            if (cellValue == null) {
                cellValue = StringConstants.EMPTY;
            }
            XSSFCell cell = row.getCell(columnIndex);
            XSSFCellStyle style = cell.getCellStyle();
            XSSFFont font = style.getFont();
            if (cellValue.equals("Under Progress")) {
                // style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
                // style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                // style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                // style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                font.setColor(rgb(255, 128, 0));
                style.setFont(font);
            } else if (cellValue.equals("Pass")) {
                // style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                // style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                // style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                // style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                font.setColor(rgb(0, 255, 0));
                style.setFont(font);
            } else if (cellValue.equals("Fail")) {
                // style.setFillForegroundColor(IndexedColors.RED.getIndex());
                // style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                // style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                // style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                font.setColor(rgb(255, 0, 0));
                style.setFont(font);
            }
            cell.setCellValue(cellValue);
            cell.setCellStyle(style);

        } catch (Exception e) {
            log.error("Exception in addFormStatusCellValue(XSSFRow row, int columnIndex, String cellValue) ->"
                            + e);
        }
    }

    public static void addCellValue(XSSFRow row, int columnIndex, String cellValue) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCellValue(XSSFRow row, int columnIndex, String cellValue) ->");
        }

        try {
            if (cellValue == null) {
                cellValue = StringConstants.EMPTY;
            }
            XSSFCell cell = row.getCell(columnIndex);
            cell.setCellValue(cellValue);

        } catch (Exception e) {
            log.error("Exception in addCellValue(XSSFRow row, int columnIndex, String cellValue) ->"
                            + e);
        }
    }

    public static void addCellValue(XSSFRow row, int columnIndex, int cellValue) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCellValue(XSSFRow row, int columnIndex, String cellValue) ->");
        }

        try {
            XSSFCell cell = row.getCell(columnIndex);
            cell.setCellValue(cellValue);
        } catch (Exception e) {
            log.error("Exception in addCellValue(XSSFRow row, int columnIndex, String cellValue) ->"
                            + e);
        }
    }

    public static void addCellValue(XSSFRow row, int columnIndex, Date cellValue) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCellValue(XSSFRow row, int columnIndex, String cellValue) ->");
        }

        try {
            if (cellValue == null) {
                return;
            }
            XSSFCell cell = row.getCell(columnIndex);
            cell.setCellValue(cellValue);
        } catch (Exception e) {
            log.error("Exception in addCellValue(XSSFRow row, int columnIndex, String cellValue) ->"
                            + e);
        }
    }

    public static void addCellValue(XSSFRow row, int columnIndex, double cellValue) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCellValue(XSSFRow row, int columnIndex, String cellValue) ->");
        }

        try {
            XSSFCell cell = row.getCell(columnIndex);
            cell.setCellValue(cellValue);
        } catch (Exception e) {
            log.error("Exception in addCellValue(XSSFRow row, int columnIndex, String cellValue) ->"
                            + e);
        }
    }

    public static void addCellValue(XSSFRow row, int columnIndex, RichTextString cellValue) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCellValue(XSSFRow row, int columnIndex, String cellValue) ->");
        }

        try {
            XSSFCell cell = row.getCell(columnIndex);
            if (cellValue == null) {
                cell.setCellValue(StringConstants.EMPTY);
                return;
            }
            cell.setCellValue(cellValue);
        } catch (Exception e) {
            log.error("Exception in addCellValue(XSSFRow row, int columnIndex, String cellValue) ->"
                            + e);
        }
    }

    public static void autoSizeColumn(XSSFSheet spreadsheet, int startIndex, int endIndex) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCellValue(XSSFRow row, int columnIndex, String cellValue) ->");
        }

        try {
            for (int i = startIndex; i <= endIndex; i++) {
                spreadsheet.autoSizeColumn(i, true);
            }
        } catch (Exception e) {
            log.error("Exception in addCellValue(XSSFRow row, int columnIndex, String cellValue) ->"
                            + e);
        }
    }

    public static void merge(XSSFSheet spreadsheet, CellRangeAddress range, String value) {

        if (log.isDebugEnabled()) {
            log.debug("Executing merge(XSSFSheet spreadsheet, CellRangeAddress range, String value) ->");
        }

        try {
            XSSFRow headerRow = spreadsheet.getRow(range.getFirstRow());
            XSSFCell cell = headerRow.getCell(range.getFirstColumn());
            cell.setCellValue(value);
            XSSFCellStyle style = cell.getCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            spreadsheet.addMergedRegion(range);

        } catch (Exception e) {
            log.error("Exception in merge(XSSFSheet spreadsheet, CellRangeAddress range, String value) ->"
                            + e);
        }
    }

    public static void addEmptyCell(XSSFWorkbook workbook, XSSFRow row, XSSFSheet spreadsheet,
                    int columnIndex, boolean bold, int cellType, HorizontalAlignment align) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->");
        }

        try {
            XSSFFont font = workbook.createFont();
            font.setBold(bold);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            XSSFCell cell = row.createCell(columnIndex);
            style.setWrapText(true);
            cell.setCellStyle(style);
            style.setAlignment(align);
            if (cellType == CellTypeConstants.DATE) {
                XSSFDataFormat format = workbook.createDataFormat();
                style.setDataFormat(format.getFormat(LocalDateTimeUtils.ddDotMMDotyyyy));
            }
            if (cellType == CellTypeConstants.DOUBLE) {
                XSSFDataFormat format = workbook.createDataFormat();
                style.setDataFormat(format.getFormat(DECIMAL_FORMAT));
            }
            if (cellType == CellTypeConstants.TIME) {
                XSSFDataFormat format = workbook.createDataFormat();
                style.setDataFormat(format.getFormat(LocalDateTimeUtils.HH_mm));
            }
        } catch (Exception e) {
            log.error("Exception in addCell(XSSFWorkbook, XSSFRow, XSSFSheet, ColumnIndex, CellValue, Bold) ->"
                            + e);
        }
    }

    public static void applyRowStyle(XSSFWorkbook workbook, XSSFRow row, XSSFColor backColor,
                    HorizontalAlignment align, boolean bold, short fontColor, boolean border,
                    short borderColor) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addTitleRow(XSSFWorkbook, XSSFSheet,CellRangeAddress, title) ->");
        }

        try {
            if (row == null) {
                return;
            }
            int firstColInd = row.getFirstCellNum();
            int lastColInd = row.getLastCellNum();
            for (int i = firstColInd; i <= lastColInd; i++) {
                XSSFCell cell = row.getCell(i);
                if (cell == null) {
                    continue;
                }
                XSSFCellStyle style = cell.getCellStyle();
                if (style == null) {
                    style = workbook.createCellStyle();
                }
                XSSFFont font = style.getFont();
                if (font != null) {
                    font = workbook.createFont();
                }
                font.setBold(bold);
                font.setColor(fontColor);
                style.setFont(font);
                style.setAlignment(align);
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                style.setFillForegroundColor(backColor);
                if (border) {
                    style.setBorderTop(BorderStyle.THIN);
                    style.setBorderBottom(BorderStyle.THIN);
                    style.setBorderLeft(BorderStyle.THIN);
                    style.setBorderRight(BorderStyle.THIN);
                    style.setBottomBorderColor(borderColor);
                    style.setTopBorderColor(borderColor);
                    style.setLeftBorderColor(borderColor);
                    style.setRightBorderColor(borderColor);
                }
                cell.setCellStyle(style);
            }
        } catch (Exception e) {
            log.error("Exception in  addTitleRow(XSSFWorkbook, XSSFSheet,CellRangeAddress, title) ->"
                            + e);
        }
    }

    public static XSSFColor rgb(int r, int g, int b) {

        if (log.isDebugEnabled()) {
            log.debug("Executing rgb(R, G, B) ->");
        }

        try {
            @SuppressWarnings("deprecation")
            XSSFColor color = new XSSFColor();
            byte[] rgb = new byte[3];
            rgb[0] = (byte) r;
            rgb[1] = (byte) g;
            rgb[2] = (byte) b;
            color.setRGB(rgb);
            return color;
        } catch (Exception e) {
            log.error("Exception in rgb(R, G, B) ->" + e);
            return null;
        }
    }

    public static InputStream inputStream(String filename) {

        if (log.isDebugEnabled()) {
            log.debug("Executing inputStream(Filename) ->");
        }

        try {
            if (Utils.isEmpty(filename)) {
                log.error("filename IS EMPTY--->");
                return null;
            }
            PathMatchingResourcePatternResolver resolver =
                            new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource(TMPL_PATH.replace("{fileName}", filename));
            return resource.getInputStream();

        } catch (Exception e) {
            log.error("Exception in inputStream(Filename) ->");
            return null;
        }
    }

    public static XSSFWorkbook createWorkbook(String filename) {

        if (log.isDebugEnabled()) {
            log.debug("Executing createWorkbook(String filename) ->");
        }

        try {
            if (Utils.isEmpty(filename)) {
                log.error("filename IS EMPTY--->");
                return null;
            }
            return new XSSFWorkbook(inputStream(filename));

        } catch (Exception e) {
            log.error("Exception in createWorkbook(String filename) ->");
            return null;
        }
    }

    public static void addTitle(String title, XSSFSheet spreadsheet, int titleRowIndex) {

        if (log.isDebugEnabled()) {
            log.debug("Executing addTitle(String title, XSSFSheet spreadsheet, int titleRowIndex) ->");
        }

        try {
            String titleStr = ExcelReportsUtils.getExcelTitle(StringConstants.EMPTY, title);
            XSSFRow titeleRow = spreadsheet.getRow(titleRowIndex);
            ExcelReportsUtils.addCellValue(titeleRow, titeleRow.getFirstCellNum(), titleStr);

        } catch (Exception e) {
            log.error("Exception in addTitle(String title, XSSFSheet spreadsheet, int titleRowIndex) ->");
        }
    }

    public static XSSFCell copyCell(XSSFSheet p_sheet, int p_sourceRowNum, int p_targetRowNum,
                    int p_sourceCellNum, int p_targetCellNum) {

        if (log.isDebugEnabled()) {
            log.debug("Executing copyCell(p_sheet, p_sourceRowNum, p_targetRowNum, p_sourceCellNum, p_targetCellNum) ->");
        }

        try {
            // Get the source / new row
            XSSFRow l_rowSource = p_sheet.getRow(p_sourceRowNum);
            XSSFRow l_rowTarget = null;
            if (p_targetRowNum == p_sourceRowNum) {
                l_rowTarget = l_rowSource;
            } else {
                l_rowTarget = p_sheet.getRow(p_targetRowNum);
            }

            // Loop through source columns to add to new row
            // Grab a copy of the old/new cell
            XSSFCell l_cellOld = l_rowSource.getCell(p_sourceCellNum);
            XSSFCell l_cellNew = l_rowTarget.getCell(p_targetCellNum);
            if (l_cellNew == null) {
                l_cellNew = l_rowTarget.createCell(p_targetCellNum);
            }
            // If the old cell is null
            if (l_cellOld == null) {
                l_cellNew = null;
                return l_cellNew;
            }

            // Use old cell style
            XSSFCellStyle l_style = l_cellOld.getCellStyle();
            // l_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
            l_cellNew.setCellStyle(l_style);

            // If there is a cell comment, copy
            if (l_cellNew.getCellComment() != null) {
                l_cellNew.setCellComment(l_cellOld.getCellComment());
            }

            // If there is a cell hyperlink, copy
            if (l_cellOld.getHyperlink() != null) {
                l_cellNew.setHyperlink(l_cellOld.getHyperlink());
            }


            return l_cellNew;
        } catch (Exception e) {
            log.error("Exception copyCell(p_sheet, p_sourceRowNum, p_targetRowNum, p_sourceCellNum, p_targetCellNum) ->"
                            + e);
            return null;
        }
    }

    public static void setCellValue(XSSFRow row, int p_cellNum, String p_cellValue) {

        if (log.isDebugEnabled()) {
            log.debug("Executing setCellValue(XSSFRow, p_cellNum, p_cellValue) ->");
        }

        try {
            String value = Utils.getValidString(p_cellValue);

            XSSFCell cell = row.getCell(p_cellNum);
            if (cell == null) {

                cell = copyCell(row.getSheet(), row.getRowNum(), row.getRowNum(), p_cellNum - 1,
                                p_cellNum);
            }
            XSSFCellStyle style = cell.getCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellValue(value);

        } catch (Exception e) {
            log.error("Exception in setCellValue(XSSFRow, p_cellNum, p_cellValue) ->" + e);
        }
    }

    public static void setCellValue(XSSFRow row, int p_cellNum, long p_cellValue) {

        if (log.isDebugEnabled()) {
            log.debug("Executing setCellValue(XSSFRow, p_cellNum, p_cellValue) ->");
        }

        try {
            XSSFCell cell = row.getCell(p_cellNum);
            if (cell == null) {

                cell = copyCell(row.getSheet(), row.getRowNum(), row.getRowNum(), p_cellNum - 1,
                                p_cellNum);
            }
            XSSFCellStyle style = cell.getCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellValue(p_cellValue);

        } catch (Exception e) {
            log.error("Exception in setCellValue(XSSFRow, p_cellNum, p_cellValue) ->" + e);
        }
    }

    public static void setCellValue(XSSFRow row, int p_cellNum, double p_cellValue) {

        if (log.isDebugEnabled()) {
            log.debug("Executing setCellValue(XSSFRow, p_cellNum, p_cellValue) ->");
        }

        try {
            XSSFCell cell = row.getCell(p_cellNum);
            if (cell == null) {

                cell = copyCell(row.getSheet(), row.getRowNum(), row.getRowNum(), p_cellNum - 1,
                                p_cellNum);
            }
            XSSFCellStyle style = cell.getCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellValue(p_cellValue);

        } catch (Exception e) {
            log.error("Exception in setCellValue(XSSFRow, p_cellNum, p_cellValue) ->" + e);
        }
    }

    public static void setCellValue(XSSFRow row, int p_cellNum, int p_cellValue) {

        if (log.isDebugEnabled()) {
            log.debug("Executing setCellValue(XSSFRow, p_cellNum, p_cellValue) ->");
        }

        try {
            XSSFCell cell = row.getCell(p_cellNum);
            if (cell == null) {

                cell = copyCell(row.getSheet(), row.getRowNum(), row.getRowNum(), p_cellNum - 1,
                                p_cellNum);
            }
            XSSFCellStyle style = cell.getCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellValue(p_cellValue);

        } catch (Exception e) {
            log.error("Exception in setCellValue(XSSFRow, p_cellNum, p_cellValue) ->" + e);
        }
    }

    public static String readCellValue(XSSFCell cell) {

        if (log.isDebugEnabled()) {
            log.debug("Executing readCellValue(XSSFCell) ->");
        }

        try {
            if (cell == null) {
                log.error("XSSFCell is NULL");
                return StringConstants.EMPTY;
            }
            if (cell.getCellType() == null) {
                return Utils.getValidString(cell.getStringCellValue());
            }
            String type = cell.getCellType().toString();
            String value = StringConstants.EMPTY;
            switch (CellType.valueOf(type)) {
                case STRING:
                    value = Utils.getValidString(cell.getStringCellValue());
                    break;
                case NUMERIC:
                    Object obj = cell.getNumericCellValue();
                    if (obj instanceof Date) {
                        value = LocalDateTimeUtils.convertLdtToDateString(LocalDateTimeUtils
                                        .convertDateToLdt(cell.getDateCellValue()));
                    } else {
                        value = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case BLANK:

                    break;
                case _NONE:

                    break;
                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;
                case ERROR:

                    break;
                case FORMULA:

                    break;
                default:
                    break;
            }
            return value;
        } catch (Exception e) {
            log.error("Exception in readCellValue(XSSFCell) ->" + e);
            return StringConstants.EMPTY;
        }
    }

    public static String template(String fileName) {

        if (log.isDebugEnabled()) {
            log.debug("Executing template(fileName) ->");
        }

        try {
            if (Utils.isEmpty(fileName)) {
                log.error("fileName IS EMPTY--->");
                return StringConstants.EMPTY;
            }
            InputStream ins = inputStream(fileName);
            if (ins == null) {
                return StringConstants.EMPTY;
            }
            return IOUtils.toString(ins);
        } catch (Exception e) {
            log.error("Exception in template(fileName) - " + e);
            return StringConstants.EMPTY;
        }
    }
}
