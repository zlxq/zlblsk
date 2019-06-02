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
		String headerLine = map.get("headInRow");
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
			String linename = info.getString("LINENAME");
			String sysname = info.getString("SYSNAME");
			
			BlskTemplateDetail BlskTemplateDetail = new BlskTemplateDetail();
			BlskTemplateDetail.setBlskTemplateMain(blskTemplateMain);
			BlskTemplateDetail.setLineno(Long.valueOf(lineno));
			BlskTemplateDetail.setOHeader(sysname);
			BlskTemplateDetail.setTplHeader(linename);
			BlskTemplateDetail.setType(templatetype);
			BlskTemplateDetail.setCreatetime(new Date());
			BlskTemplateDetail.setIsvalidate("1");
			
			this.blskTemplateDetailDao.save(BlskTemplateDetail);
		}
	}

	private BlskDocInfo saveTemplateDoc(Map<String, String> map) throws Exception {
		
		String headInRow = map.get("headInRow");
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
//			throw new Exception("该文件已上传，请重新选择文件！"); 
			file.delete();
			file.createNewFile();
		}
		
//		this.writeExcelFile(data, file, headerLine, orderName, onoLine);
		
		
		String serverPath = "C:/Users/Administrator/git/zlblsk/web/src/main/webapp/statics/frame/uploadfile/";
		String fix = filename.substring(filename.lastIndexOf(".") + 1);

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

	@Override
	public String getTemplate() {
		return this.blskTemplateMainDao.getTemplates();
	}

}
