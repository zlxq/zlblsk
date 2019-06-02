	var map = new BMap.Map("allmap");
		map.centerAndZoom("西安",6);
		map.enableScrollWheelZoom(true); 
	
	var opts = {
			width : 250,     // 信息窗口宽度
			height: 80,     // 信息窗口高度
			title : "信息窗口" , // 信息窗口标题
			enableMessage:true//设置允许信息窗发送短息
		   };	
		
	function addMarker(longitude, latitude, content){
//		map.clearOverlays(); 
		var new_point = new BMap.Point(longitude,latitude);
		var marker = new BMap.Marker(new_point);  // 创建标注
		map.addOverlay(marker);              // 将标注添加到地图中
//		map.panTo(new_point);  //以标记点为中心 
		marker.setAnimation(BMAP_ANIMATION_BOUNCE);
		
		addClickHandler(content,marker);
	}
	
	function addClickHandler(content,marker){
		marker.addEventListener("click",function(e){
			openInfo(content,e)}
		);
	}
	function openInfo(content,e){
		var p = e.target;
		var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
		var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	}
	
	$.ajax({
		url : __ctxPath + '/inv/getSpaceAddress.do',
		type : 'post',
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
			var array = m.rows;
			if(array.length != 0){
				for (var i = 0; i < array.length; i ++) {
					var longitude = array[i].LONGITUDE; 
					var latitude = array[i].LATITUDE;
					var content = array[i].SAPCE_NAME;
					addMarker(longitude, latitude, content);
					
				}
			}
			
		}
	});
	

	