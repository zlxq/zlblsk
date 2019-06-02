$(function() {
	
	grid = $('#templategrid');
	
	templateType = $("#template_type").combobox({ 
		 onSelect: function (record) {
			 setSysData(record);
		 } 
		});
	
	grid.datagrid({
//		url : __ctxPath + '/template/getTemplate.do',
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
			sortable : true
		}, {
			field : 'LINENAME',
			title : '列名称',
			width : 50,
			sortable : true
		}, {
			field : 'SYSNAME',
			title : '对应系统名称',
			width : 50,
			sortable : true,
			editor : {
				type : 'combobox',
				options : {
					data : sysdata,
					valueField : 'SYSNAME',
					textField : 'text'
				}
			}
		}] ],
		toolbar : [{
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

function templateAddFun (rows){
	for(var i = 0; i < rows.length; i++){
		grid.datagrid('insertRow',{
			index: rows.length-1,	// index start with 0
			row: rows[i]
		});
	}
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
		 sysdata = [{ "SYSNAME": "订单号<font color='red'>*</font>", "text": "订单号" }, { "SYSNAME": "订单类型<font color='red'>*</font>", "text": "订单类型" }, { "SYSNAME": "创建人", "text": "创建人" }
			, { "SYSNAME": "创建时间", "text": "创建时间" }, { "SYSNAME": "物料编码", "text": "物料编码" }, { "SYSNAME": "型号规格", "text": "型号规格" }
			, { "SYSNAME": "物料名称", "text": "物料名称" }, { "SYSNAME": "数量", "text": "数量" }, { "SYSNAME": "单位", "text": "单位" }];
		}else if(val == "盘点"){
			sysdata = [{ "SYSNAME": "盘点任务单号", "text": "盘点任务单号" }, { "SYSNAME": "物料编码", "text": "物料编码" }, { "SYSNAME": "型号规格", "text": "型号规格" }
			, { "SYSNAME": "物料名称", "text": "物料名称" }, { "SYSNAME": "账目数量", "text": "账目数量" }, { "SYSNAME": "盘点数量", "text": "盘点数量" },{ "SYSNAME": "计量单位", "text": "计量单位" },
			{ "SYSNAME": "盘点类型", "text": "盘点类型" }, { "SYSNAME": "盘点人", "text": "盘点人" }, { "SYSNAME": "盘点状态", "text": "盘点状态" }, { "SYSNAME": "盘点时间", "text": "盘点时间" }];
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
	var headInRow = $('#headInRow').val();
	var orderName = $('#orderName').val();
	var templatetype = $("#template_type  option:selected").text();
	var choosefile = $('#choosefile').val();
	var orderContxtInLine = $('#orderContxtInLine').val();
	var templeteName = $('#templeteName').val();
	
	if(headInRow== "" || orderName== "" ||templatetype== "-请选择-" ||choosefile== "" ||orderContxtInLine== "" ||templeteName== ""){
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
			headName = rows[i].LINENAME;
		}else{
			headName = headName + "," + rows[i].LINENAME;
		}
	}
	
	$.ajax({
		url : __ctxPath + '/template/saveTemplate.do',
		type : 'post',
		data : {
			data : JSON.stringify(data),
			headInRow : headInRow,
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
	$('#headInRow').val("");
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


var wb;//读取完成的数据
var rABS = false; //是否将文件读取为二进制字符串

function read(obj) {//导入
	
    if(!obj.files) {
        return;
    }
    const IMPORTFILE_MAXSIZE = 1*1024;//这里可以自定义控制导入文件大小
    var suffix = obj.files[0].name.split(".")[1]
    if(suffix != 'xls' && suffix !='xlsx'){
    	$.messager.show({
			title : '提示',
			msg : '导入的文件格式不正确!',
			timeout : 500,
			style:{
				top:1, // 与左边界的距离
				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
			}
		});
        return;
    }
    var row = $('#headInRow').val();
    if(row == ""){
    	$.messager.show({
			title : '提示',
			msg : '请先填写表头行号！',
			timeout : 500,
			style:{
				top:1, // 与左边界的距离
				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
			}
		});
    	 return;
    }
    var f = obj.files[0];
    var reader = new FileReader();
    reader.onload = function(e) {
        var data = e.target.result;
        if(rABS) {
            wb = XLSX.read(btoa(fixdata(data)), {//手动转化
                type: 'base64'
            });
        } else {
            wb = XLSX.read(data, {
                type: 'binary'
            });
        }
//        
        var worksheet = wb.Sheets[wb.SheetNames[0]];
        
        var array = XLSX.utils.sheet_to_formulae(worksheet);
        
        var rows = [];
        for(var i = 0; i < array.length; i++) { 
        	var data = array[i].split("=")[0];

            var num = data.replace(/[^0-9]/ig,"");
            
            var ln = data.replace(/\d+/g,''); 
           
            if(num == row){
            	var value = array[i].split("=")[1].replace(/\'/g,"");//存在单引号情况
            	
                var rowdata = {
                		"LINENO" : stringTonum(ln),
                		"LINENAME" : value
                }
                rows.push(rowdata);
            }
        }
        
        if(rows.length != 0){
        	grid.datagrid('loadData',[]);
        	templateAddFun(rows);
        }else{
        	grid.datagrid('loadData',[]);
        }
    };
    if(rABS) {
        reader.readAsArrayBuffer(f);
    } else {
        reader.readAsBinaryString(f);
    }
}

function fixdata(data) { //文件流转BinaryString
    var o = "",
        l = 0,
        w = 10240;
    for(; l < data.byteLength / w; ++l) o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w, l * w + w)));
    o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w)));
    return o;
}


function stringTonum(a) {
	var str = a.toLowerCase().split("");
	var num = 0;
	var al = str.length;
	var getCharNumber = function(charx) {
		return charx.charCodeAt() - 96;
	};
	var numout = 0;
	var charnum = 0;
	for (var i = 0; i < al; i++) {
		charnum = getCharNumber(str[i]);
		numout += charnum * Math.pow(26, al - i - 1);
	};
	return numout;
}

