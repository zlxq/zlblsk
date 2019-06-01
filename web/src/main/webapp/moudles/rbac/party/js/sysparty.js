$(function() {
	grid = $('#syspartygrid');
	tree = $('#sysdetppartytree');

	$('#btn-save-party,#btn-cancel-party').linkbutton();
	win = $('#addparty-window').window({
		width : "100%",
	    height : "100%",
		closed : true,
		modal : true,
		shadow : false
	});
	form = win.find('form');

	$('#btn-search,#btn-search-cancel').linkbutton();

	impWin = $('#excelparty-window').window({
		closed : true,
		modal : true,
		shadow : false
	});
	impForm = impWin.find('form');
	
	tree.tree({
		checkbox : false,
		url : __ctxPath + '/party/getDeptTree.do',
		onBeforeExpand : function(node, param) {
			// alert(node.id);
			tree.tree('options').url = __ctxPath + "/party/getDeptTree.do?id="
					+ node.id;
			// param.myattr = 'test'; // or change request parameter
		},
		onClick : function(node) {
			clickTree(node.id);
		}
	});

	grid.datagrid({
		iconCls : 'icon-save',
		url : __ctxPath + '/party/getUserPage.do',
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
			field : 'partyno',
			title : '编号',
			width : 50,
			sortable : true
		}, {
			field : 'partyname',
			title : '姓名',
			width : 50,
			sortable : true
		}, {
			field : 'sex',
			title : '性别',
			width : 50,
			sortable : true,
			render : function(a, b, c){
				if(a == '0'){
					return "男";
				}else if(a == '1'){
					return "女";
				}
			}
		}, {
			field : 'email',
			title : '邮箱',
			width : 50,
			sortable : true
		}, {
			field : 'tel',
			title : '电话',
			width : 50,
			sortable : true
		} ] ],
		toolbar : [ {
			text : '增加',
			iconCls : 'icon-add',
			handler : addPartyFun
		}, {
			text : '删除',
			iconCls : 'icon-remove',
			handler : delPartyFun
		}, {
			text : '修改',
			iconCls : 'icon-edit',
			handler : editPartyFun
		} ]
	});
	$('body').layout();
});

var tree;
var grid;
var win;
var form;
var impWin;
var impForm;

function clickTree(nodeid) {
	grid.datagrid('loadData',{total:0,rows:[]});
	grid.datagrid({
		url : __ctxPath + '/party/getUserPage.do?id=' + nodeid
	});
	grid.datagrid('load');
}

function addPartyFun() {
	var rows = tree.tree('getSelected');
	
	var pid = null;

	if (null != rows) {
		pid = rows.id;
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择一条记录进行操作!',
			timeout : 500,
			style:{
				top:1, // 与左边界的距离
				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
			}
		});
		return;
	}

	win.window('open');
	form.form('clear');
	form.url = __ctxPath + '/party/saveParty.do?pid=' + pid;
}

function delPartyFun() {
	var rows = grid.datagrid('getSelections');
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
		ids.push(rows[i].id);
	}
	
	$.ajax({
		url : __ctxPath + '/party/delParty.do',
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

function editPartyFun() {
	var rows = grid.datagrid('getSelections');
	var num = rows.length;
	if (num == 0) {
		$.messager.show({
			title : '提示',
			msg :'请选择一条记录进行操作!',
			timeout : 500,
			style:{
				top:1, // 与左边界的距离
				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
			}
		});
		return;
	} else if (num > 1) {
		$.messager.show({
			title : '提示',
			msg :'您选择了多条记录,只能选择一条记录进行修改!',
			timeout : 500,
			style:{
				top:1, // 与左边界的距离
				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
			}
		});
		return;
	} else {
		win.window('open');
		var data = rows[0];

		form.form('load', { // 调用load方法把所选中的数据load到表单中,非常方便
			'zlxqParty.partyno' : data.partyno,
			'zlxqParty.partyname' : data.partyname,
			'zlxqParty.sex' : data.sex,
			'zlxqParty.email' : data.email,
			'zlxqParty.tel' : data.tel
		});

		form.url = __ctxPath + '/party/editParty.do?id=' + data.id;
	}
}

function savePartyFun() {
	$.messager.progress();
	form.form('submit', {
		url : form.url,
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (!isValid){
				$.messager.progress('close');
			}
			return isValid;
		},
		success : function(e, f) {
			grid.datagrid('reload');
			win.window('close');

			var m = eval('(' + e + ')');
			$.messager.progress('close');
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
function closeWindow() {
	win.window('close');
}

function importPartyFun(){
	impWin.window('open');
	impForm.form('clear');
	impForm.url = __ctxPath + '/party/importParty.do';
}

function saveImportFun(){
//	$.messager.show('上传开始！');
//	alert(impForm.url);
	impForm.form('submit', {
		url : impForm.url,
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (!isValid){
				$.messager.progress('close');
			}
			return isValid;
		},
		success : function(e, f) {
			grid.datagrid('reload');
			win.window('close');

			var m = eval('(' + e + ')');
			$.messager.progress('close');
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

function closeImportClick(){
	impWin.window('close');
}