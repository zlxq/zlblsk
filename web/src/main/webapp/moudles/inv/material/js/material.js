var materialgrid;
var materialwin;
var materialform;

$(function() {
	materialgrid = $('#materialgrid');
	
	$('#btn-save-material,#btn-cancel-material').linkbutton();
	
	materialwin = $('#materialform-window').window({
		width : "100%",
	    height : "100%",
		closed : true,
		modal : true,
		shadow : false
	});
	materialform = materialwin.find('form');
	
	materialgrid.datagrid({
		url : __ctxPath + '/material/getMaterialPage.do',
		sortName : 'id',
		sortOrder : 'asc',
		idField : 'id',
		pagination : true,
		rownumbers : true,
		singleSelect : false,
		pageSize : 30,
		loadMsg : '数据加载中请稍后……',
		fitColumns : true,
		frozenColumns : [[ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'CODE',
			title : '物料编码',
			width : 150
		}, {
			field : 'MODEL',
			title : '型号规格',
			width : 150,
			sortable : true
		}, {
			field : 'NAME',
			title : '物料名称',
			width : 150,
			sortable : true
		}, {
			field : 'UNIT',
			title : '计量单位',
			width : 50,
			sortable : true
		} ]],
		columns : [ [ {
			title : '包装规格',
			align : 'center',
			"colspan":3
		}], [ {
			field : 'LENGTH',
			title : '长',
			width : 50,
			sortable : true
		}, {
			field : 'WIDTH',
			title : '宽',
			width : 50,
			sortable : true
		}, {
			field : 'HIGHT',
			title : '高',
			width : 50,
			sortable : true
		}] ],
		toolbar : [ {
			text : '增加',
			iconCls : 'icon-add',
			handler : addmaterialFun
		}, {
			text : '删除',
			iconCls : 'icon-remove',
			handler : delmaterialFun
		}, {
			text : '修改',
			iconCls : 'icon-edit',
			handler : editmaterialFun
		} ]
	});
	$('body').layout();
});

function refreshGrid() {
}

function closeWindow() {
	materialwin.window('close');
}

function saveFun() {
	$.messager.progress();
	
	materialform.form('submit', {
		url : materialform.url,
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (!isValid){
				$.messager.progress('close');
			}
			return isValid;
		},
		success : function(e, f) {
			materialgrid.datagrid('reload');
			materialwin.window('close');

			$.messager.progress('close');
			var m = eval('(' + e + ')');
			$.messager.show({
				title : '提示',
				msg : m.msg,
				timeout : 500,
				style:{
					top:1, // 与左边界的距离
					left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
				}
			});
		}
	});
}

function addmaterialFun() {
	materialwin.window('open');
	materialform.form('clear');
	materialform.url = __ctxPath + '/material/saveMaterial.do';
}

function delmaterialFun() {}

function editmaterialFun() {}

