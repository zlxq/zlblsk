<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/statics/blsk/css/svg/graphical.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/statics/blsk/js/ui/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/statics/blsk/js/ui/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/statics/blsk/js/ui/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/statics/blsk/js/ui/jquery-ui-1.12.1.custom/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/statics/blsk/js/ui/jquery-ui-1.12.1.custom/jquery-ui.structure.css"/>	
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/statics/blsk/js/ui/jquery-ui-1.12.1.custom/jquery-ui.theme.css"/>	
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/statics/blsk/js/ui/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/statics/frame/js/json/json.js"></script>
<script type="text/javascript">
	var __ctxPath="<%=request.getContextPath()%>";
</script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/statics/blsk/js/colorpicker/colorpicker-master/jquery.colorpicker.css"/>	
<script type="text/javascript"
	src="<%=request.getContextPath()%>/statics/blsk/js/colorpicker/colorpicker-master/jquery.colorpicker.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/statics/blsk/js/colorpicker/colorpicker-master/parts/jquery.ui.colorpicker-rgbslider.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/moudles/inv/svg/js/graphical.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/moudles/inv/svg/js/svg.js"></script>
	
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/statics/frame/js/easyui/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>



<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
</head>
<body class="easyui-layout" style="overflow-y: hidden;" scroll="no">
	<div id="graphical">
		<div id="graphical-head" class="graphical-head">
		<fieldset id="fs_id_1" style="float: left;">
				<legend>巷道单元信息</legend>
				<table cellspacing="10">
						<tr>
							<td>
							<label for="storeRoom">所属库房: </label><input type="text" id="storeRoom" name="storeRoom" style="width:120px;">
							</td>
							<td>
							<label for="storeRoom_unit">单元名称: </label><input type="text" id="storeRoom_unit" name="storeRoom_unit" style="width:120px;">
							</td>
						</tr>
						<tr>
							<td>
							<label for="space_x">纬度: </label><input type="number" id="space_x" name="space_x" style="width:120px;">
							</td>
							<td>
							<label for="space_y">经度: </label><input type="number" id="space_y" name="space_y" style="width:120px;">
							</td>
						</tr>	
						<tr>
							<td><button id="create">新建画布</button>
							<button id="clear">清除画布</button>
							<button id="save">保存</button>
							</td>
						</tr>
					</table>
			</fieldset>

			<fieldset id = "fs_id_2" style="float: left; ">
				<legend>基本属性设置</legend>
				<table cellspacing="10">
					<tr>
						<th><span>左侧储位信息:</span></th>
					</tr>
					<tr>
						<td><label for="level_num"">层级数量: </label><input type="number"
							value=0 id="level_num" name="level_num" style="width: 120px;"></td>
						<td><label for="lattice_num">储位数量: </label><input
							type="number" value=0 id="lattice_num" name="lattice_num" style="width: 120px;"></td>
					</tr>
					<tr>
						<td><label for="rectangle_long">长(cm):</label><input
							type="number" value=0 id="rectangle_long" name="rectangle_long" style="width: 120px;"></td>
						<td><label for="rectangle_width">宽(cm):</label><input
							type="number" value=0 id="rectangle_width" name="rectangle_width" style="width: 120px;"></td>
						<td><label for="rectangle_height">高(cm):</label><input
							type="number" value=0 id="rectangle_height"
							name="rectangle_height" style="width: 120px;"></td>
					</tr>
					<tr>
						<th><span>右侧储位信息:</span></th>
					</tr>
					<tr>
						<td><label for="level_num_right">层级数量: </label><input
							type="number" value=0 id="level_num_right" name="level_num_right" style="width: 120px;"></td>
						<td><label for="lattice_num_right">储位数量: </label><input
							type="number" value=0 id="lattice_num_right"
							name="lattice_num_right" style="width: 120px;"></td>
					</tr>
					<tr>
						<td><label for="rectangle_long_right">长(cm):</label><input
							type="number" value=0 id="rectangle_long_right"
							name="rectangle_long_right" style="width: 120px;"></td>
						<td><label for="rectangle_width_right">宽(cm):</label><input
							type="number" value=0 id="rectangle_width_right"
							name="rectangle_width_right" style="width: 120px;"></td>
						<td><label for="rectangle_height_right">高(cm):</label><input
							type="number" value=0 id="rectangle_height_right"
							name="rectangle_height_right" style="width: 120px;"></td>
					</tr>
					<tr>
						<td><button style="width: 100px" id="createSvg">生成平面图</button></td>
						
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
	<div id="svg_editor">
		<div id="rulers">
			<div id="ruler_corner"></div>
			<div id="ruler_x">
				<div id="ruler_x_cursor"></div>
				<div>
					<canvas height="15"></canvas>
				</div>
			</div>
			<div id="ruler_y">
				<div id="ruler_y_cursor"></div>
				<div>
					<canvas width="15"></canvas>
				</div>
			</div>
		</div>
		
		<div id="workarea"></div>
		
		<div id="property">
		<fieldset id="fs_id_3" style="float: left;">
				<legend>储位信息</legend>
					<table cellspacing="9">
						<tr>
							<td><span style="width: 75px;">是否开启:
							</span><input type="text" id="latticeIsClose" name="latticeIsClose"  style="width: 120px;"></td>
						</tr>
					</table>
		</fieldset>
		<fieldset id="fs_id_4" style="float: left;">
				<legend>业务属性信息</legend>
					<table cellspacing="9">
						<tr>
							<td><span style="width: 75px;">执行码:
							</span> <input type="text" id="latticeRunCode" name ="latticeRunCode" style="width: 120px;"></td>	
						</tr>
						<tr>
							<td><span style="width: 75px;">入库规则:
							</span> <input type="text" id="latticeInStoreRule" style="width: 120px;"></td>		
						</tr>
						<tr>
							<td><span style="width: 75px;">设备名称:
							</span> <input type="text" id="spaceStackerId" style="width: 120px;"></td>		
						</tr>
						<tr>
						<td><span style="width: 75px;">物料编号:
							</span> <input type="text" id="no" style="width: 120px;"></td>
						</tr>	
						<tr>
						<td><span style="width: 75px;">物料名称:
							</span> <input type="text" id="name" style="width: 120px;"></td>
						</tr>
					</table>
			</fieldset>
		</div>

		<div id="tools_left" class="tools_panel">
			<div class="tool_button" id="tool_select"><img src="./svgimg/select.png"/></div>
