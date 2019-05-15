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
<script type="text/javascript" src="<%=request.getContextPath()%>/moudles/rbac/dict/js/sysdict.js"></script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	
	<div region="west" title="字典树" split="true" style="width: 250px;padding: 1px; overflow-y: hidden">
		<ul id="sysdicttree"></ul>
	</div>

	<div region="center" split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
		<div id="sysdictgrid" fit="true"></div>
	</div>
	
	<div id="sysdictform-window" title="编辑字典" style="width: 600px; height: 400px;">
		<div style="padding: 20px 20px 20px 40px;">
			<form method="post">
				<table>
					<tr>
						<td>字典编号：</td>
						<td><input class="easyui-textbox" name="zlxqDictionary.dicCode" required="true" style="width: 200px;" /></td>
					</tr>
					<tr>
						<td>字典名称：</td>
						<td><input class="easyui-textbox" name="zlxqDictionary.dicName" required="true" style="width: 200px;" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="text-align: center; padding: 10px; margin-top: 100px;">
			<a href="javascript:void(0)" onclick="saveDictFun()" id="btn-save-dict" icon="icon-save">保存</a> <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel-dict" icon="icon-cancel"> 取消</a>
		</div>
	</div>
</body>
</html>