$(function() {
	dictgrid = $('#sysdictgrid');
	tree = $('#sysdicttree');

	$('#btn-save-dict,#btn-cancel-dict').linkbutton();
	win = $('#sysdictform-window').window({
		width : "100%",
	    height : "100%",
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
		url : __ctxPath + '/dict/getDictTree.do',
		onBeforeExpand : function(node, param) {
			// alert(node.id);
			tree.tree('options').url = __ctxPath + "/dict/getDictTree.do?id="
					+ node.id;
			// param.myattr = 'test'; // or change request parameter
		},
		onClick : function(node) {
			clickTree(node.id);
		}
	});

	dictgrid.datagrid({
		url : __ctxPath + '/dict/getDictGrid.do',
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
			field : 'dic_code',
			title : '系统编号',
			width : 100
		}, {
			field : 'dic_name',
			title : '系统名称',
			width : 100,
			sortable : true
		}, {
			field : 'dic_type',
			title : '系统类型',
			width : 100,
			sortable : true
		} ] ],
		toolbar : [ {
			text : '增加',
			iconCls : 'icon-add',
			handler : addDictFun
		}, {
			text : '删除',
			iconCls : 'icon-remove',
			handler : delDictFun
		}, {
			text : '修改',
			iconCls : 'icon-edit',
			handler : editDictFun
		} ]
	});
	$('body').layout();
});

var win;
var form
var tree;
var dictgrid;

function clickTree(nodeid) {
	dictgrid.datagrid('loadData',{total:0,rows:[]});
	dictgrid.datagrid({ url: __ctxPath + '/dict/getDictGrid.do?id=' + nodeid });
	dictgrid.datagrid('clearSelections');
}

function addDictFun() {
	var rows = tree.tree('getSelected');
	
	var pid = null;
	
	if (null != rows) {
		pid = rows.id;
	}
	
	win.window('open');
	form.form('clear');
	form.url = __ctxPath + '/dict/saveDict.do?pid=' + pid;

}

function refreshTree() {
	tree.tree("options").url=__ctxPath + '/dict/getDictTree.do';
	tree.tree('reload');
}

function saveDictFun() {
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
			dictgrid.datagrid('reload');
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

function delDictFun() {
	$.messager.confirm('确认','确定删除菜单信息?',function(r){
	    if (r){
	    	var rows = dictgrid.datagrid('getSelections');
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
	    		url : __ctxPath + '/dict/delDict.do',
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
	    			refreshTree();
	    			dictgrid.datagrid('reload');
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
	});
}

function editDictFun() {
	var rows = dictgrid.datagrid('getSelections');
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
            'zlxqDictionary.dicCode' : data.dic_code,
            'zlxqDictionary.dicName' : data.dic_name
        });
        
        form.url = __ctxPath + '/dict/editDict.do?id=' + data.id;
    }
}

function closeWindow() {
	win.window('close');
}
