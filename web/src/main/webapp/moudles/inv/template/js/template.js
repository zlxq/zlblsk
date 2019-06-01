$(function() {
	
	grid = $('#templategrid');
	
	templateType = $("#template_type").combobox({ 
		 onSelect: function (record) {
			 setSysData(record);
		 } 
		});
	
	grid.datagrid({
		iconCls : 'icon-save',
		sortName : 'ID',
		sortOrder : 'asc',
		idField : 'ID',
		pagination : true,
		rownumbers : true,
		singleSelect : false,
		pageSize : 30,
		loadMsg : '数据加载中请稍后……',
		fitColumns : true,
		clickToEdit : false,
		dblclickToEdit : true,
		onCellEdit : getSysData,
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'LINENO',
			title : '列号',
			width : 50,
			sortable : true,
			editor : 'text'
		}, {
			field : 'LINFNAME',
			title : '列名称',
			width : 50,
			sortable : true,
			editor : 'text'
		}, {
			field : 'SYSNAME',
			title : '对应系统名称',
			width : 50,
			sortable : true,
			editor : {
				type : 'combobox',
				options : {
					data : sysdata,
					valueField : 'value',
					textField : 'text'
				}
			}
		}, {
			field : 'ISNULL',
			title : '是否必填项',
			width : 50,
			sortable : true,
			editor : {
				type : 'combobox',
				options : {
					data : [{ "value": "是", "text": "是" }, { "value": "否", "text": "否" }],
					valueField : 'value',
					textField : 'text'
				}
			}
		} ] ],
		toolbar : [ {
			text : '增加',
			iconCls : 'icon-add',
			handler : templateAddFun
		}, {
			text : '删除',
			iconCls : 'icon-remove',
			handler : templateDelFun
		}, {
			text : '保存',
			iconCls : 'icon-ok',
			handler : templateSaveFun
		}],
	}).datagrid('enableCellEditing');

	$('body').layout();
});

var grid;
var templateType;
var sysdata;

function templateAddFun (){
	grid.datagrid('insertRow',{
		index: 1,	// index start with 0
		row: {
			name: 'new name',
			age: 30,
			note: 'some messages'
		}
	});

}

function templateDelFun(){
	var rows = grid.datagrid('getSelections');
	var num = rows.length;
	for(var i = 0; i < num; i ++){
		var row = rows[i];
		var index = grid.datagrid('getRowIndex', row);
		grid.datagrid('deleteRow', index);
	}
}

function setSysData(record){
	var val = record.text;
	 if(val == "出库" || val =="入库"){
		 sysdata = [{ "value": "订单号", "text": "订单号" }, { "value": "订单类型", "text": "订单类型" }, { "value": "创建人", "text": "创建人" }
			, { "value": "创建时间", "text": "创建时间" }, { "value": "物料编码", "text": "物料编码" }, { "value": "型号规格", "text": "型号规格" }
			, { "value": "物料名称", "text": "物料名称" }, { "value": "数量", "text": "数量" }, { "value": "单位", "text": "单位" }];
		}else if(val == "盘点"){
			sysdata = [{ "value": "盘点任务单号", "text": "盘点任务单号" }, { "value": "物料编码", "text": "物料编码" }, { "value": "型号规格", "text": "型号规格" }
			, { "value": "物料名称", "text": "物料名称" }, { "value": "账目数量", "text": "账目数量" }, { "value": "盘点数量", "text": "盘点数量" },{ "value": "计量单位", "text": "计量单位" },
			{ "value": "盘点类型", "text": "盘点类型" }, { "value": "盘点人", "text": "盘点人" }, { "value": "盘点状态", "text": "盘点状态" }, { "value": "盘点时间", "text": "盘点时间" }];
		}else{
			sysdata = "";
		} 
}

function getSysData(index){
	var editors = grid.datagrid('getEditors', index);
	var smEditor = editors[0];
	if(smEditor.field == "SYSNAME"){
		$(smEditor.target).combobox({
	         onShowPanel: function(){
	             $(smEditor.target).combobox("loadData", sysdata);  
	         }
		 });
	}
	 
}

function templateSaveFun(){
	var headInLine = $('#headInLine').val();
	var orderName = $('#orderName').val();
	var templatetype = $("#template_type  option:selected").text();
	var choosefile = $('#choosefile').val();
	var orderContxtInLine = $('#orderContxtInLine').val();
	var templeteName = $('#templeteName').val();
	
	if(headInLine== "" || orderName== "" ||templatetype== "-请选择-" ||choosefile== "" ||orderContxtInLine== "" ||templeteName== ""){
		$.messager.show({
			title : '提示',
			msg : '请完善上述信息!',
			timeout : 500,
			style:{
				top:1, // 与左边界的距离
				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
			}
		});
        return;
	}
	
	
	//记得加校验
	var rows = grid.datagrid('getSelections');
	rows.sort(sortRule);
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
	
	var headName;
	var data = [];

	for (var i = 0; i < num; i++) {
		data.push(rows[i]);
		
		if(i == 0){
			headName = rows[i].LINFNAME;
		}else{
			headName = headName + "," + rows[i].LINFNAME;
		}
	}
	
	$.ajax({
		url : __ctxPath + '/template/saveTemplate.do',
		type : 'post',
		data : {
			data : JSON.stringify(data),
			headInLine : headInLine,
			orderName : orderName,
			templatetype :templatetype,
			choosefile : choosefile,
			orderContxtInLine : orderContxtInLine,
			templeteName : templeteName,
			headName : headName
			
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
			grid.datagrid('reload');
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

function doReset(){
	$('#headInLine').val("");
	$('#orderName').val("");
	$('#template_type').combobox('select',"0");
	$('#choosefile').val("");
	$('#orderContxtInLine').val("");
	$('#templeteName').val("");
}

function sortRule(obj1, obj2){
	var a = Number(obj1.LINENO);
	var b = Number(obj2.LINENO);
	return a-b;
}

