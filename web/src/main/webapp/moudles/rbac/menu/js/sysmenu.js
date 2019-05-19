$(function() {
	sysmenutree = $('#sysmenuview');
	
	$('#btn-save-menu,#btn-cancel-menu').linkbutton();

	win = $('#addmenu-window').window({
		width : "100%",
	    height : "100%",
		closed : true,
		modal : true,
		shadow : false
	});
	form = win.find('form');
	
	sysmenutree.treegrid({
		url : __ctxPath + '/menu/getMenuTree.do',
		method : 'post', // 请求方式
		idField : 'id', // 定义标识树节点的键名字段
		treeField : 'name', // 定义树节点的字段
		fit : true, // 网格自动撑满
		fitColumns : true, // 设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
		columns : [ [ {
			field : 'name',
			title : '菜单名称',
			width : 100
		}, {
			field : 'menucode',
			title : '菜单编号',
			width : 100
		}, {
			field : 'menuurl',
			title : 'URL',
			width : 100
		}, {
			field : 'menutype',
			title : '菜单类型',
			width : 100
		}, {
			field : 'menusort',
			title : '菜单排序',
			width : 100
		} ] ],
		toolbar : [ {
			text : '刷新',
			iconCls : 'icon-reload',
			handler : refreshMenuFun
		}, {
			text : '新增',
			iconCls : 'icon-add',
			handler : addMenuFun
		}, {
			text : '删除',
			iconCls : 'icon-remove',
			handler : delMenuFun
		}, {
			text : '修改',
			iconCls : 'icon-edit',
			handler : editMenuFun
		} ]
	});
	$('body').layout();
});

var sysmenutree;
var win;
var form;

function refreshMenuFun() {
	sysmenutree.treegrid("options").url=__ctxPath + '/menu/getMenuTree.do',
	sysmenutree.treegrid('reload');
}

function addMenuFun() {
	var rows = sysmenutree.treegrid('getSelections');
	var menuid = null;
	if (rows.length != 0) {
		menuid = rows[0].id;
	}
	win.window('open');
	form.form('clear');
	form.url = __ctxPath + '/menu/saveMenuInfo.do?pid=' + menuid;
}

function editMenuFun() {
	var rows = sysmenutree.treegrid('getSelections');
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
    	var menuid = rows[0].id;
    	
        win.window('open');
        var data = rows[0];
        form.form('load', { // 调用load方法把所选中的数据load到表单中,非常方便
            'zlxqMenu.menucode' : data.menucode,
            'zlxqMenu.menuname' : data.name,
            'zlxqMenu.menuurl' : data.menuurl,
            'zlxqMenu.menutype' : data.menutype,
            'zlxqMenu.menusort' : data.menusort
        });
        
        form.url = __ctxPath + '/menu/saveMenuInfo.do?menuid=' + menuid;
    }
}

function delMenuFun() {
	$.messager.confirm('确认','确定删除菜单信息?',function(r){
	    if (r){
	    	var rows = sysmenutree.treegrid('getSelections');
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
	        var menuid = rows[0].id;
	        
	    	$.ajax({
	    		url : __ctxPath + '/menu/delMenu.do',
	    		type : 'post',
	    		data : {
	    			id : menuid
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
	    			sysmenutree.treegrid('reload');
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

function saveMenu() {
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
			refreshMenuFun();
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