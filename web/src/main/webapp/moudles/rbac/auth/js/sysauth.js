$(function() {
	grid = $('#sysauthgrid');
	tree = $('#sysauthtree');
	tree1 = $('#sysauthtree1');
	tree2 = $('#sysauthtree2');

	$('#btn-save-auth,#btn-cancel-auth').linkbutton();
	win = $('#sysauthform-window').window({
	    width : "100%",
	    height : "100%",
		closed : true,
		modal : true,
		shadow : false
	});
	form = win.find('form');
	
	roleWin = $('#sysroleform-window').window({
		width : "100%",
		height : "100%",
		closed : true,
		modal : true,
		shadow : false
	});
	roleForm = roleWin.find('form');

	tree.treegrid({
		url : '',
		method : 'post', // 请求方式
		idField : 'id', // 定义标识树节点的键名字段
		treeField : 'name', // 定义树节点的字段
		fit : true, // 网格自动撑满
		fitColumns : true, // 设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
		columns : [ [ {
			field : 'name',
			title : '已授权菜单',
			width : 100
		} ] ]
	});

	tree1.treegrid({
		url : '',
		method : 'post', // 请求方式
		idField : 'id', // 定义标识树节点的键名字段
		treeField : 'name', // 定义树节点的字段
		fit : true, // 网格自动撑满
		fitColumns : true, // 设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
		columns : [ [ {
			field : 'name',
			title : '未授权菜单',
			width : 100
		} ] ]
	});

	tree2.treegrid({
		url : '',
		method : 'post', // 请求方式
		idField : 'id', // 定义标识树节点的键名字段
		treeField : 'name', // 定义树节点的字段
		fit : true, // 网格自动撑满
		fitColumns : true, // 设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
		columns : [ [ {
			field : 'name',
			title : '已授权菜单',
			width : 100
		} ] ]
	});

	// ${pageContext.request.contextPath}/
	grid.datagrid({
		url : __ctxPath + '/role/getRoleInfo.do',
		sortName : 'id',
		sortOrder : 'asc',
		idField : 'id',
		pagination : true,
		rownumbers : true,
		singleSelect : true,
		pageSize : 30,
		loadMsg : '数据加载中请稍后……',
		fitColumns : true,
		columns : [ [ {
			field : 'roleno',
			title : '角色编号',
			width : 100
		}, {
			field : 'rolename',
			title : '角色名称',
			width : 100,
			sortable : true
		}, {
			field : 'roletype',
			title : '角色类型',
			width : 100,
			sortable : true,
			render : function(a, b, c){
				if(a == '100100'){
					return "超级管理员";
				}
				return a;
			}
		} ] ],
		toolbar : [ {
			text : '增加角色',
			iconCls : 'icon-add',
			handler : addRoleFun
		}, {
			text : '删除角色',
			iconCls : 'icon-remove',
			handler : delAuthFun
		}, {
			text : '角色授权',
			iconCls : 'icon-add',
			handler : addAuthFun
		} ],
		onClickRow : onClickDataGrid
	});
	$('body').layout();
});

var win;
var roleWin;
var roleForm;
var form
var tree;
var grid;

function addRoleFun() {
	roleWin.window('open');
	roleForm.form('clear');
}

function delAuthFun() {
	
}

function onClickDataGrid(index, row) {
	tree.treegrid('loadData',{total:0,rows:[]});
	tree.treegrid({
		url : __ctxPath + '/menu/getRoleMenu.do?id=' + row.id
	});
}

function removeRightToLeftFun() {
	var row = tree2.treegrid('getSelected');
	var t2d = tree1.treegrid('getData');

	var targetNode = getNode(tree2, t2d, row, row);
	
	var node = {};
	node = getJsonData(tree2, t2d, row, targetNode, node);
	
	tree1.treegrid('append', {
		parent : node.parent,
		data : [ node.data ]
	});
	
	removeChild(tree2, row);
}

