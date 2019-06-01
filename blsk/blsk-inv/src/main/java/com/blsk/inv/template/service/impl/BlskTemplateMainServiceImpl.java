package com.blsk.inv.template.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.blsk.inv.space.dao.BlskDocInfoDao;
import com.blsk.inv.template.dao.BlskTemplateDetailDao;
import com.blsk.inv.template.dao.BlskTemplateMainDao;
import com.blsk.inv.template.service.BlskTemplateMainService;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;

import pojo.BlskDocInfo;
import pojo.BlskTemplateDetail;
import pojo.BlskTemplateMain;

public class BlskTemplateMainServiceImpl extends BaseServiceImpl<BlskTemplateMain> implements BlskTemplateMainService {

	private BlskTemplateMainDao blskTemplateMainDao;

	@Resource
	private BlskTemplateDetailDao blskTemplateDetailDao;
	@Resource
	private BlskDocInfoDao blskDocInfoDao;
	
	public BlskTemplateMainServiceImpl(BlskTemplateMainDao blskTemplateMainDao) {
		super(blskTemplateMainDao);
		this.blskTemplateMainDao = blskTemplateMainDao;
	}

	@Override
	public String saveTemplate(Map<String, String> map) throws Exception {
		String msg = "保存失败！";
		//templatemaininfo
		String headerLine = map.get("headInLine");
		String header = map.get("headName");
		String orderName = map.get("orderName");
		String onoLine = map.get("orderContxtInLine");
		String templeteName = map.get("templeteName");
		String templatetype = map.get("templatetype");
		
		//docinfo
		String choosefile = map.get("choosefile");
		
		//detailinfo
		String data = map.get("data");
		
		BlskTemplateMain blskTemplateMain = this.blskTemplateMainDao.getTemplate(header, orderName, templeteName, templatetype);
		
		if(blskTemplateMain == null) {
			BlskDocInfo blskDocInfo = this.saveTemplateDoc(map);
			
			blskTemplateMain = new BlskTemplateMain();
			blskTemplateMain.setDocid(blskDocInfo.getId());
			blskTemplateMain.setNo(templeteName);
			blskTemplateMain.setType(templatetype);
			blskTemplateMain.setOrderno(orderName);
			blskTemplateMain.setOnoLine(Long.valueOf(onoLine));
			blskTemplateMain.setHeaderLine(Long.valueOf(headerLine));
			blskTemplateMain.setHeader(header);
			blskTemplateMain.setIsvalidate("1");
			blskTemplateMain.setCreatetime(new Date());
			
			this.blskTemplateMainDao.save(blskTemplateMain);
			
			this.saveTemplateDetailm(data, templatetype, blskTemplateMain);
			
			msg = "模板保存成功！";
		}else {
			msg = "该模板已存在，请重新填写！";
		}
		
		return msg;
	}

	public void saveTemplateDetailm(String data, String templatetype, BlskTemplateMain blskTemplateMain) throws JSONException {
		
		JSONArray ja = new JSONArray(data);
		for(int i = 0; i < ja.length(); i++) {
			JSONObject info = ja.getJSONObject(i);
			String lineno = info.getString("LINENO");
			String linfname = info.getString("LINFNAME");
			String sysname = info.getString("SYSNAME");
			String isnull = info.getString("ISNULL");
			
			BlskTemplateDetail BlskTemplateDetail = new BlskTemplateDetail();
			BlskTemplateDetail.setBlskTemplateMain(blskTemplateMain);
			BlskTemplateDetail.setOHeader(sysname);
			BlskTemplateDetail.setTplHeader(linfname);
			BlskTemplateDetail.setType(templatetype);
			BlskTemplateDetail.setCreatetime(new Date());
			BlskTemplateDetail.setIsvalidate("1");
			
			this.blskTemplateDetailDao.save(BlskTemplateDetail);
		}
	}

