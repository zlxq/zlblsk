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
<script type="text/javascript" src="<%=request.getContextPath()%>/moudles/rbac/auth/js/sysauth.js"></script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	
	<div region="east" split="true" style="width: 250px;padding: 1px; overflow-y: hidden">
		<ul id="sysauthtree"></ul>
	</div>

	<div region=center split="true" style="padding: 1px; background: #eee; overflow-y: hidden">
		<div id="sysauthgrid" fit="true"></div>
	</div>
	
	<div id="sysauthform-window" title="角色授权" style="padding: 5px">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" style="border: 0;">
				<div class="easyui-layout" data-options="fit:true">
					<div data-options="region:'west'" style="width:45%;border: 0">
						<ul id="sysauthtree1"></ul>
					</div>
					<div data-options="region:'center'">
						<div style="position:absolute; top:40%; left: 20%">
							<div>
								<a href="javascript:void(0)" onclick="removeLeftToRightFun()" id="btn-save-auth">》</a>
							</div>
							<div style="margin-top: 10px">
								<a href="javascript:void(0)" onclick="removeRightToLeftFun()" id="btn-save-auth">《</a>
							</div>
						</div>
					</div>
					<div data-options="region:'east'" style="width:50%;border:0">
						<ul id="sysauthtree2"></ul>
					</div>
				</div>
			</div>
			<div data-options="region:'south'" style="background-color: #C0C0C0; padding: 5px 0px 20px 0px; overflow-y: hidden" scroll="no">
				<div style="text-align: center;">
					<a href="javascript:void(0)" onclick="saveAuthFun()" id="btn-save-auth" icon="icon-save">保存</a> <a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel-auth" icon="icon-cancel"> 取消</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>