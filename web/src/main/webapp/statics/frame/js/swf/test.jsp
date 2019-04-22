<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	var __ctxPath="<%=request.getContextPath()%>
	";
</script>
<script type="text/javascript" src="./swfupload.js"></script>
<script type="text/javascript">
	var swfu;
	window.onload = function() {
		swfu = new SWFUpload({
			upload_url : '/FileUploadServlet',
			flash_url : './swfupload.swf',
			file_post_name : "Filedata",
			post_params : {
				"post_param_name_1" : "post_param_value_1",
				"post_param_name_2" : "post_param_value_2",
				"post_param_name_n" : "post_param_value_n"
			},
			use_query_string : false,
			requeue_on_error : false,
			http_success : [ 201, 202 ],
			assume_success_timeout : 0,
			/* file_types : "*.jpg;*.gif", */
			file_types : "*.*",
			file_types_description : "Web Image Files",
			file_size_limit : "1024",
			file_upload_limit : 10,
			file_queue_limit : 2,

			debug : false,

			prevent_swf_caching : false,
			preserve_relative_urls : false,

			button_placeholder_id : "spanButtonPlaceholder",
			button_image_url : "http://labs.goodje.com/swfu/swfu_bgimg.jpg",
			button_width : 61,
			button_height : 22,
			button_text : "<span class='redText'>选择文件</span>",
			button_text_style : ".redText { backgound-color: #FF0000; }",
			button_text_left_padding : 3,
			button_text_top_padding : 2,
			/* button_action : SWFUpload.BUTTON_ACTION.SELECT_FILES,
			button_disabled : false,
			button_cursor : SWFUpload.CURSOR.HAND,
			button_window_mode : SWFUpload.WINDOW_MODE.TRANSPARENT,
			
			swfupload_loaded_handler : swfupload_loaded_function,
			mouse_click_handler : mouse_click_function,
			mouse_over_handler : mouse_over_function,
			mouse_out_handler : mouse_out_function,
			file_dialog_start_handler : file_dialog_start_function,
			file_queued_handler : file_queued_function,
			file_queue_error_handler : file_queue_error_function,
			file_dialog_complete_handler : file_dialog_complete_function,
			upload_start_handler : upload_start_function,
			upload_progress_handler : upload_progress_function,
			upload_error_handler : upload_error_function,
			upload_success_handler : upload_success_function,
			upload_complete_handler : upload_complete_function,
			debug_handler : debug_function, */

			custom_settings : {
				custom_setting_1 : "custom_setting_value_1",
				custom_setting_2 : "custom_setting_value_2",
				custom_setting_n : "custom_setting_value_n",
			}

		});
	};
</script>
</head>
<body>
	<div id="swfupload">
		<span id="spanButtonPlaceholder"></span>
	</div>

</body>
</html>