var grid;

$(function() {
	
	grid = $('#sysloggrid');
	
	grid.datagrid({
		iconCls : 'icon-save',
		url : __ctxPath + '/log/getLogInfo.do',
		sortName : 'ID',
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
			field : 'LOGINNO',
			title : '登陆号',
			width : 50,
			sortable : true
		}, {
			field : 'LOGINNAME',
			title : '登录名',
			width : 50,
			sortable : true
		}, {
			field : 'LOGINIP',
			title : '登陆IP',
			width : 50,
			sortable : true
		}, {
			field : 'LOGINTIME',
			title : '登陆时间',
			width : 50,
			sortable : true
		}, {
			field : 'LOGINTYPE',
			title : '应用',
			width : 50,
			sortable : true
		} ] ],
		toolbar : [ {
			text : '日志导出',
			iconCls : 'icon-add',
			handler : expSysLogFun
		}]
	});
	$('body').layout();
});

//function expSysLogFun() {
//	var rows = grid.datagrid('getSelections');
//	var num = rows.length;
//	if (num == 0) {
//		var data = grid.datagrid('getData');
//		var rowsall = data.rows;
//		var num1 = rowsall.length;
//		var ids1 = [];
//
//		for (var i = 0; i < num1; i++) {
//			ids1.push(rowsall[i].ID);
//		}
//		
//		 $.messager.confirm('提示', '确定导出全部数据吗?', function(r){
//			 if(r){
//				 $.ajax({
//						url : __ctxPath + '/log/exportSysLog.do',
//						type : 'post',
//						data : {
//							ids : JSON.stringify(ids1)
//						},
//						beforeSend: function () {
//							$.messager.progress({ 
//								title: '提示', 
//								msg: '正在处理,请稍候……', 
//								text: '' 
//							});
//						},
//						complete: function () {
//							$.messager.progress('close');
//						},
//						success : function(e, f) {
////							window.open("syslog.xls","_blank");
//						}
//					});
//			 }
//		 });
//	} else if (num > 1) {
//		var ids = [];
//
//		for (var i = 0; i < num; i++) {
//			ids.push(rows[i].ID);
//		}
//		 $.messager.confirm('提示', '确定导出选中数据吗?', function(r){
//			 if(r){
//				 $.ajax({
//						url : __ctxPath + '/log/exportSysLog.do',
//						type : 'post',
//						data : {
//							ids : JSON.stringify(ids)
//						},
//						beforeSend: function () {
//							$.messager.progress({ 
//								title: '提示', 
//								msg: '正在处理,请稍候……', 
//								text: '' 
//							});
//						},
//						complete: function () {
//							$.messager.progress('close');
//						},
//						success : function(e, f) {
////							window.open("syslog.xls","_blank");
//						}
//					});
//			 }
//		 });
//	}
//}


function expSysLogFun(){
	var rows = grid.datagrid('getSelections');
	var num = rows.length;
	if (num == 0) {
		var ids = [];
		 $.messager.confirm('继续操作', '确定导出全部数据吗?', function(r){
			 if(r){
				 var form = $("<form>");
				 form.attr("style","display:none");
				 form.attr("target","");
				 form.attr("method","post");
				 form.attr("action",__ctxPath + '/log/exportSysLog.do');
				 var input1 = $("<input>");
				 input1.attr("type","hidden");
				 input1.attr("name","ids");
				 input1.attr("value",JSON.stringify(ids));
				 $("body").append(form);
				 form.append(input1);
				 form.submit();
				 form.remove();
			 }
		 });
	} else if (num >= 1) {
		var ids = [];

		for (var i = 0; i < num; i++) {
			ids.push(rows[i].ID);
		}
		 $.messager.confirm('继续操作', '确定导出选中数据吗?', function(r){
			 if(r){

				 var form = $("<form>");
				 form.attr("style","display:none");
				 form.attr("target","");
				 form.attr("method","post");
				 form.attr("action",__ctxPath + '/log/exportSysLog.do');
				 var input1 = $("<input>");
				 input1.attr("type","hidden");
				 input1.attr("name","ids");
				 input1.attr("value",JSON.stringify(ids));
				 $("body").append(form);
				 form.append(input1);
				 form.submit();
				 form.remove();
			 }
		 });
	}
}
