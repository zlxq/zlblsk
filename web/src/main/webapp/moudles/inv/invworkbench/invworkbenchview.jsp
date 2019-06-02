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
<style type="text/css">
	span {
		margin-left: 10px
	}	
</style>
<script type="text/javascript">
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/moudles/inv/invworkbench/js/invworkbench.js"></script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	
	<div region="north" split="true" style="background-color: #eee; height: 250px;padding: 1px; overflow-y: hidden">
<!-- 		style="display: none;"  -->
<!-- document.getElementById("div-qrcode-id").style.display="none";//隐藏 -->
<!-- document.getElementById("div-qrcode-id").style.display="";//显示 -->
		<div id="div-qrcode-id" style="text-align: center; padding-top: 10%">
			<span>扫描执行码:</span>
	    	<input class="easyui-textbox" id="qrcodeId"	data-options="prompt:'请输入执行码'" style="width: 300px; border:1px solid #ccc;">
		</div>
		
		<div id="div-CK-id" style="padding: 10px; display: none;">
			<div>
				<span style="display: inline;">出库模式:</span>
			    <input type="radio" name="sex" value="1" /><span>自动</span>
			    <input type="radio" name="sex" value="2" /><span>手动</span>
			</div>
			<br/>
			<div>
				<span>执行编码:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
				<span>出库单据:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
				<span>货台编码:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
			</div>
			<br/>
			<span>物料编码:</span>
	    	<input class="easyui-textbox" data-options="prompt:'请输入执行码'" style="width: 200px; border:1px solid #ccc;">
		</div>
		
		<div id="div-RK-id" style="padding: 10px; display: none;">
			<br/>
			<div>
				<span>执行编码:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
				<span>入库单据:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
				<span>货台编码:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
			</div>
			<br/>
			<div>
				<span>物料编码:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
			</div>
		</div>
		
		<div id="div-PD-id" style="padding: 10px; display: none;">
			<div>
				<span style="display: inline;">盘点规则:</span>
			    <input type="radio" name="sex" value="1" /><span>货品为盘点单元</span>
			    <input type="radio" name="sex" value="2" /><span>巷道为盘点单元</span>
			</div>
			<br/>
			<div>
				<span>选择巷道:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
				<span>选择货品:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
			</div>
			<br/>
			<div>
				<span style="display: inline;">抽盘规则:</span>
			    <input type="radio" name="sex" value="1" /><span>指定抽盘单元</span>
			    <input type="radio" name="sex" value="2" /><span>随机生成抽盘单元</span>
			</div>
			<br/>
			<div>
				<span>抽盘巷道:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
				<span>抽盘比例:</span>
		    	<input class="easyui-textbox" style="width: 200px; border:1px solid #ccc;">
			</div>
			<br/>
			<div>
				<span style="display: inline;">是否抽盘上次抽盘货品:</span>
			    <input type="radio" name="sex" value="1" /><span>是</span>
			    <input type="radio" name="sex" value="2" /><span>否</span>
			</div>
		</div>
	</div>

	<div region="center" title="执行明细" split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" style="border: 0;">
				<div id="sysdeptgrid" fit="true"></div>
			</div>
			<div data-options="region:'east'" split="true" title="设备执行明细" style="width: 400px;background-color: #eee; border: 0;">
				123123
			</div>
		</div>
	</div>
</body>
</html>