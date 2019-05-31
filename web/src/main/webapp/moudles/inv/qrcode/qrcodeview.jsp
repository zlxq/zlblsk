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
<script type="text/javascript">
	function printQrcodeFun() {
		var w = window.open();
		$.ajax({
			url : __ctxPath + '/qrcode/printQrcode.do',
			type : 'post',
			data : {
			},
			beforeSend: function () {
			},
			success : function(e, f) {
				var m = eval('(' + e + ')');
				
				if (m.msg) {
					w.location.href = "C:\\qrcode\\qrcode.png";
				}
			}
		});
	}
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	<div region="center" split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
		<div style="text-align: center; padding-top: 10%">
			<img style="cursor: pointer;" onclick="printQrcodeFun()" src="<%=request.getContextPath()%>/statics/blsk/images/qrcode-blsk-print.png">
		</div>
	</div>
</body>