package com.blsk.inv.space.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.blsk.inv.equip.dao.BlskEquipInfoDao;
import com.blsk.inv.space.dao.BlskDocInfoDao;
import com.blsk.inv.space.dao.BlskInvSpaceDao;
import com.blsk.inv.space.dao.BlskSpaceAddressDao;
import com.blsk.inv.space.dao.BlskSpaceEquipDao;
import com.blsk.inv.space.dao.BlskSpaceFileDao;
import com.blsk.inv.space.dao.BlskSpacePropertyDao;
import com.blsk.inv.space.service.BlskInvSpaceService;
import com.framework.util.WebAppUtil;
import com.zlxq.rbac.base.core.service.impl.BaseServiceImpl;
import com.zlxq.rbac.base.util.ConstantRBAC;
import com.zlxq.rbac.base.util.UserUtil;

import pojo.BlskDocInfo;
import pojo.BlskEquipInfo;
import pojo.BlskInvSpace;
import pojo.BlskSpaceAddress;
import pojo.BlskSpaceEquip;
import pojo.BlskSpaceFile;
import pojo.BlskSpaceProperty;

public class BlskInvSpaceServiceImpl extends BaseServiceImpl<BlskInvSpace> implements BlskInvSpaceService {

	private BlskInvSpaceDao blskInvSpaceDao;
	
	@Resource
	private BlskSpaceFileDao blskSpaceFileDao;
	
	@Resource
	private BlskDocInfoDao blskDocInfoDao;
	
	@Resource
	private BlskEquipInfoDao blskEquipInfoDao;
	
	@Resource
	private BlskSpaceEquipDao blskSpaceEquipDao;
	
	@Resource
	private BlskSpaceAddressDao blskSpaceAddressDao;
	
	@Resource
	private BlskSpacePropertyDao blskSpacePropertyDao;
	
