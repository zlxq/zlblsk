var companygrid;
var companywin;
var companyform;

$(function() {
	companygrid = $('#companygrid');
	
	$('#btn-save-company,#btn-cancel-company').linkbutton();
	
	companywin = $('#companyform-window').window({
		width : "100%",
	    height : "100%",
		closed : true,
		modal : true,
		shadow : false
	});
	companyform = companywin.find('form');
	
	companygrid.datagrid({
		url : __ctxPath + '/party/getCompanyPage.do',
		sortName : 'id',
		sortOrder : 'asc',
		idField : 'id',
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
			field : 'PARTYNO',
			title : '设备编号',
			width : 100
		}, {
			field : 'PARTYNAME',
			title : '设备序号',
			width : 100,
			sortable : true
		}, {
			field : 'ADDR',
			title : '设备型号',
			width : 100,
			sortable : true
		}, {
			field : 'MANAGER4',
			title : '设备状态',
			width : 100,
			sortable : true
		}, {
			field : 'MANAGER2',
			title : '所属公司',
			width : 100,
			sortable : true
		}, {
			field : 'MANAGER3',
			title : '所属库房',
			width : 100,
			sortable : true
		} ] ],
		toolbar : [ {
			text : '增加',
			iconCls : 'icon-add',
			handler : addCompanyFun
		}, {
			text : '删除',
			iconCls : 'icon-remove',
			handler : delCompanyFun
		}, {
			text : '修改',
			iconCls : 'icon-edit',
			handler : editCompanyFun
		} ]
	});
	$('body').layout();
});

function refreshGrid() {
}

function closeWindow() {
	companywin.window('close');
}

function saveFun() {
	$.messager.progress();
	
	companyform.form('submit', {
		url : companyform.url,
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (!isValid){
				$.messager.progress('close');
			}
			return isValid;
		},
		success : function(e, f) {
			companygrid.datagrid('reload');
			companywin.window('close');

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

function addCompanyFun() {
	companywin.window('open');
	companyform.form('clear');
	companyform.url = __ctxPath + '/party/saveCompany.do';
}

function delCompanyFun() {}

function editCompanyFun() {}

