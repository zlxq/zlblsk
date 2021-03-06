<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/statics/frame/js/json/json.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var __ctxPath="<%=request.getContextPath()%>";
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/moudles/inv/material/js/material.js"></script>
<script type="text/javascript">

	function doSearch() {
		materialgrid.datagrid('load',{
			partyno: $('#partyno').val(),
			partyname: $('#partyname').val()
		});
	}
	
	function doReset() {
		$('#partyno').val("");
		$('#partyname').val("");
	}
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	<div region="center" split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
		<div class="easyui-layout" data-options="fit:true">
			<div region="north" style="padding: 10px; background: #eee; overflow-y: hidden">
				<div id="tb" style="padding:1px">
			    	<span>物料编码:</span>
			    	<input class="easyui-textbox" id="materialCodeId" style="border:1px solid #ccc">
			    	<span>物料名称:</span>
			    	<input class="easyui-textbox" id="materialNameId" style="border:1px solid #ccc">
			    	<a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doSearch()" icon="icon-search">查询</a>
			    	<a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doReset()" icon="icon-clear">重置</a>
		    	</div>
			</div>
			<div region="center" split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
				<div id="materialgrid" fit="true"></div>
			</div>
		</div>
	</div>
	
	<div id="materialform-window" title="编辑设备信息" style="padding: 5px">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" style="border: 0;">
				<div style="padding: 20px 20px 20px 40px;">
					<form method="post">
						<table>
							<tr>
								<td>物料编码：</td>
								<td><input class="easyui-textbox" name="blskMaterialInfo.code" required="true" style="width: 200px;" /></td>
							</tr>
							<tr>
								<td>型号规格：</td>
								<td><input class="easyui-textbox" name="blskMaterialInfo.model" required="true" style="width: 200px;" /></td>
							</tr>
							<tr>
								<td>物料名称：</td>
								<td><input class="easyui-textbox" name="blskMaterialInfo.name" required="true" style="width: 200px;" /></td>
							</tr>
							<tr>
								<td>计量单位：</td>
								<td><input class="easyui-textbox" name="blskMaterialInfo.unit" required="true" style="width: 200px;" /></td>
							</tr>
							<tr>
								<td>长：</td>
								<td><input class="easyui-textbox" name="blskMaterialInfo.length" required="true" style="width: 200px;" /></td>
							</tr>
							<tr>
								<td>宽：</td>
								<td><input class="easyui-textbox" name="blskMaterialInfo.width" required="true" style="width: 200px;" /></td>
							</tr>
							<tr>
								<td>高：</td>
								<td><input class="easyui-textbox" name="blskMaterialInfo.height" required="true" style="width: 200px;" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div data-options="region:'south'" style="background-color: #C0C0C0; padding: 5px 0px 20px 0px; overflow-y: hidden" scroll="no">
				<div style="text-align: center;">
					<a href="javascript:void(0)" onclick="saveFun()" id="btn-save-material" icon="icon-save">保存</a> <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel-material" icon="icon-cancel"> 取消</a>
				</div>
			</div>
		</div>
	</div>
</body>