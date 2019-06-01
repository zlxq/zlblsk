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
	function printCKQrcodeFun() {
		var w = window.open();
		$.ajax({
			url : __ctxPath + '/qrcode/printQrcode.do',
			type : 'post',
			data : {
				qrtype : '500200'
			},
			beforeSend: function () {
			},
			success : function(e, f) {
				var m = eval('(' + e + ')');
				
				if (m.msg) {
// 					window.location.href = "http://localhost:8080/web/statics/file/qrcode/qrcode-500200.png";
					w.location.href = m.msg;
				}
			}
		});
	}
	function printRKQrcodeFun() {
		var w = window.open();
		$.ajax({
			url : __ctxPath + '/qrcode/printQrcode.do',
			type : 'post',
			data : {
				qrtype : '500100'
			},
			beforeSend: function () {
			},
			success : function(e, f) {
				var m = eval('(' + e + ')');
				
				if (m.msg) {
					w.location.href = m.msg;
				}
			}
		});
	}
	function printCHECKQrcodeFun() {
		var w = window.open();
		$.ajax({
			url : __ctxPath + '/qrcode/printQrcode.do',
			type : 'post',
			data : {
				qrtype : '500300'
			},
			beforeSend: function () {
			},
			success : function(e, f) {
				var m = eval('(' + e + ')');
				
				if (m.msg) {
					w.location.href = m.msg;
				}
			}
		});
	}
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	<div region="center" split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
		<div style="text-align: center; padding-top: 15%">
			<img style="width:30%; cursor: pointer;" onclick="printCKQrcodeFun()" src="<%=request.getContextPath()%>/statics/blsk/images/out-wh-qrcode-blsk.png">
			<img style="width:30%; cursor: pointer;" onclick="printRKQrcodeFun()" src="<%=request.getContextPath()%>/statics/blsk/images/in-wh-qrcode-blsk.png">
			<img style="width:30%; cursor: pointer;" onclick="printCHECKQrcodeFun()" src="<%=request.getContextPath()%>/statics/blsk/images/check-wh-qrcode-blsk.png">
		</div>
	</div>
</body>