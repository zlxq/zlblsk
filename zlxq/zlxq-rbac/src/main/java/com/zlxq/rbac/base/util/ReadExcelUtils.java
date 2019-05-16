package com.zlxq.rbac.base.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellRangeAddress;

import pojo.ZlxqLog;

/**
 * Excel工具类
 * 
 * @author sdd
 * 
 */
public class ReadExcelUtils {
	public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
	public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";
	public static final String EMPTY = "";
	public static final String POINT = ".";
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * 获得path的后缀名
	 * 
	 * @param path
	 * @return
	 */
	public static String getPostfix(String path) {
		if (path == null || EMPTY.equals(path.trim())) {
			return EMPTY;
		}
		if (path.contains(POINT)) {
			return path.substring(path.lastIndexOf(POINT) + 1, path.length());
		}
		return EMPTY;
	}

	/**
	 * 单元格格式
	 * 
	 * @param hssfCell
	 * @return
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public static String getHValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			String cellValue = "";
			if (HSSFDateUtil.isCellDateFormatted(hssfCell)) {
				Date date = HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue());
				cellValue = sdf.format(date);
			} else {
				DecimalFormat df = new DecimalFormat("#.##");
				cellValue = df.format(hssfCell.getNumericCellValue());
				String strArr = cellValue.substring(cellValue.lastIndexOf(POINT) + 1, cellValue.length());
				if (strArr.equals("00")) {
					cellValue = cellValue.substring(0, cellValue.lastIndexOf(POINT));
				}
			}
			return cellValue;
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

	/**
	 * 单元格格式
	 * 
	 * @param xssfCell
	 * @return
	 */
	public static String getXValue(Cell xssfCell) {
		if (xssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfCell.getBooleanCellValue());
		} else if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			String cellValue = "";
			if (XSSFDateUtil.isCellDateFormatted(xssfCell)) {
				Date date = XSSFDateUtil.getJavaDate(xssfCell.getNumericCellValue());
				cellValue = sdf.format(date);
			} else {
				DecimalFormat df = new DecimalFormat("#.##");
				cellValue = df.format(xssfCell.getNumericCellValue());
				String strArr = cellValue.substring(cellValue.lastIndexOf(POINT) + 1, cellValue.length());
				if (strArr.equals("00")) {
					cellValue = cellValue.substring(0, cellValue.lastIndexOf(POINT));
				}
			}
			return cellValue;
		} else {
			return String.valueOf(xssfCell.getStringCellValue());
		}
	}

	/**
	 * 自定义xssf日期工具类
	 * 
	 * @author sdd
	 * 
	 */
	static class XSSFDateUtil extends DateUtil {
		protected static int absoluteDay(Calendar cal, boolean use1904windowing) {
			return DateUtil.absoluteDay(cal, use1904windowing);
		}
	}

	/**
	 * @param userList
	 *            用户列表
	 * @param out
	 *            输出表
	 */
	public static void exportUserExcel(List<ZlxqLog> logList, ServletOutputStream out) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 1.创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 1.1创建合并单元格对象
			CellRangeAddress callRangeAddress = new CellRangeAddress(0, 0, 0, 4);// 起始行,结束行,起始列,结束列
			// 1.2头标题样式
			HSSFCellStyle headStyle = createCellStyle(workbook, (short) 16);
			// 1.3列标题样式
			HSSFCellStyle colStyle = createCellStyle(workbook, (short) 13);
			// 2.创建工作表
			HSSFSheet sheet = workbook.createSheet("系统日志");
			// 2.1加载合并单元格对象
			sheet.addMergedRegion(callRangeAddress);
			// 设置默认列宽
			sheet.setDefaultColumnWidth(25);
			// 3.创建行
			// 3.1创建头标题行;并且设置头标题
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);

			// 加载单元格样式
			cell.setCellStyle(headStyle);
			cell.setCellValue("系统日志");

			// 3.2创建列标题;并且设置列标题
			HSSFRow row2 = sheet.createRow(1);
			String[] titles = { "登陆号", "登录名", "登录IP", "登陆时间", "应用" };
			for (int i = 0; i < titles.length; i++) {
				HSSFCell cell2 = row2.createCell(i);
				// 加载单元格样式
				cell2.setCellStyle(colStyle);
				cell2.setCellValue(titles[i]);
			}

			// 4.操作单元格;将用户列表写入excel
			if (logList != null) {
				for (int j = 0; j < logList.size(); j++) {
					// 创建数据行,前面有两行,头标题行和列标题行
					HSSFRow row3 = sheet.createRow(j + 2);
					HSSFCell cell1 = row3.createCell(0);
					cell1.setCellValue(logList.get(j).getLoginno());
					HSSFCell cell2 = row3.createCell(1);
					cell2.setCellValue(logList.get(j).getLoginname());
					HSSFCell cell3 = row3.createCell(2);
					cell3.setCellValue(logList.get(j).getLoginip());
					HSSFCell cell4 = row3.createCell(3);
					if (logList.get(j).getLogintime() != null) {
						cell4.setCellValue(sdf.format(logList.get(j).getLogintime()));
					} else {
						cell4.setCellValue("");
					}
					cell4.setCellValue(logList.get(j).getLogintime());
					HSSFCell cell5 = row3.createCell(4);
					cell5.setCellValue(logList.get(j).getLogintype());
				}
			}
			// 5.输出
			workbook.write(out);
//			workbook.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param workbook
	 * @param fontsize
	 * @return 单元格样式
	 */
	private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontsize) {
		// TODO Auto-generated method stub
		HSSFCellStyle style = workbook.createCellStyle();
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		// style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
		// 创建字体
		HSSFFont font = workbook.createFont();
		// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(fontsize);
		// 加载字体
		style.setFont(font);
		return style;
	}
}