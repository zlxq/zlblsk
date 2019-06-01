$(function() {
	(function(){
		/**......属性区............................................................................................................................*/
	  var history = new Array();
	  var cStep = -1;
	  
	  var draw = SVG("workarea").size('100%', '100%');
	  
	  var setMode = null;
	  
	  var strokeD =  "#" + $('#colorpicker-popup').val();
	  var fillD = "#" + $('#colorpicker-popup2').val();
	  
	  var tempStroke = null;//记录原始颜色
	  var tempFill = null;//记录原始颜色
	  
	  pointArray = new Array();//前台做选中效果的临时数组
	  
	  dataArray = new Array();//所有数据的集合
	  
	  var proDataArray = new Array();//有属性的数据集合
	  
	  var command = 0;
	  
	  var clickFlag = null;//定时器用于解决单双击冲突
	  
	  win = $('#property-window');
	  form = win.find('form');
	  
	  stackerWin = $('#stacker-window');
	  stackerForm = stackerWin.find('form');
	  
	  $('#btn-save-menu,#btn-cancel-menu').linkbutton();
	  
	  wingrid = $('#material-grid');
	  equipgrid = $('#equip-grid');
	  
	  wingrid.datagrid({
			url : __ctxPath + '/material/getMaterialPage.do',
			sortName : 'id',
			sortOrder : 'asc',
			idField : 'ID',
			pagination : true,
			rownumbers : true,
			singleSelect : true,
			pageSize : 30,
			loadMsg : '数据加载中请稍后……',
			fitColumns : true,
			frozenColumns : [[ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'CODE',
				title : '物料编码',
				width : 150
			}, {
				field : 'MODEL',
				title : '型号规格',
				width : 150,
				sortable : true
			}, {
				field : 'NAME',
				title : '物料名称',
				width : 150,
				sortable : true
			}, {
				field : 'UNIT',
				title : '计量单位',
				width : 50,
				sortable : true
			} ]],
			columns : [ [ {
				title : '包装规格',
				align : 'center',
				"colspan":3
			}], [ {
				field : 'LENGTH',
				title : '长',
				width : 50,
				sortable : true
			}, {
				field : 'WIDTH',
				title : '宽',
				width : 50,
				sortable : true
			}, {
				field : 'HEIGHT',
				title : '高',
				width : 50,
				sortable : true
			}] ]
		
		});
	  
	  equipgrid.datagrid({
			url : __ctxPath + '/equip/getEquipPage.do',
			sortName : 'id',
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
				field : 'EQUIP_NO',
				title : '设备编号',
				width : 100
			}, {
				field : 'SORT',
				title : '设备序号',
				width : 100,
				sortable : true
			}, {
				field : 'EQUIP_NAME',
				title : '设备类型',
				width : 100,
				sortable : true
			}, {
				field : 'EQUIP_STATE',
				title : '设备状态',
				width : 100,
				sortable : true
			} ] ]
		});
	  $('body').layout();
	  
	  /**......事件区...................................................................................................................................*/
	  
	  $("#create").click(createCanvas);
	  
	  $("#clear").click(clearCanvas);
	  
	  $("#save").click(saveCanvas);
	  
	  $("#createSvg").click(createLWUnit);
	  
	  $("#tool_select").on('click',function(){
		  setMode = "select";
		  selectType(setMode);
	  })
	  
	  $("#tool_text").on('click',function(){
		  setMode = "text";
		  selectType(setMode);
	  })
	  
	  /**......方法区..............................................................................................................................*/
	  
	  function createCanvas(){
		  draw.clear();
		  dataArray.length = 0;
		  pointArray.length = 0;
		  
		  
		  $("#storeRoom").val("");
		  $("#storeRoom_unit").val("");
		  
		  $("#level_num").val("0");
    	  $("#lattice_num").val("0");
    	 
    	  $("#rectangle_long").val("0");
    	  $("#rectangle_width").val("0");//侧面看 宽既是高
    	  $("#rectangle_height").val("0");//侧面看 高既是长
    	  
    	  //右侧
    	  $("#level_num_right").val("0");
    	  $("#lattice_num_right").val("0");
    	 
    	  $("#rectangle_long_right").val("0");
    	  $("#rectangle_width_right").val("0");
    	  $("#rectangle_height_right").val("0");
    	  
    	  $("#runCode").val("0");
    	  $("#inStoreRule").val("0");
    	  $("#stackerId").val("0");
	  }
	  
	  function clearCanvas(){
		  
		  dataArray.length = 0;
		  pointArray.length = 0;
		  
		  draw.clear();
	  }
	  
	  function saveCanvas(){
		  
		 var storeRoom = $("#storeRoom").val();
		 var storeRoom_unit = $("#storeRoom_unit").val();
		 var spacex = $("#space_x").val();
		 var spacey = $("#space_y").val();
		 
		 if(storeRoom == "" || storeRoom_unit == "" || spacex == "" || spacey == ""){
			 $.messager.show({
					title : '提示',
					msg : '请完善库房信息!',
					timeout : 500,
					style:{
						top:1, // 与左边界的距离
						left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
					}
				});
			 return;
		 }
		  
		  var svg = draw.svg();
		  $.ajax({
				url : __ctxPath + '/inv/saveInvSpaceInfo.do',
				type : 'post',
				data : {
					dataArray : JSON.stringify(dataArray),
					storeRoom :   storeRoom,
					storeRoom_unit : storeRoom_unit,
					spacex : spacex,
					spacey : spacey,
					svg : svg
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
	  
	  function selectType(type){
		  switch (type) {
		  case "select": {
	          $("#tool_select").addClass("tool_button_current").removeClass("tool_button");
	          $("#tool_text").removeClass("tool_button_current").addClass("tool_button");
	          break;
         }
         
		  case "text": {
	          $("#tool_text").addClass("tool_button_current").removeClass("tool_button");
	          $("#tool_select").removeClass("tool_button_current").addClass("tool_button");
	          break;
         }
		  }
	  }
	  
	  function createLWUnit(e){
		  //清除原画布信息
		  clearCanvas();
		  
		  //获取画布的长宽
		  var cttHeight = draw.node.clientHeight;
		  var ctxWdth = draw.node.clientWidth;
		  
		  var stockerWidth = 100;//预留堆垛机宽度
		  var stockerHeight = 50;//预留堆垛机高度
		  
		  //设置起始坐标
		  
		  var tempx = 0;
		  var tempy = cttHeight * 0.9;//原点坐标在左上角，现设置起点为左下角 画布的90%的高度

		  //库房信息
		  
		  var storeRoom = $("#storeRoom").val();
		  var storeRoom_unit = $("#storeRoom_unit").val();
		  
		  //左侧 
    	  var level_num = $("#level_num").val();
    	  var lattice_num = $("#lattice_num").val();
    	 
    	  var rectangle_long = $("#rectangle_long").val();
    	  var rectangle_width = $("#rectangle_width").val();//侧面看 宽既是高
    	  var rectangle_height = $("#rectangle_height").val();//侧面看 高既是长
    	  
    	  //右侧
    	  var level_num_right = $("#level_num_right").val();
    	  var lattice_num_right = $("#lattice_num_right").val();
    	 
    	  var rectangle_long_right = $("#rectangle_long_right").val();
    	  var rectangle_width_right = $("#rectangle_width_right").val();
    	  var rectangle_height_right = $("#rectangle_height_right").val();
    	  
    	  if(rectangle_width!=0 && rectangle_height!=0 && level_num != 0 && lattice_num != 0
        		 && rectangle_width_right!=0 && rectangle_height_right!=0 && level_num_right != 0 
        		 && lattice_num_right != 0 ){
    		  
    		  //适应画布宽高修改比例
    		  var h = getHeight(level_num, rectangle_height, level_num_right, rectangle_height_right, stockerWidth, ctxWdth);
    		  //高
    		  rectangle_height = h[0];
    		  rectangle_height_right = h[1];
    		  //宽
    		  rectangle_width = getWidth(lattice_num, rectangle_width, tempy);
    		  rectangle_width_right = getWidth(lattice_num_right, rectangle_width_right, tempy);
    		  
        	  //左
        	  var width = level_num * rectangle_height;
        	  var height = (lattice_num * level_num) * rectangle_width;
        	  //右
        	  var width_right = level_num_right * rectangle_height_right;
        	  var height_right = (lattice_num_right * level_num_right) * rectangle_width_right;
        	  
        	  //左侧货架的起始坐标
        	  var leftX = (ctxWdth - width - width_right - stockerWidth - 50)/2;
        	  var leftY = tempy-rectangle_width;
        	 
        	  //右侧货架的起始坐标 
        	  var rightX = leftX + width + stockerWidth + 100;
        	  var rightY = tempy-rectangle_width_right;
        	  
        	  //给定堆垛机位置
        	  var stockerX = leftX + width + 50;
        	  var stockerY = tempy - stockerHeight;
        	  
        	  var stocker = draw.rect(stockerWidth, 
        			  stockerHeight).attr({ stroke: strokeD,fill: fillD }).move(stockerX, stockerY);
        	  
        	  stocker.on('click', function(e){
    			  if(setMode == "select"){
    				  if(clickFlag){
    					  clickFlag = clearTimeout(clickFlag);//清除定时器，防止第二次点击生效 
    				  }
    				  clickFlag = setTimeout(function() {
    					  rectClick(e);
    				  }, 200);
    				  
    			  }
    		  })
    		  
    		  stocker.on('dblclick', function(e){
    			  if(setMode == "select"){
    				  if(clickFlag) {
    					 clickFlag = clearTimeout(clickFlag);
    				  } 
    				  dbClick(e);
    			  }
    		  })
    		  
    		  stocker.on('mousedown', function(e){
    			  if(setMode == "select"){
    				  rectDblclick(e);
    			  }
    		  })
        	  
        	  var rectData = {
        			  "rect" : stocker.node.id,
        			  "lor" : 'center',
        			  "type" : 'stocker',
        			  "storeRoom" : storeRoom,
        			  "storeRoom_unit" : storeRoom_unit,
        			  "level_num" : level_num,
        			  "lattice_num" : lattice_num,
        			  "rectangle_long" : "0",
        			  "rectangle_width" : stockerWidth,
        			  "rectangle_height" : stockerHeight,
        			  "invfloor" : '1',
        			  "invrow" : '1',
        			  "invcolumn" : '1',
        			  "isclose" : '',
        			  "runCode" : '',
        			  "inStoreRule" : '',
        			  "stackerId" : '',
        			  "materialId" : '',
        			  "equipname" : '',
        			  "materialno" : '',
        			  "materialname" : ""
        			  }
        		       dataArray.push(rectData);
        	  
        	  
//        	  左
        	  for(var row = 0; row < level_num; row++){
        		  var lx = leftX + (row * rectangle_height);
        		  var ly = null;
        		  var level = level_num - row;
        		  for(var col = 0; col < lattice_num; col++){
        			  ly = leftY-(col*rectangle_width);
            		  var rectLeft = draw.rect(rectangle_height, rectangle_width).attr({ stroke: strokeD,fill: fillD }).move(lx, ly);
            		  
            		  rectLeft.on('click', function(e){
            			  if(setMode == "select"){
            				  if(clickFlag){
            					  clickFlag = clearTimeout(clickFlag);//清除定时器，防止第二次点击生效 
            				  }
            				  clickFlag = setTimeout(function() {
            					  rectClick(e);
            				  }, 200);
            				  
            			  }
            		  })
            		  
            		  rectLeft.on('dblclick', function(e){
            			  if(setMode == "select"){
            				  if(clickFlag) {
             					 clickFlag = clearTimeout(clickFlag);
             				  } 
             				  dbClick(e);
             			  }
            		  })
            		  
            		  rectLeft.on('mousedown', function(e){
            			  if(setMode == "select"){
            				  rectDblclick(e);
            			  }
            		  })
            		  var rectData = {
            			  "rect" : rectLeft.node.id,
            			  "lor" : 'left',
            			  "type" : 'lattice',
            			  "storeRoom" : storeRoom,
            			  "storeRoom_unit" : storeRoom_unit,
            			  "level_num" : level_num,
            			  "lattice_num" : lattice_num,
            			  "rectangle_long" : rectangle_long,
            			  "rectangle_width" :  $("#rectangle_width").val(),
            			  "rectangle_height" :  $("#rectangle_height").val(),
            			  "invfloor" : level,
            			  "invrow" : '1',
            			  "invcolumn" : Number(col)+1,
            			  "isclose" : '',
            			  "runCode" : '',
            			  "inStoreRule" : '',
            			  "stackerId" : '',
            			  "materialId" : '',
            			  "equipname" : '',
            			  "materialno" : '',
            			  "materialname" : ""
            			  }
            		       dataArray.push(rectData);
            		  
        		  }
        		  
        		  //左侧台子的位置
        		  if (row == level_num-1){
        			  ly = ly - 50 - 50;//台子宽高是50*50，离货架距离50
        			  var rectLeft = draw.rect(50, 50).attr({ stroke: strokeD,fill: fillD }).move(lx + rectangle_height - 50, ly);
            		  
            		  rectLeft.on('click', function(e){
            			  if(setMode == "select"){
            				  if(clickFlag){
            					  clickFlag = clearTimeout(clickFlag);//清除定时器，防止第二次点击生效 
            				  }
            				  clickFlag = setTimeout(function() {
            					  rectClick(e);
            				  }, 200);
            				  
            			  }
            		  })
            		  
            		  rectLeft.on('dblclick', function(e){
            			  if(setMode == "select"){
            				  if(clickFlag) {
             					 clickFlag = clearTimeout(clickFlag);
             				  } 
             				  dbClick(e);
             			  }
            		  })
            		  
            		  rectLeft.on('mousedown', function(e){
            			  if(setMode == "select"){
            				  rectDblclick(e);
            			  }
            		  })
            		  
            		  var rectData = {
            			 "rect" : rectLeft.node.id,
            			 "lor" : 'left',
            			 "type" : 'platform',
            			 "storeRoom" : storeRoom,
	           			 "storeRoom_unit" : storeRoom_unit,
	           			 "level_num" : level_num,
	           			 "lattice_num" : lattice_num,
	           			 "rectangle_long" : rectangle_long,
	           			 "rectangle_width" :  $("#rectangle_width").val(),
          			     "rectangle_height" :  $("#rectangle_height").val(),
          			     "invfloor" : '1',
          			     "invrow" : '1',
          			     "invcolumn" : '1',
	           			 "isclose" : '',
	          			 "runCode" : '',
	          			 "inStoreRule" : '',
	          			 "stackerId" : '',
	          			 "materialId" : '',
	          			 "equipname" : '',
	        			 "materialno" : '',
	        			 "materialname" : ''
            		  }
            		  
            		  dataArray.push(rectData);
            		  
        		  }
        		  
        	  }
//        	  右
        	  for(var row = 0; row < level_num_right; row++){
        		  var rx = rightX + (row * rectangle_height_right);
        		  var ry = null;
        		  var level = Number(row)+1;
        		  for(var col = 0; col < lattice_num_right; col++){
        			  ry = rightY-(col*rectangle_width_right);
        			  var rectRight =draw.rect(rectangle_height_right, rectangle_width_right).attr({ stroke:strokeD, fill: fillD}).move(rx, ry);

        			  rectRight.on('click', function(e){
            			  if(setMode == "select"){
            				  if(clickFlag){
            					  clickFlag = clearTimeout(clickFlag);//清除定时器，防止第二次点击生效 
            				  }
            				  clickFlag = setTimeout(function() {
            					  rectClick(e);
            				  }, 200);
            				  
            			  }
            		  })
            		  
            		  rectRight.on('dblclick', function(e){
            			  if(setMode == "select"){
            				  if(clickFlag) {
             					 clickFlag = clearTimeout(clickFlag);
             				  } 
             				  dbClick(e);
             			  }
            		  })
            		  
            		  rectRight.on('mousedown', function(e){
            			  if(setMode == "select"){
            				  rectDblclick(e);
            			  }
            		  })
            		  
            		  var rectData = {
            			  "rect" : rectRight.node.id,
            			  "lor" : 'right',
            			  "type" : 'lattice',
            			  "storeRoom" : storeRoom,
 	           			  "storeRoom_unit" : storeRoom_unit,
 	           			  "level_num" : level_num_right,
 	           			  "lattice_num" : lattice_num_right,
 	           			  "rectangle_long" : rectangle_long_right,
 	           			  "rectangle_width" :  $("#rectangle_width_right").val(),
 	           			  "rectangle_height" : $("#rectangle_height_right").val(),
 	           			  "invfloor" : level,
 	           			  "invrow" : '2',
 	           			  "invcolumn" : Number(col)+1,
 	           			  "isclose" : '',
	          			  "runCode" : '',
	          			  "inStoreRule" : '',
	          			  "stackerId" : '',
	          			  "materialId" : '',
	          			  "equipname" : '',
	        			  "materialno" : '',
	        			  "materialname" : ''
            		  }
            		  
            		  dataArray.push(rectData);
            		  
        		  }
        		  //右侧台子的位置
        		  if (row == 0){
        			  var ry1 = ry - 50 - 50; //台子宽高是50*50，离货架距离50
        			  var rectRight = draw.rect(50, 50).attr({ stroke: strokeD,fill: fillD }).move(rx, ry1);
            		  
        			  rectRight.on('click', function(e){
            			  if(setMode == "select"){
            				  if(clickFlag){
            					  clickFlag = clearTimeout(clickFlag);//清除定时器，防止第二次点击生效 
            				  }
            				  clickFlag = setTimeout(function() {
            					  rectClick(e);
            				  }, 200);
            				  
            			  }
            		  })
            		  
            		  rectRight.on('dblclick', function(e){
            			  if(setMode == "select"){
            				  if(clickFlag) {
             					 clickFlag = clearTimeout(clickFlag);
             				  } 
             				  dbClick(e);
             			  }
            		  })
            		  
            		  rectRight.on('mousedown', function(e){
            			  if(setMode == "select"){
            				  rectDblclick(e);
            			  }
            		  })
            		  
            		  var rectData = {
            			  "rect" : rectRight.node.id,
            			  "lor" : 'right',
            			  "type" : 'platform',
            			  "storeRoom" : storeRoom,
 	           			  "storeRoom_unit" : storeRoom_unit,
 	           			  "level_num" : level_num_right,
	           			  "lattice_num" : lattice_num_right,
	           			  "rectangle_long" : rectangle_long_right,
	           			  "rectangle_width" :  $("#rectangle_width_right").val(),
	           			  "rectangle_height" : $("#rectangle_height_right").val(),
	           			  "invfloor" : '1',
	           			  "invrow" : '2',
	           			  "invcolumn" : '1',
 	           			  "isclose" : '',
	          			  "runCode" : '',
	          			  "inStoreRule" : '',
	          			  "stackerId" : '',
	          			  "materialId" : '',
	          			  "equipname" : '',
	        			  "materialno" : '',
	        			  "materialname" : ''
            		  }
            		  
            		  dataArray.push(rectData);
        		  }
        	  }
          }else{
        	  $.messager.show({
	    			title : '提示',
	    			msg : '请完善两侧货架信息!',
	    			timeout : 500,
	    			style:{
	    				top:1, // 与左边界的距离
	    				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
	    			}
	    		});
          }
	  }	
	  
	  function getWidth(lattice_num, rectangle_width, tempy){
		  
		  var twidth =  (Number(lattice_num)+1) *  Number(rectangle_width) + 50;

		  if( twidth > tempy){
			  rectangle_width = rectangle_width / (twidth / tempy);
		  }else{
			  rectangle_width = rectangle_width * (tempy / twidth);
		  }
		  
		  return rectangle_width - 10;
		  
	  }
	  
	  function getHeight(level_num, rectangle_height, level_num_right, rectangle_height_right, stockerWidth, ctxWdth){
		  
		  var tharray = new Array();
		  
		  var theight = Number(level_num) * Number(rectangle_height) + Number(level_num_right) * 
				  Number(rectangle_height_right) + Number(stockerWidth) + 150;
		  
		  if(theight > ctxWdth){
			  
			  rectangle_height = rectangle_height / (theight / (ctxWdth - stockerWidth - 150));
			  
			  rectangle_height_right = rectangle_height_right / (theight / (ctxWdth - stockerWidth - 150));
			  
			  tharray.push(rectangle_height);
			  tharray.push(rectangle_height_right);
			  
		  }else{
			  rectangle_height = rectangle_height * (ctxWdth / theight);
			  
			  rectangle_height_right = rectangle_height_right * (ctxWdth / theight);
			  
			  tharray.push(rectangle_height);
			  tharray.push(rectangle_height_right);
		  }
		 
		  return tharray;
	  }
	  
	  
	  function rectClick(e){
		  var id = e.srcElement.id;
		  var x = e.srcElement.x.animVal.valueAsString;
		  var y = e.srcElement.y.animVal.valueAsString;
		  var width = e.srcElement.width.animVal.valueAsString;
		  var height = e.srcElement.height.animVal.valueAsString;
		  var tempStroke = e.srcElement.attributes.stroke.value;
		  var tempFill = e.srcElement.attributes.fill.value;
		  
		  var node = document.getElementById(id)
		  node.setAttribute('stroke','#ffff1c');
		  node.setAttribute('stroke-width','3px');
		  
		  if(dataArray.length != 0){
			  
			  for(var i = 0; i < dataArray.length; i ++){
				  var data = dataArray[i].rect;
				  if(data == id){
					  $('#latticeIsClose').val(dataArray[i].isclose);
					  $('#latticeRunCode').val(dataArray[i].runCode);
					  $('#latticeInStoreRule').val(dataArray[i].inStoreRule);
					  $('#spaceStackerId').val(dataArray[i].equipname);
					  $('#no').val(dataArray[i].materialno);
					  $('#name').val(dataArray[i].materialname);
					  var datas = {
							'id' : id,
							'x' : x,
							'y' : y,
							'width' : width,
							'height' : height,
							'stroke' : tempStroke,
							'fill' : tempFill,
							'type' : dataArray[i].type
					  }
					  pointArray.push(datas);
					  
				  }
			  }
			  
		  }
		  
	  }
	  
	  function dbClick(e){
		  var ids = e.srcElement.id;
		  var node = document.getElementById(ids);
		  for(var i = 0; i < pointArray.length; i ++){
			  if(ids == pointArray[i].id){
				  pointArray.splice(i, 1);
//				  node.setAttribute('fill',fillD);
				  node.setAttribute('stroke',strokeD);
				  node.setAttribute('stroke-width','1px');
				  break;
			  }
		  } 
	  }
	  
	  
	  function rectDblclick(e){
		  var id = e.srcElement.id;
		  var node = document.getElementById(id);
	      node.oncontextmenu = function(event){
		  if(event.button=='2'){
			event.preventDefault();
			rightClick(e);
		   }
		  }
	  }
	  
	  
	  function rightClick(e){
		  if(pointArray.length ==0){
			  $.messager.show({
	    			title : '提示',
	    			msg : '请选择需要修改的位置!',
	    			timeout : 500,
	    			style:{
	    				top:1, // 与左边界的距离
	    				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
	    			}
	    		});
		  }else{
			  if(pointArray.length == 1 && (pointArray[0].type == "stocker" || pointArray[0].type == "platform")){
				  stackerWin.window('open');
				  stackerForm.form('clear');
			  }else{
				  var b = true;
				  for(var i = 0; i < pointArray.length; i ++){
					  if(pointArray[i].type == "stocker" || pointArray[i].type == "platform"){
						 b = false;
						 break;
					  }
				  }
				  if(b){
					  win.window('open');
					  form.form('clear');
				  }else{
					  $.messager.show({
			    			title : '提示',
			    			msg : '请单独设置设备信息!',
			    			timeout : 500,
			    			style:{
			    				top:1, // 与左边界的距离
			    				left:document.body.clientWidth - document.body.clientWidth / 1.5 // 与顶部的距离
			    			}
			    		});
				  }
				  
			  }
			  
		  }

	  }
	  
	  /**.......特殊插件区........................................................................................................................................*/
	  $("#colorpicker-popup").colorpicker({
		     buttonColorize: true,
		     alpha:          true,
		     draggable:       true,
	        showOn:         'both',
		   	close:borderColorEventListener
		  });
		  
		  function borderColorEventListener(e)
		  {
			  var color= "#"+$(this).val();
			  strokeD = color;
			  
		  }
		  
		  
		  //5. Fill Color Picker
		  $("#colorpicker-popup2").colorpicker({
		     buttonColorize: true,
		     alpha:          true,
		     draggable:       true,
	         showOn:         'both',
	         close:fillColorEventListener
		  });
		  
		  function fillColorEventListener(e)
		  {
			  	var color= "#"+$(this).val();
		   	   	fillD = color;
		  }
	  
	  
	  
	})();
});

