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
<script type="text/javascript" src="<%=request.getContextPath()%>/moudles/rbac/party/js/sysparty.js"></script>
<script type="text/javascript">

	function doSearch() {
		grid.datagrid('load',{
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
	<div region="west" title="组织树" split="true" style="width: 250px;padding: 1px; overflow-y: hidden">
		<ul id="sysdetppartytree"></ul>
	</div>
	
	<div region="center" style="padding: 1px; background: #eee; overflow-y: hidden">
	
		<div class="easyui-layout" data-options="fit:true">
			<div region="north" style="padding: 1px; background: #eee; overflow-y: hidden">
				<div id="tb" style="padding:1px">
			    	<span>编号:</span>
			    	<input type="text" id="partyno" style="border:1px solid #ccc">
			    	<span>姓名:</span>
			    	<input id="partyname" style="border:1px solid #ccc">
			    	<a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doSearch()" icon="icon-search">查询</a>
			    	<a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doReset()" icon="icon-clear">重置</a>
		    	</div>
			</div>
			<div region="center" split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
				<div id="syspartygrid" fit="true"></div>
			</div>
			
		</div>
	</div>
	
	<div id="addparty-window" title="编辑菜单" style="width: 600px; height: 400px;">
		<div style="padding: 20px 20px 20px 40px;">
			<form method="post">
				<table>
					<tr>
						<td>编号：</td>
						<td><input class="easyui-textbox" name="zlxqParty.partyno" required="true" style="width: 200px;" /></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input class="easyui-textbox" name="zlxqParty.partyname" required="true" style="width: 200px;" /></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><select class="easyui-combobox" data-options="editable:false" name="zlxqParty.sex" required="true" style="width: 200px;">
								<option value="0" selected="selected">男</option>
								<option value="1">女</option>
						</select></td>
					</tr>
					<tr>
						<td>邮箱：</td>
						<td><input class="easyui-textbox" name="zlxqParty.email" required="true" style="width: 200px;" /></td>
					</tr>
					<tr>
						<td>电话：</td>
						<td><input class="easyui-numberbox" name="zlxqParty.tel" required="true" style="width: 200px;" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="text-align: center; padding: 5px;">
			<a href="javascript:void(0)" onclick="savePartyFun()" id="btn-save-party" icon="icon-save">保存</a> <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel-party" icon="icon-cancel"> 取消</a>
		</div>
	</div>
	<!-- 导入数据弹窗 -->

<!-- 	<div id="excelparty-window" class="easyui-panel" title="上传文件"
		style="width: 450px; height: 200px; padding: 30px 30px 30px 30px;">
		<div style="margin-bottom: 20px">
			<div>文件：</div>
			<input id="fileImport" class="easyui-filebox" name="myfile"
				data-options="prompt:'选择文件...'" style="width: 100%">
		</div>
		<div>
			<a id="uploadFile" class="easyui-linkbutton"
				onclick="saveImportFun()" href="javascript:void(0)">上传</a> <a
				class="easyui-linkbutton" onclick="closeImportClick()"
				href="javascript:void(0)" href="javascript:void(0)">关闭</a>
		</div>

	</div> -->


	<div id="excelparty-window" title="excel导入"
		style="width: 600px; height: 400px;">
		<form method="post"enctype="multipart/form-data">
		<div style="margin-bottom: 10px; margin: 80px 80px 0px 80px">
				<div>文件：</div>
				<input id="importfile" class="easyui-filebox" name="myfile" required="true"
					data-options="prompt:'选择文件...'" style="width: 400px;">
		</div>
		<div style="text-align: center; padding: 5px;">
			<a id="uploadFile" class="easyui-linkbutton"
				onclick="saveImportFun()" href="javascript:void(0)">上传</a> <a
				class="easyui-linkbutton" onclick="closeImportClick()"
				href="javascript:void(0)" href="javascript:void(0)">关闭</a>
		</div>
		</form>
		<!-- <div style="padding: 20px 20px 20px 40px;">
			<form method="post">
				<table style="margin:5px;height:70px;">
		            <tr>
		                <td>请选择文件</td>
		                <td width="5px;"></td>
		                <td><input type="file" class="easyui-filebox" id="fileImport" name="myfile" style="width:260px;"></td>
		                <td></td>
		            </tr>
           
              </table>
        <div style="text-align: center; padding: 5px;">
            <a id="uploadFile" class="easyui-linkbutton" onclick="saveImportFun()" href="javascript:void(0)">上传</a>
            <a class="easyui-linkbutton" onclick="closeImportClick()" href="javascript:void(0)" href="javascript:void(0)">关闭</a>
        </div>
			</form>
		</div>
		 -->
	</div>
</body>
</html>