<!-- 			<div class="tool_button" id="tool_text"><img src="./svgimg/text.png"/></div> -->
		</div>
		
		<div id = "tools_bottom" class="bottom_panel">
		<div>
			<span>边框色:<input id="colorpicker-popup" type="text"
				value="000000" style="width: 60px; display: none;"></span>&nbsp;
			<span>填充色:<input id="colorpicker-popup2" type="text"
				value="ffffff" style="width: 60px; display: none;"></span>
		</div>
		
		</div>
	</div>
	
	
<!-- 弹窗实验 -->
	<div id="property-window" class="easyui-window" title="编辑属性信息" style="width: 600px; height: 400px;"
	data-options="iconCls:'icon-save',modal:true,closed:true">
		<div style="padding: 20px 20px 20px 40px;">
		<form method="post">
		<table cellspacing="9">
				<tr>
					<td><input type="radio" name="latticeOptions" value="open">开启</input></td>
					<td><input type="radio" name="latticeOptions" value="close">关闭</input></td>
				</tr>
				<tr>
				    <td><span style="width: 75px;">执行码:</span> 
				    		<select id="runCode" name ="runCode" style="width: 120px;">
									<option value="0" selected>-请选择-</option>
									<option value="1">入库</option>
									<option value="2">出库</option>
									<option value="3">盘点</option>
							</select>
					</td>
					<td><span style="width: 75px;">入库规则:</span> 
							<select id="inStoreRule" style="width: 120px;">
									<option value="0" selected>-请选择-</option>
									<option value="1" >先进先出</option>
									<option value="2">先进后出</option>
							</select>
					</td>
					
<!-- 					<td><span style="width: 75px;">堆垛机: -->
<!-- 							</span> <select id="stackerId" style="width: 120px;"> -->
<!-- 									<option value="0" selected>-请选择-</option> -->
<!-- 									<option value="1" >型号1</option> -->
<!-- 									<option value="2">型号2</option> -->
<!-- 							</select></td>		 -->
				</tr>
			</table>
		</form>
		<div id="material-grid" fit="true"></div>
		</div>
		<div style="text-align: center; padding: 10px; margin-top: 100px;">
			<a href="javascript:void(0)" onclick="setProperty('a')" id="btn-save-menu" icon="icon-save">保存</a> 
			<a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel-menu" icon="icon-cancel"> 取消</a>
		</div>
	</div>
	
	
	<div id="stacker-window" class="easyui-window" title="编辑属性信息" style="width: 600px; height: 400px;"
	data-options="iconCls:'icon-save',modal:true,closed:true">
		<div style="padding: 20px 20px 20px 40px;">
		<form method="post">
		<table cellspacing="9">
				<tr>
					<td><input type="radio" name="latticeOption" value="open">开启</input></td>
					<td><input type="radio" name="latticeOption" value="close">关闭</input></td>
				</tr>
			</table>
		</form>
		<div id="equip-grid" fit="true"></div>
		</div>
		<div style="text-align: center; padding: 10px; margin-top: 100px;">
			<a href="javascript:void(0)" onclick="setProperty('b')" id="btn-save-menu" icon="icon-save">保存</a> 
			<a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel-menu" icon="icon-cancel"> 取消</a>
		</div>
	</div>


</body>
</html>