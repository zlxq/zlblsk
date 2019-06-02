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
body {
	margin: 0;
	padding: 0;
}

html, body, .web_body_div {
	position: fixed;
	height: 100%;
	width: 100%;
}

/*Y坐标 上中下布局，上下固定中间填充 start*/
.web_top_divY {
	position: absolute;
	width: 100%;
	height: 50px;
	top: 0; /*绝对距顶高度*/
}

.web_center_divY {
	position: absolute;
	width: 100%;
	top: 50px;
	bottom: 50px;
}

.web_bottom_divY {
	position: absolute;
	width: 100%;
	height: 50px;
	bottom: 0; /*绝对距底高度*/
}
/*Y坐标 上中下布局，上下固定中间填充end*/

/*X坐标 上中下布局，左右固定中间填充start*/
.web_left_divX {
	position: absolute;
	width: 250px;
	height: 100%;
	left: 0;
}

.web_center_divX {
	position: absolute;
	height: 100%;
	left: 250px;
	right: 300px;
}

.web_right_divX {
	position: absolute;
	width: 300px;
	height: 100%;
	right: 0;
}

input, button, textarea {
	font-family: "Arial", "Tahoma", "微软雅黑", "雅黑";
	vertical-align: middle;
	margin: 8px;
	line-height: 18px;
	font-size: 18px;
	border-radius: 4px;
	outline: none;
}

ul {
	/* list-style-type: none; */
	margin: 0px;
	overflow:auto;
}

ul li a {
	display: block;
	width: 100%;
	background: #ccc;
}

ul li a:hover {
	background: #999;
}
</style>

<script>

	function clickA(data) {
		var id = data.id;
		
		var methodId = document.getElementById("methodId");
		var urlId = document.getElementById("urlId");
		var apinameId = document.getElementById("apinameId");
		var paramsId = document.getElementById("paramsId");
		var responseId = document.getElementById("responseId");
		
		methodId.value = 'Socket';
		urlId.value = '120.0.0.1';
		apinameId.value = '20019';
		paramsId.value = id;
		responseId.value = null;
	}
	
// 	window.onload = function() {
// 	 	$.ajax({
// 			url : __ctxPath + '/api/getApiList.do',
// 			type : 'post',
// 			data : {
				
// 			},
// 			beforeSend: function () {
// 				$.messager.progress({ 
// 					title: '提示', 
// 					msg: '正在处理,请稍候……', 
// 					text: '' 
// 				});
// 			},
// 			complete: function () {
// 				$.messager.progress('close');
// 			},
// 			success : function(e, f) {
// 				var m = eval('(' + e + ')');
				
// 				var rows = m.rows;

// 				var ul = document.getElementById('syncLi');
// 				for (var i = 0; i < rows.length; i++) {
// 					var li_1 = document.createElement("li");
// 					var a_1 = document.createElement("a");
// 					a_1.setAttribute("id",rows[i].METHOD + "@_@" + rows[i].URL + "@_@" + rows[i].APINAME + "@_@" + rows[i].PARAMS);
// 					a_1.setAttribute("href","#");
// 					a_1.setAttribute("onclick","clickA(this)");
// 					a_1.innerHTML = rows[i].APINAME;
// 					li_1.appendChild(a_1);
// 					ul.appendChild(li_1);
// 				}
// 			}
// 		});
// 	}
	
	function formsubmit() {
		var form = document.getElementById('apiSaveId');
		form.action=__ctxPath + '/api/saveApiInfo.do',
		form.submit();
	}
	
	function apiRequest() {
		var methodId = document.getElementById("methodId");
		var host = document.getElementById("urlId");
		var port = document.getElementById("apinameId");
		var funCode = document.getElementById("paramsId");
		var responseId = document.getElementById("responseId");
		
		$.ajax({
			url : __ctxPath + '/api/requestSocket.do',
			type : 'post',
			data : {
				host : host.value,
				port : port.value,
				funcode : funCode.value
			},
			beforeSend: function () {
				$.messager.progress({ 
					title: '提示', 
					msg: '正在处理,请稍候……', 
					text: '' 
				});
			},
			complete: function () {
				$.messager.progress('close');
			},
			success : function(e, f) {
				var m = eval('(' + e + ')');
				responseId.value = m.msg;
			}
		});
	}
</script>
</head>
<body>
	<div class="web_body_div">
		<div class="web_top_divY" style="text-align: center;">
			<font style="top: 50px; font-size: 30px; font-family: Tahoma;">库房API</font>
		</div>
		<div class="web_center_divY" style="padding: 10px; bottom: 20px">
			<div class="web_left_divX" style="background-color: #F0FFF0; border: 0px solid #000; margin-left: 10px">
				<div title="接口列表"><b>接口列表</b></div>
				<div style="height: 550px;overflow: auto;">
					<ul id="syncLi">
						<li><a id="0101" href="#" onclick="clickA(this)">传感器常连接</a></li>
						<li><a id="0102" href="#" onclick="clickA(this)">堆垛机常连接</a></li>
						<li><a id="0201" href="#" onclick="clickA(this)">货台传感器无货</a></li>
						<li><a id="0202" href="#" onclick="clickA(this)">货台传感器有货</a></li>
						<li><a id="0301" href="#" onclick="clickA(this)">货位传感器无货</a></li>
						<li><a id="0302" href="#" onclick="clickA(this)">货位传感器有货</a></li>
						<li><a id="0401" href="#" onclick="clickA(this)">堆垛机传感器无货</a></li>
						<li><a id="0402" href="#" onclick="clickA(this)">堆垛机传感器有货</a></li>
						<li><a id="0501" href="#" onclick="clickA(this)">堆垛机运行中</a></li>
						<li><a id="0502" href="#" onclick="clickA(this)">堆垛机停止</a></li>
						<li><a id="0503" href="#" onclick="clickA(this)">堆垛机归零</a></li>
					</ul>
				</div>
			</div>
			<div class="web_center_divX" style="margin-left: 20px; border: 0px solid #000; right: 30px">
				<form id="apiSaveId" method="post">
					<div style="margin-top: 20px">
						请求：<input id="methodId" type="text" name="zlxqApi.method" style="width: 200px; height: 35px" placeholder="Socket" value="Socket" /> 
						</br>
						地址：<input id="urlId" type="text" name="zlxqApi.url" size="20px" style="width: 500px; height: 35px"
							placeholder="127.0.0.1" value="" />
						</br>
						端口：<input id="apinameId" type="text" name="zlxqApi.apiname" style="width: 500px; height: 35px" placeholder="20019" /> 
					</div>
					<div>
						<div style="margin-bottom: 5px; margin-top: 5px">
							<font style="font-size: 25px;"><b>参数</b></font>
						</div>
						<div>
							<textarea id="paramsId" name="zlxqApi.params" rows="" cols="" style="width: 800px; height: 50px;"></textarea>
						</div>
					</div>
				</form>
				<div>
					<div style="margin-bottom: 5px;">
						<font style="font-size: 25px"><b>消息</b></font>
					</div>
					<div>
						<textarea id="responseId" rows="" cols="" style="width: 800px; height: 80px;"></textarea>
					</div>
				</div>
				<div style="width: 800px; text-align: center;">
					<input type="submit" onclick="apiRequest()" onmouseover="this.style.backgroundPosition='left -37px'" onmouseout="this.style.backgroundPosition='left top'"
						style="background: url(./submit1.jpg) no-repeat left top; color: #FFF; border: 0; margin-top: 10px; width: 143px; height: 35px;" value="提交请求" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>