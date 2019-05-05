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
<script type="text/javascript" src="<%=request.getContextPath()%>/moudles/rbac/menu/js/sysmenu.js"></script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	<div region="center" style="padding: 1px; overflow-y: hidden">
		<ul id="sysmenuview"></ul>
	</div>
	
	<div id="addmenu-window" title="编辑菜单" style="width: 600px; height: 400px;">
		<div style="padding: 20px 20px 20px 40px;">
			<form method="post">
				<table>
					<tr>
						<td>菜单编号：</td>
						<td><input class="easyui-textbox" name="zlxqMenu.menucode" required="true" style="width: 200px;" /></td>
					</tr>
					<tr>
						<td>菜单名称：</td>
						<td><input class="easyui-textbox" name="zlxqMenu.menuname" required="true" style="width: 200px;" /></td>
					</tr>
					<tr>
						<td>URL：</td>
						<td><input class="easyui-textbox" name="zlxqMenu.menuurl" style="width: 200px;" /></td>
					</tr>
					<tr>
						<td>菜单类型：</td>
						<td><select class="easyui-combobox" data-options="editable:false" name="zlxqMenu.menutype" required="true" style="width: 200px;">
								<option value="0" selected="selected">一级菜单</option>
								<option value="1">二级菜单</option>
								<option value="2">按钮</option>
								<option value="3">url</option>
						</select></td>
					</tr>
					<tr>
						<td>菜单排序：</td>
						<td><input class="easyui-numberbox" type="text" name="zlxqMenu.menusort" required="true" style="width: 200px;" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="text-align: center; padding: 10px; margin-top: 100px;">
			<a href="javascript:void(0)" onclick="saveMenu()" id="btn-save-menu" icon="icon-save">保存</a> <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel-menu" icon="icon-cancel"> 取消</a>
		</div>
	</div>
</body>
</html>