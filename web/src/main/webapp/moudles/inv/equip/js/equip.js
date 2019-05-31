var equipgrid;
var equipwin;
var equipform;

$(function() {
	equipgrid = $('#equipgrid');
	
	$('#btn-save-equip,#btn-cancel-equip').linkbutton();
	
	equipwin = $('#equipform-window').window({
		width : "100%",
	    height : "100%",
		closed : true,
		modal : true,
		shadow : false
	});
	equipform = equipwin.find('form');
	
	equipgrid.datagrid({
		url : __ctxPath + '/equip/getEquipPage.do',
		sortName : 'id',
		sortOrder : 'asc',
		idField : 'ID',
		pagination : true,
		rownumbers : true,
		singleSelect : false,
		pageSize : 30,
		loadMsg : '数据加载中请稍后……',
		fitColumns : true,
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'EQUIP_NO',
			title : '设备编号',
			width : 100
		}, {
			field : 'SORT',
			title : '设备序号',
			width : 100,
			sortable : true
		}, {
			field : 'EQUIP_NAME',
			title : '设备类型',
			width : 100,
			sortable : true
		}, {
			field : 'EQUIP_STATE',
			title : '设备状态',
			width : 100,
			sortable : true
		} ] ],
		toolbar : [ {
			text : '增加',
			iconCls : 'icon-add',
			handler : addequipFun
		}, {
			text : '删除',
			iconCls : 'icon-remove',
			handler : delequipFun
		}, {
			text : '修改',
			iconCls : 'icon-edit',
			handler : editequipFun
		} ]
	});
	$('body').layout();
});

function refreshGrid() {
}

function closeWindow() {
	equipwin.window('close');
}

function saveFun() {
	$.messager.progress();
	
	equipform.form('submit', {
		url : equipform.url,
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (!isValid){
				$.messager.progress('close');
			}
			return isValid;
		},
		success : function(e, f) {
			equipgrid.datagrid('reload');
			equipwin.window('close');

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

function addequipFun() {
	equipwin.window('open');
	equipform.form('clear');
	equipform.url = __ctxPath + '/equip/saveEquip.do';
}

function delequipFun() {}

function editequipFun() {}