	private BlskDocInfo saveTemplateDoc(Map<String, String> map) throws Exception {
		
		String headerLine = map.get("headInLine");
		String orderName = map.get("orderName");
		String onoLine = map.get("orderContxtInLine");
		String choosefile = map.get("choosefile");
		String data = map.get("data");
		
		String localPath = "E:/XdSystem/test/doc/";
		String filename = choosefile.substring(choosefile.lastIndexOf("\\")+1);  
		
		String filepath = localPath + filename;
		
		File file = new File(filepath);
		
		if(!file.exists()){
			file.createNewFile();
		}else {
			throw new Exception("该文件已上传，请重新选择文件！"); 
		}
		
		this.writeExcelFile(data, file, headerLine, orderName, onoLine);
		
		
		String serverPath = "C:/Users/Administrator/git/zlblsk/web/src/main/webapp/statics/frame/uploadfile/";
		String fix = ".xlsx";
		String fileNmae = file.getName();
		
		String tempServerFile = serverPath + fileNmae;
		
		File uploadFile = new File(tempServerFile);
		if(!uploadFile.exists()){
			uploadFile.createNewFile();
		}else {
			uploadFile.delete();
			uploadFile.createNewFile();
		}
		
		FileUtils.copyFile(file,uploadFile);
		
		
		BlskDocInfo blskDocInfo = new BlskDocInfo();
		blskDocInfo.setFileFix(fix);
		blskDocInfo.setFileName(file.getName());
		blskDocInfo.setFileSize(file.length() + "");
		blskDocInfo.setLocalPath(choosefile);
		blskDocInfo.setServerPath(tempServerFile);
		blskDocInfo.setIsvalidate("1");
		blskDocInfo.setCreatetime(new Date());
		
		BlskDocInfo blskDocInfos = blskDocInfoDao.save(blskDocInfo);
		
		return blskDocInfos;
	}

	private void writeExcelFile(String data, File file, String headerLine, String orderName, String onoLine) throws JSONException, IOException {
		
		int cells = Integer.parseInt(onoLine)-1;
		
		JSONArray ja = new JSONArray(data);
		int length = ja.length();
		
		FileOutputStream out = new FileOutputStream(file);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 1.创建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 1.1创建合并单元格对象
		CellRangeAddress callRangeAddress = new CellRangeAddress(0, 0, cells, cells+length-1);// 起始行,结束行,起始列,结束列
		// 1.2头标题样式
		HSSFCellStyle headStyle = createCellStyle(workbook, (short) 16);
		// 1.3列标题样式
		HSSFCellStyle colStyle = createCellStyle(workbook, (short) 13);
		// 2.创建工作表
		HSSFSheet sheet = workbook.createSheet(orderName);
		// 2.1加载合并单元格对象
		sheet.addMergedRegion(callRangeAddress);
		// 设置默认列宽
		sheet.setDefaultColumnWidth(25);
		// 3.创建行
		// 3.1创建头标题行;并且设置头标题
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(cells);

		// 加载单元格样式
		cell.setCellStyle(headStyle);
		cell.setCellValue(orderName);

		// 3.2创建列标题;并且设置列标题
		HSSFRow row2 = sheet.createRow(Integer.parseInt(headerLine)-1);
		
		
		for(int i = 0; i < length; i++) {
			JSONObject info = ja.getJSONObject(i);
			String lineno = info.getString("LINENO");
			String linfname = info.getString("LINFNAME");
			HSSFCell cell2 = row2.createCell(Integer.parseInt(lineno)-1);
			// 加载单元格样式
			cell2.setCellStyle(colStyle);
			cell2.setCellValue(linfname);
		}
		// 5.输出
		workbook.write(out);
		workbook.close();
		out.close();
		
	}
	
	
	public  HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontsize) {
		// TODO Auto-generated method stub
		HSSFCellStyle style = workbook.createCellStyle();
		// 创建字体
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints(fontsize);
		// 加载字体
		style.setFont(font);
		return style;
	}

}
