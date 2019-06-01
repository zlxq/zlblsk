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
<script type="text/javascript" src="<%=request.getContextPath()%>/moudles/inv/template/js/template.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/datagrid-cellediting.js"></script>

</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	<div region="north" style="padding: 1px; background: #eee; overflow-y: hidden">
		<div id="tb" style="padding:1px">
		<table cellspacing="9">
	    	<tr>
	    	<td>表头行号：<input type="text" name="head_rownm" id="headInLine" nullmsg="请输入信息"/></td>
	    	<td>单据号所显示的名称：<input type="text" name="order_name" id="orderName" nullmsg="请输入信息"/></td>
	    	<td>模板类型：<select id="template_type" style="width: 120px;" nullmsg="请输选择信息">
									<option value=" " selected>-请选择-</option>
									<option value="1" >出库</option>
									<option value="2">入库</option>
									<option value="3">盘点</option>
							</select>
			</td>
	    	</tr>
	    	<tr>
	    	<td>选择文件：<input type="file" name="chooseFile" id="choosefile" nullmsg="请输入信息"/></td>
	    	<td>单据号内容所在列：<input type="text" name="ordercontext_line" id="orderContxtInLine" nullmsg="请输入信息"/></td>
	    	<td>模板名称：<input type="text" name="templeteName" id="templeteName" nullmsg="请输入信息"/></td>
	    	</tr>
	    	<tr>
	    	<td><a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doReset()" icon="icon-clear">重置</a></td>
	    	</tr>
	    	</table>
    	</div>
	</div>
	<div region="center" style="padding: 1px; background: #eee; overflow-y: hidden">
		<div id="templategrid" fit="true"></div>
	</div>
</body>
</html>