<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<title>XX管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/statics/frame/js/json/json.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript">
	var __ctxPath = "<%=request.getContextPath()%>";
</script>
<script type="text/javascript">
	$(function() {
		$('#btn-save-password,#btn-cancel-password').linkbutton();
		win = $('#syseditpassword-window').window({
			closed : true,
			modal : true,
			shadow : true,
			minimizable:false,
			maximizable:false,
			collapsible:false,
			closable : false
		});
		form = win.find('form');
		
		InitLeftMenu();
		$('body').layout();
	})
	
	var win;
	var form;

	function InitLeftMenu() {
		$('.easyui-accordion li a').click(function() {
			var tabTitle = $(this).text();
			var url = $(this).attr("way");
			addTab(tabTitle, url);
			$('.easyui-accordion li div').removeClass("selected");
			$(this).parent().addClass("selected");
		}).hover(function() {
			$(this).parent().addClass("hover");
		}, function() {
			$(this).parent().removeClass("hover");
		});
	}

	function addTab(subtitle, url) {
		if (!$('#zlxqtabs').tabs('exists', subtitle)) {
			$('#zlxqtabs').tabs('add', {
				title : subtitle,
				content : createFrame(url),
				closable : true,
				width : $('#mainPanle').width() - 10,
				height : $('#mainPanle').height() - 26
			});
		} else {
			$('#zlxqtabs').tabs('select', subtitle);
		}
	}

	function createFrame(url) {
		var s = '<iframe name="mainFrame" scrolling="no" frameborder="0" src="${rootPath }/'
				+ url + '" style="padding: 5px;width:99%;height:97.8%"></iframe>';
		return s;
	}
	
	function layout() {
		$.post(__ctxPath +"/layout.do",function(result){
			window.location.href=__ctxPath +"/index.jsp";
		  });
	}
	
	function editPasswordFun() {
		win.window('open');
	}
	
	function closeWindow() {
		win.window('close');
	}
	
	function savePasswordFun() {
		form.form('submit', {
			url : __ctxPath + "/account/editPassword.do",
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(e, f) {
				win.window('close');
				form.form('clear');
				var m = eval('(' + e + ')');
				$.messager.alert('提示', m.msg, 'info');
			}
		});
		/* form.action = __ctxPath + "/account/editPassword.do";
		form.submit(function() {
			form.serialize(),
			function(result, status) {
				debugger
			}
		}); */
	}
	
	function loadFun() {
		$.ajax({
			url : __ctxPath + '/menu/getMenuPage.do',
			type : 'post',
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
			}
		});
	}
</script>
</head>
<body style="width:100%;height:100%;" onload="loadFun()">
	<div class="easyui-layout" data-options="fit:true" style="margin: 0; padding: 0;">
		<div data-options="region:'north'" style="overflow: hidden; height: 30px; background: #D2E0F2 repeat-x center 50%; line-height: 30px; color: #fff;">
			<div style="float:left">
			<img style="position:fixed;" src="<%=request.getContextPath() %>/frame/images/logo1.png" height="4%" width="5%" />
			</div>
			<div style="float:right; margin-right:30px">
				<font color="black">欢迎:<a href="#" onclick="editPasswordFun()">系统管理员<!-- ${user.getUsername() } --></a></font>
				|
				<a href="javascript:;" onclick="layout()">退出</a>
			</div>
		</div>
		<div data-options="region:'south'" style="height: 20px; background: #D2E0F2;">
			<div style="text-align: center; font-weight: bold">源助教管理系统</div>
		</div>
		<div data-options="region:'west',split:true" title="导航菜单" style="width: 250px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">

				<c:forEach var="menuList" items="${user.menuList }">
					<div title="${menuList.menuname }" iconCls="icon-ok" selected="true" style="overflow: auto; padding: 10px;">
					<ul class="easyui-tree">
					<c:forEach var="cmenuList" items="${menuList.czlxqMenu }">
						<li><a way="${cmenuList.menuurl }" target="mainFrame">${cmenuList.menuname }</a></li>
					</c:forEach>
					</ul>
				</div>
				</c:forEach>
			</div>
		</div>
		<div data-options="region:'center',iconCls:'icon-ok',border:false">
			<div id="zlxqtabs" class="easyui-tabs" data-options="fit:true">
				<div title="主页" style="padding: 10px;">
					<div style="margin-left: 30px">
						<div>
							<span><h2>模板下载：</h2></span>
						</div>
						<a href="<%=request.getContextPath()%>/doc/excelModelXLS.xls"><h3>试卷模板(2003版本).xls</h3></a>
						<a href="<%=request.getContextPath()%>/doc/excelModelXLSX.xlsx"><h3>试卷模板(2007版本).xlsx</h3></a>
					</div>
				</div>
			</div>
		</div>
		
		<div id="syseditpassword-window" title="修改密码" style="width: 600px; height: 400px;">
			<div style="padding: 20px 20px 20px 40px;">
				<form id="editPasswordFormId" method="post">
				<table>
					<tr>
						<td>旧密码：</td>
						<td><input class="easyui-textbox" name="zlxqAccount.opassword" required="true" style="width: 200px;" /></td>
					</tr>
					<tr>
						<td>新密码：</td>
						<td><input class="easyui-textbox" name="zlxqAccount.password" required="true" style="width: 200px;" /></td>
					</tr>
					<!-- <tr>
						<td>密码确认：</td>
						<td><input class="easyui-textbox" name="zlxqAccount.deptname" required="true" style="width: 200px;" /></td>
					</tr> -->
				</table>
			</form>
			</div>
			<div style="text-align: center; padding: 10px; margin-top: 100px;">
				<a href="javascript:void(0)" onclick="savePasswordFun()" id="btn-save-password" icon="icon-save">保存</a> <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel-password" icon="icon-cancel"> 取消</a>
			</div>
		</div>
	</div>
</body>
</html>