	public BlskInvSpaceServiceImpl(BlskInvSpaceDao blskInvSpaceDao) {
		super(blskInvSpaceDao);
		this.blskInvSpaceDao = blskInvSpaceDao;
	}
	@Override
	public String saveInvSpaceInfo(String dataArray, String storeRoom, String storeRoom_unit, String svg, String spacex, String spacey) throws JSONException, IOException {
		
		String msg = "保存失败！";
		//保存库房信息
		
		BlskInvSpace spaceEntry = null;
		
		BlskInvSpace unitEntry = null;
		
		JSONArray ja = new JSONArray(dataArray);
		for (int i = 0; i < ja.length(); i++) {
			JSONObject space = ja.getJSONObject(i);
			String rect = space.getString("rect");
			String lor = space.getString("lor");
			String type = space.getString("type");
			String level_num = space.getString("level_num");
			String lattice_num = space.getString("lattice_num");
			String rectangle_long = space.getString("rectangle_long");
			String rectangle_width = space.getString("rectangle_width");
			String rectangle_height = space.getString("rectangle_height");
			String invfloor = space.getString("invfloor");
			String invrow = space.getString("invrow");
			String invcolumn = space.getString("invcolumn");
			String isclose = space.getString("isclose");
			String runCode = space.getString("runCode");//执行码
			String inStoreRule = space.getString("inStoreRule");//入库规则
			String equipId = space.getString("stackerId");//堆垛机
			String materialId = space.getString("materialId");//物料
			
			spaceEntry = spaceEntry == null ? this.getSpaceEntry(storeRoom, spacex, spacey): spaceEntry;
			
			unitEntry = unitEntry == null ?  this.getUnitEntry(spaceEntry, storeRoom, storeRoom_unit, svg): unitEntry;
			
			BlskInvSpace blskInvSpace = blskInvSpaceDao.getInvColumn(rect, unitEntry.getId(), type);
			if(blskInvSpace == null) {
				blskInvSpace = new BlskInvSpace();
				blskInvSpace.setBlskInvSpace(unitEntry);
				blskInvSpace.setNo(rect);
				blskInvSpace.setName(rect);
				blskInvSpace.setType(type);
				blskInvSpace.setSapceName(storeRoom);
				blskInvSpace.setUnitname(storeRoom_unit);
				blskInvSpace.setAllname(rect);
				blskInvSpace.setLor(lor);
				blskInvSpace.setInvfloor(invfloor);
				blskInvSpace.setInvrow(invrow);
				blskInvSpace.setInvcolumn(invcolumn);
				blskInvSpace.setSvgid(rect);
				blskInvSpace.setIsclose(isclose);
				blskInvSpace.setLength(Long.valueOf(rectangle_long));
				blskInvSpace.setWidth(Long.valueOf(rectangle_width));
				blskInvSpace.setHight(Long.valueOf(rectangle_height));
				blskInvSpace.setRowFloors(Long.valueOf(level_num));
				blskInvSpace.setFloorColumns(Long.valueOf(lattice_num));
				blskInvSpace.setDeptid(UserUtil.getCompanyId());//后补
				blskInvSpace.setCreator(UserUtil.getUserId());//后补
				blskInvSpace.setCreatetime(new Date());
				blskInvSpace.setIsvalidate("1");
				blskInvSpaceDao.save(blskInvSpace);
				
			}else{
				blskInvSpace.setIsclose(isclose);
				blskInvSpace.setLength(Long.valueOf(rectangle_long));
				blskInvSpace.setWidth(Long.valueOf(rectangle_width));
				blskInvSpace.setHight(Long.valueOf(rectangle_height));
				blskInvSpace.setRowFloors(Long.valueOf(level_num));
				blskInvSpace.setFloorColumns(Long.valueOf(lattice_num));
				blskInvSpace.setDeptid(UserUtil.getCompanyId());//后补
				blskInvSpace.setCreator(UserUtil.getUserId());//后补
				blskInvSpace.setUpdatetime(new Date());
				blskInvSpaceDao.save(blskInvSpace);
			}
					
			if(type.equals("platform") || type.equals("stocker")) {
				this.saveSpaceEquip(equipId, lor, spaceEntry, unitEntry, isclose);
			}else {
				this.saveInvSpaceProperty(materialId, runCode, inStoreRule, blskInvSpace);
			}
			
			
			msg = "保存成功！";
		}
		
		
		
		
		return msg;
	}
	
	
	private void saveSpaceEquip(String equipId, String lor, BlskInvSpace spaceEntry, BlskInvSpace unitEntry, String isclose) {
		BlskEquipInfo blskEquipInfo = this.blskEquipInfoDao.findByPk(Long.valueOf(equipId));
		
		BlskSpaceEquip blskSpaceEquip = this.blskSpaceEquipDao.getSpaceEquip(spaceEntry, unitEntry, equipId, lor);
		if(blskSpaceEquip == null) {
			blskSpaceEquip = new BlskSpaceEquip();
			blskSpaceEquip.setBlskEquipInfo(blskEquipInfo);
			blskSpaceEquip.setBlskInvSpace(spaceEntry);
			blskSpaceEquip.setUnitid(unitEntry.getId());
			blskSpaceEquip.setCreator(UserUtil.getUserId());
			blskSpaceEquip.setLor(lor);
			blskSpaceEquip.setState(isclose);
			blskSpaceEquip.setCreatetime(new Date());
			blskSpaceEquip.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
			blskSpaceEquipDao.save(blskSpaceEquip);
		}
		
		
		
	}
	private void saveInvSpaceProperty(String materialId, String runCode, String inStoreRule,
			BlskInvSpace blskInvSpace) {
		BlskSpaceProperty BlskSpaceProperty = this.blskSpacePropertyDao.getProperty(blskInvSpace.getId(), materialId, runCode, inStoreRule);
		
		if(BlskSpaceProperty == null) {
			BlskSpaceProperty = new BlskSpaceProperty();
			BlskSpaceProperty.setBlskInvSpace(blskInvSpace);
			BlskSpaceProperty.setCreator(UserUtil.getUserId());
			BlskSpaceProperty.setDeptid(UserUtil.getCompanyId());
			BlskSpaceProperty.setMaterialid(Long.valueOf(materialId));
			BlskSpaceProperty.setRuncode(runCode);
			BlskSpaceProperty.setStorerule(inStoreRule);
			BlskSpaceProperty.setCreatetime(new Date());
			BlskSpaceProperty.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
			blskSpacePropertyDao.save(BlskSpaceProperty);
		}
		
		
		
	}
	public BlskInvSpace getUnitEntry(BlskInvSpace spaceEntry, String storeRoom, String storeRoom_unit, String svg) throws IOException {
		
		BlskInvSpace unitEntry = blskInvSpaceDao.getSpaceUnit(spaceEntry.getId(), storeRoom, storeRoom_unit);
		if(unitEntry == null){
			unitEntry = new BlskInvSpace();
			unitEntry.setBlskInvSpace(spaceEntry);
			unitEntry.setNo(new Date().toString());
			unitEntry.setName(storeRoom_unit);
			unitEntry.setSapceName(storeRoom);
			unitEntry.setUnitname(storeRoom_unit);
			unitEntry.setType("单元");
			unitEntry.setAllname(storeRoom_unit);
			unitEntry.setDeptid(Long.valueOf("12346589"));//后补
			unitEntry.setCreator(Long.valueOf("12346589"));//后补
			unitEntry.setCreatetime(new Date());
			unitEntry.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
			blskInvSpaceDao.save(unitEntry);
		}
		
		this.uploadSvgFile(unitEntry, svg);
		return unitEntry;
	}
	
	
	public void uploadSvgFile(BlskInvSpace unitEntry, String svg) throws IOException {
		// 上传文件
		String serverPath = WebAppUtil.getGetCtxPath();
		String localPath = "E:/XdSystem/test/doc/";
		serverPath = serverPath + "/statics/uploadfile/";
//		String serverPath = "C:/Users/Administrator/git/zlblsk/web/src/main/webapp/statics/frame/uploadfile/";
		String fix = ".svg";
		String fileNmae = unitEntry.getSapceName() + "_" + unitEntry.getName() + fix;
		
		String tempFile = localPath + fileNmae;
		
		String tempServerFile = serverPath + fileNmae;
		
		File file = new File(tempFile);
		if(!file.exists()) {
			file.getParentFile().mkdirs();

		    try {
		    	file.createNewFile();
		    } catch (IOException var10) {
		     var10.printStackTrace();
		    }
		}else {
			file.delete();
			file.createNewFile();
		}
		this.writeFileContent(file, svg);
		
		File uploadFile = new File(tempServerFile);
		if(!uploadFile.exists()){
			uploadFile.getParentFile().mkdirs();

		    try {
		    	uploadFile.createNewFile();
		    } catch (IOException var10) {
		    	var10.printStackTrace();
		    }
		}else {
			uploadFile.delete();
			uploadFile.createNewFile();
		}
		
		FileUtils.copyFile(file,uploadFile);
		
		this.saveFile(unitEntry, uploadFile, localPath, serverPath, fix);
		
		System.out.println("上传成功！！");
		
	}
	public void saveFile(BlskInvSpace unitEntry, File uploadFile, String localPath, String serverPath, String fix) {
		
		BlskDocInfo blskDocInfo = new BlskDocInfo();
		blskDocInfo.setFileName(uploadFile.getName());
		blskDocInfo.setFileFix(fix);
		blskDocInfo.setFileSize(uploadFile.length() + "");
		blskDocInfo.setLocalPath(localPath + uploadFile.getName());
		blskDocInfo.setServerPath(serverPath + uploadFile.getName());
		blskDocInfo.setCreatetime(new Date());
		blskDocInfo.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
		blskDocInfoDao.save(blskDocInfo);
		
		BlskSpaceFile blskSpaceFile = new BlskSpaceFile();
		blskSpaceFile.setBlskDocInfo(blskDocInfo);
		blskSpaceFile.setBlskInvSpace(unitEntry);
		blskSpaceFile.setCreatetime(new Date());
		blskSpaceFile.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
		blskSpaceFileDao.save(blskSpaceFile);
		
	}
	public void writeFileContent(File file, String svg) throws IOException {
		
		String filein = svg+"\r\n";//新写入的行，换行
        String temp  = "";
		
		
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            
            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);
            
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
            	fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
	}
	public BlskInvSpace getSpaceEntry(String storeRoom, String spacex, String spacey) throws UnknownHostException {
		
		 BlskInvSpace spaceEntry = blskInvSpaceDao.getSpace(storeRoom);
		if(spaceEntry == null){
			spaceEntry = new BlskInvSpace();
			spaceEntry.setSapceName(storeRoom);
			spaceEntry.setNo(new Date().toString());
			spaceEntry.setName(storeRoom);
			spaceEntry.setType("库房");
			spaceEntry.setAllname(storeRoom);
			spaceEntry.setDeptid(UserUtil.getCompanyId());//后补
			spaceEntry.setCreator(UserUtil.getUserId());//后补
			spaceEntry.setCreatetime(new Date());
			spaceEntry.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
			blskInvSpaceDao.save(spaceEntry);
			
			BlskSpaceAddress blskSpaceAddress = new BlskSpaceAddress();
			blskSpaceAddress.setCreator(UserUtil.getUserId());
			blskSpaceAddress.setDeptid(UserUtil.getCompanyId());
			blskSpaceAddress.setPartyid(UserUtil.getCompanyId());
			blskSpaceAddress.setBlskInvSpace(spaceEntry);
			blskSpaceAddress.setIp(InetAddress.getLocalHost().toString());
			blskSpaceAddress.setLongitude(spacey);
			blskSpaceAddress.setLatitude(spacex);
			blskSpaceAddress.setCreatetime(new Date());
			blskSpaceAddress.setIsvalidate(ConstantRBAC.Y_ISVALIDATE);
			blskSpaceAddressDao.save(blskSpaceAddress);
			
		}
		return spaceEntry;
	}
	@Override
	public String getSpaceAddress() {
		return this.blskSpaceAddressDao.getSpaceAddress();
	}

}
