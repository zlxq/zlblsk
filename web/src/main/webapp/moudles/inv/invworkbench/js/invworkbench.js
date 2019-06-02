$(function() {
	grid = $('#sysdeptgrid');
	qrCodeInput = $('#qrcodeId');
//	qrCodeInput.textbox('setValue', 10);
	qrCodeInput.textbox({
		onChange : function(newValue, oldValue) {
			if ('1' == newValue) {
				document.getElementById("div-qrcode-id").style.display="none";//隐藏
				document.getElementById("div-CK-id").style.display="";//显示
				document.getElementById("div-RK-id").style.display="none";//隐藏
				document.getElementById("div-PD-id").style.display="none";//隐藏
			} else if ('2' == newValue) {
				document.getElementById("div-qrcode-id").style.display="none";//隐藏
				document.getElementById("div-CK-id").style.display="none";//显示
				document.getElementById("div-RK-id").style.display="";//隐藏
				document.getElementById("div-PD-id").style.display="none";//隐藏
			} else if ('3' == newValue) {
				document.getElementById("div-qrcode-id").style.display="none";//隐藏
				document.getElementById("div-CK-id").style.display="none";//显示
				document.getElementById("div-RK-id").style.display="none";//隐藏
				document.getElementById("div-PD-id").style.display="";//隐藏
			}
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
			title : '单据编号',
			width : 100
		}, {
			field : 'partyname',
			title : '物料编码',
			width : 100,
			sortable : true
		}, {
			field : 'partyname1',
			title : '物料名称',
			width : 100,
			sortable : true
		}, {
			field : 'partyname2',
			title : '需求数量',
			width : 100,
			sortable : true
		}, {
			field : 'partyname4',
			title : '完成数量',
			width : 100,
			sortable : true
		} ] ]
	});
	$('body').layout();
});

var grid;
var qrCodeInput;
