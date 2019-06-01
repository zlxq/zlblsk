var ordergrid;
var detailgrid;

$(function() {

	ordergrid = $('#ordergrid');
	detailgrid = $('#detailgrid');
	
	ordergrid.datagrid({
		url : __ctxPath + '/invorder/getRCOrderPage.do',
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
			field : 'BILLNO',
			title : '单据编号',
			width : 100
		}, {
			field : 'BILLTYPENAME',
			title : '单据类型',
			width : 100,
			sortable : true
		}, {
			field : 'BILLSTATENAME',
			title : '单据状态',
			width : 100,
			sortable : true
		}, {
			field : 'USERNAME',
			title : '创建人',
			width : 100,
			sortable : true
		}, {
			field : 'REQTIME',
			title : '创建时间',
			width : 100,
			sortable : true
		} ] ],
		toolbar : [ {
			text : '导入',
			iconCls : 'icon-add',
			handler : function() {}
		}, {
			text : '下发',
			iconCls : 'icon-edit',
			handler : nextOrderFun
		} ],
		onClickRow : onclickLeftRefreshRight
	});

	detailgrid.datagrid({
		url : __ctxPath + '/invorder/getOrderDetailPage.do',
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
			field : 'MCODE',
			title : '物料编号',
			width : 100
		}, {
			field : 'MNAME',
			title : '物料名称',
			width : 100,
			sortable : true
		}, {
			field : 'COUNT',
			title : '请求数量',
			width : 100,
			sortable : true
		}, {
			field : 'WCNUM',
			title : '完成数量',
			width : 100,
			sortable : true
		}, {
			field : 'UNIT',
			title : '计量单位',
			width : 100,
			sortable : true
		} ] ]
	});
	
	$('body').layout();
});

function onclickLeftRefreshRight(index, row) {
	detailgrid.datagrid('loadData',{total:0,rows:[]});
	detailgrid.datagrid({
		url : __ctxPath + '/invorder/getOrderDetailPage.do?orderid=' + row.ID
	});
}

function nextOrderFun() {
	var rows = ordergrid.datagrid('getSelections');
	var num = rows.length;
	if (num == 0) {
		$.messager.show({
			title : '提示',
			msg : '请选择记录进行操作!',
			timeout : 500,
			style:{
				top:1, // 与左边界的距离
				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
			}
		});
        return;
    }
	
	var ids = [];

	for (var i = 0; i < num; i++) {
		ids.push(rows[i].ID);
	}
	
	$.ajax({
		url : __ctxPath + '/invorder/nextRCOrder.do',
		type : 'post',
		data : {
			ids : JSON.stringify(ids)
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
			ordergrid.datagrid('reload');
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