var win;

var stackerWin;

var stackerForm;

var form;

var pointArray;//前台做选中效果的临时数组

var dataArray;//所有数据的集合

var equipgrid;

var wingrid;


function setProperty(e){
	
	var selectvalue = null;
	var latticeOptions = $("[name='latticeOptions']");
	if(e == "b"){
		latticeOptions = $("[name='latticeOption']");
	}
	
	for(var i=0; i<latticeOptions.length; i++){

        if(latticeOptions[i].checked==true) {
             selectvalue=latticeOptions[i].value;
             break;
       }
	}
	
	var runCode = $("#runCode  option:selected").text();
	
	var inStoreRule = $("#inStoreRule  option:selected").text();
	
	var stacker = equipgrid.datagrid('getSelections');
	var stackerId = "";
	var equipname = "";
	var materialId = "";
	var materialno = "";
	var materialname = "";
	
	if(stacker.length == 1){
		stackerId = stacker[0].ID;
		equipname = stacker[0].EQUIP_NO;
	}
	
	var material = wingrid.datagrid('getSelections');
	if(material.length == 1){
		materialId = material[0].ID;
		materialno = material[0].CODE;
		materialname = material[0].NAME;
	}
	
	
	for(var i = 0; i < pointArray.length; i++){
		  var latticeData = pointArray[i]; 
		  var id = latticeData.id;
		  var stroke = latticeData.stroke;
		  var node = document.getElementById(id)
		  if(selectvalue == "open"){
			  node.setAttribute('fill','#00ff40');
			  node.setAttribute('stroke',stroke);
			  node.setAttribute('stroke-width','1px');
		  }else{
			  node.setAttribute('fill','#ff0000');
			  node.setAttribute('stroke',stroke);
			  node.setAttribute('stroke-width','1px');
		  }
		  
		  for(var j = 0; j < dataArray.length; j++){
			  var data = dataArray[j]; 
			  var ids = data.rect;
			  if(ids == id){
				  data.isclose = selectvalue;
				  data.runCode = runCode;
				  data.inStoreRule = inStoreRule;
				  data.materialId = materialId;
				  data.stackerId = stackerId;
				  data.equipname = equipname;
				  data.materialno = materialno;
				  data.materialname = materialname;
				  dataArray.splice(j, 1);
				  dataArray.push(data);
			  }
		  }
	  }
	
	pointArray.length = 0;
	win.window('close');
	stackerWin.window('close');
	
	
}


function closeWindow(){
	  win.window('close');
	  stackerWin.window('close');
}