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
<script type="text/javascript" src="<%=request.getContextPath()%>/moudles/inv/invorder/js/invorder.js"></script>
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
	
	<div region="west" split="true" style="width: 250px;padding: 1px; overflow-y: hidden">
		<div class="easyui-layout" data-options="fit:true">
			<div region="north" style="padding: 1px; background: #eee; overflow-y: hidden">
				<div id="tb" style="padding:10px">
			    	<span>单据编号:</span>
			    	<input class="easyui-textbox" type="text" id="billno" style="border:1px solid #ccc">
			    	<span>单据类型:</span>
			    	<input class="easyui-textbox" id="billtype" style="border:1px solid #ccc">
			    	<a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doSearch()" icon="icon-search">查询</a>
			    	<a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doReset()" icon="icon-clear">重置</a>
		    	</div>
			</div>
			<div region="center" split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
				<div id="invordergrid" fit="true"></div>
			</div>
		</div>
	</div>
	</div>

	<div region="center" split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
		<div class="easyui-layout" data-options="fit:true">
			<div region="north" style="padding: 1px; background: #eee; overflow-y: hidden">
				<div id="tb" style="padding:1px">
			    	<span>组织编号:</span>
			    	<input type="text" id="partyno" style="border:1px solid #ccc">
			    	<span>组织名称:</span>
			    	<input id="partyname" style="border:1px solid #ccc">
			    	<a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doSearch()" icon="icon-search">查询</a>
			    	<a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doReset()" icon="icon-clear">重置</a>
		    	</div>
			</div>
			<div region="center" split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
				<div id="sysdeptgrid" fit="true"></div>
			</div>
		</div>
	</div>
</body>
</html>