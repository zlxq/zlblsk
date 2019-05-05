$(function() {
	grid = $('#sysdeptgrid');
	tree = $('#sysdepttree');

	$('#btn-save-dept,#btn-cancel-dept').linkbutton();
	win = $('#sysdeptform-window').window({
		closed : true,
		modal : true,
		shadow : false
	});
	form = win.find('form');

	$('#btn-search,#btn-search-cancel').linkbutton();
	searchWin = $('#search-window').window({
		closed : true,
		modal : true
	});
	searchForm = searchWin.find('form');

	tree.tree({
		checkbox : false,
		url : __ctxPath + '/party/getDeptTree.do',
		onBeforeExpand : function(node, param) {
			// alert(node.id);
			tree.tree('options').url = __ctxPath + "/party/getDeptTree.do?id="
					+ node.id;
		},
		onClick : function(node) {
			clickTree(node.id);
		}
	});

	grid.datagrid({
		url : __ctxPath + '/party/getDeptGrid.do',
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
			title : '组织编号',
			width : 100
		}, {
			field : 'partyname',
			title : '组织名称',
			width : 100,
			sortable : true
		} ] ],
		toolbar : [ {
			text : '增加',
			iconCls : 'icon-add',
			handler : addDeptFun
		}, {
			text : '删除',
			iconCls : 'icon-remove',
			handler : delDeptFun
		}, {
			text : '修改',
			iconCls : 'icon-edit',
			handler : editDeptFun
		} ]
	});
	$('body').layout();
});

var win;
var form
var tree;
var grid;

function clickTree(nodeid) {
	grid.datagrid('loadData',{total:0,rows:[]});
	grid.datagrid({ url: __ctxPath + '/party/getDeptGrid.do?id=' + nodeid });
	grid.datagrid('clearSelections');
	grid.datagrid('load');
}

function addDeptFun() {
	var rows = tree.tree('getSelected');
	var pid = null;
	
	if (null != rows) {
		pid = rows.id;
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择学校节点',
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
	form.url = __ctxPath + '/party/saveDept.do?pid=' + pid;

}

function saveDeptFun() {
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
			refreshTree();
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

function refreshTree() {
	tree.tree("options").url=__ctxPath + '/party/getDeptTree.do';
	tree.tree('reload');
}

function delDeptFun() {
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
		url : __ctxPath + '/party/delDept.do',
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

function editDeptFun() {
	var rows = grid.datagrid('getSelections');
    var num = rows.length;
    if (num == 0) {
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
    else if (num > 1) {
        $.messager.show({
			title : '提示',
			msg : '您选择了多条记录,只能选择一条记录进行修改!',
			timeout : 500,
			style:{
				top:1, // 与左边界的距离
				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
			}
		});
        return;
    }
    else{
        win.window('open');
        var data = rows[0];

        form.form('load', { // 调用load方法把所选中的数据load到表单中,非常方便
            'zlxqParty.partyno' : data.partyno,
            'zlxqParty.partyname' : data.partyname
        });
        
        form.url = __ctxPath + '/party/editDept.do?id=' + data.id;
    }
}

function closeWindow() {
	win.window('close');
}