function removeLeftToRightFun() {
	var row = tree1.treegrid('getSelected');
	var t2d = tree2.treegrid('getData');

	var targetNode = getNode(tree1, t2d, row, row);
	
	var node = {};
	node = getJsonData(tree1, t2d, row, targetNode, node);
	
	tree2.treegrid('append', {
		parent : node.parent,
		data : [ node.data ]
	});
	
	removeChild(tree1, row);
}

function removeChild(tree, row) {
	var pnode = tree.treegrid('getParent', row.id);
	var pid;
	if (pnode.children.length == 1) {
		pid = pnode.id;
	}
	
	tree.treegrid('remove',row.id);
	
	if (pnode.children.length == 0) {
		tree.treegrid('remove',pid);//
	}
}

function getNode(tree, t2d, row, row1) {
	for (var i = 0; i < t2d.length; i++) {
		
		if (t2d[i].id == row._parentId) {
			bool = true;
			return t2d[i];
		} else {
			var children = t2d[i].children;
			if (undefined != children) {
				row = tree.treegrid('getParent', row.id)
				getNode(children, row, row1);
			}
		}
		row = row1;
	}
	return {};
}

function getJsonData(tree, t2d, row, targetNode, node) {
	var bool = false;
	var parent = null;
	
	node = getObject(row, node);
	
	if (undefined != node.parent && undefined == targetNode.id) {
		if (null != row._parentId) {
			row = tree.treegrid('getParent', row.id)
			getJsonData(tree, t2d, row, targetNode, node);
		}
	}
	
	return {
		parent : node.parent,
		data : node.data
	};
}

function getObject(row, node) {
	var o = {
			_parentId : row._parentId,
			id : row.id,
			name : row.name,
			iconCls : 'icon-city',
			state : 'open'
		};
	if (undefined != node.parent) {
		node.data = {
				_parentId : row._parentId,
				id : row.id,
				name : row.name,
				iconCls : 'icon-city',
				state : 'open',
				children : [node.data]
		};
	} else {
		node.data = o;
	}
	node.parent = row._parentId;
	return node;
}

function getJsonResult(row, o) {
	row = tree1.treegrid('getParent', row.id);

	var o2 = {
		_parentId : row._parentId,
		id : row.id,
		name : row.name,
		iconCls : 'icon-city',
		state : 'open',
		children : [ o ]
	}

	if (null != row._parentId) {
		getJsonResult(row, o2);
	}
	return o2;
}

function addAuthFun() {
	var rows = grid.datagrid('getSelections');

	var length = rows.length;

	if (length != 1) {
		$.messager.show({
			title : '提示',
			msg : '请选择一条数据!',
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

	tree1.treegrid({
		url : __ctxPath + '/menu/getNoRoleMenu.do?id=' + rows[0].id
	});
	tree2.treegrid({
		url : __ctxPath + '/menu/getRoleMenu.do?id=' + rows[0].id
	});
}

function getSubmintData(t2d, selFuns) {
	for (var i = 0; i < t2d.length; i++) {
		
		selFuns.push(t2d[i].id);
		
		var children = t2d[i].children;
		if (undefined != children) {
			getSubmintData(children, selFuns);
		}
	}
	return selFuns;
}

function saveAuthFun() {
	var rows = grid.datagrid('getSelections');
	var t2d = tree2.treegrid('getData');
	
	var selFuns = [];
	selFuns = getSubmintData(t2d, selFuns);

	$.ajax({
		url : __ctxPath + '/menu/saveRoleMenu.do',
		type : 'post',
		data : {
			roleid : rows[0].id,
			selFuns : JSON.stringify(selFuns)
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
			win.window('close');
			var rows = grid.datagrid('getSelections');
			
			tree.treegrid({
				url : __ctxPath + '/menu/getRoleMenu.do?id=' + rows[0].id
			});
			
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

function saveRoleFun() {
	$.messager.progress();
	
	roleForm.form('submit', {
		url : __ctxPath + '/role/saveRole.do',
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (!isValid){
				$.messager.progress('close');
			}
			return isValid;
		},
		success : function(e, f) {
			grid.datagrid('reload');
			roleWin.window('close');

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

function closeWindow() {
	win.window('close');
}

function closeRoleWindow() {
	roleWin.window('close');
}
