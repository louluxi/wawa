$(document).ready(function() {
			$('div.summernote').each(function() {
				var $this = $(this);
				var placeholder = $this.attr("placeholder") || '';
				var url = $this.attr("action") || '';
				$this.summernote({
					lang : 'zh-CN',
					placeholder : placeholder,
					height : 300,
					dialogsFade : true,// Add fade effect on dialogs
					dialogsInBody : true,// Dialogs can be placed in body, not in
					// summernote.
					disableDragAndDrop : false,// default false You can disable drag
					callbacks : {
						// onImageUpload的参数为files，summernote支持选择多张图片
						onImageUpload : function(files) {
						var $files = $(files);
						// 通过each方法遍历每一个file
						$files.each(function() {
						var file = this;
						// FormData，新的form表单封装，具体可百度，但其实用法很简单，如下
						var data = new FormData();
						// 将文件加入到file中，后端可获得到参数名为“file”
						data.append("uploadfile", file);
						// ajax上传
						$.ajax({
							data : data,
							type : "POST",
							url : url,// div上的action
							cache : false,
							contentType : false,
							processData : false,
							// 成功时调用方法，后端返回json数据
							success : function(response) {
							// 封装的eval方法，可百度
							var json = YUNM.jsonEval(response);
							// 控制台输出返回数据
							YUNM.debug(json);
							// 封装方法，主要是显示错误提示信息
							YUNM.ajaxDone(json);
							// 状态ok时
							if (json[YUNM.keys.statusCode] == YUNM.statusCode.ok) {
							// 文件不为空
							if (json[YUNM.keys.result]) {
							// 获取后台数据保存的图片完整路径
							var imageUrl = json[YUNM.keys.result].completeSavePath;
							// 插入到summernote
							$this.summernote('insertImage', imageUrl, function($image) {
							// todo，后续可以对image对象增加新的css式样等等，这里默认
							});
							}
							}
							},
							// ajax请求失败时处理
							error : YUNM.ajaxError
						});
						});
					}}});
			});
			
		});
function getSkill(catId) {
	$.ajax({  
	       type : "POST",
			url : "product/getSkill.action?id=" + catId,
			dataType : "json",
			success : function(result) {  
				$('#skillDiv').html('');
				var html=""
				for(var i =0;i<result.length;i++){
					html = html + '<div class="form-group col-md-6">';
					html = html + '<input type="hidden" name="paramIds" value="'+result[i].id+'"/>';
					html = html + '<label class="col-sm-3 control-label">'+result[i].param_name+'：</label>';
					html = html + '<div class="col-sm-8 input-group">';
					html = html + '<input type="text" name="paramValues" class="form-control" placeholder="'+result[i].param_name+'">'
					html = html + '</div></div>';
				}
				$('#skillDiv').html(html);
	       }  
	   }); 
}
function toImport(){
	 //iframe层
  layer.open({
      type: 2,
      title: '导入产品',
      shadeClose: true,
      shade: 0.8,
      area: ['90%', '90%'],
      content: 'product/toImport.action' //iframe的url
  }); 
}
function exportData(){
	layer.open({
	       type: 2,
	       title: '导出产品',
	       shadeClose: true,
	       shade: 0.8,
	       area: ['90%', '90%'],
	       content: 'product/toExport.action' //iframe的url
	   }); 
}
		function iframeCallback(form, callback) {
			YUNM.debug("带文件上传处理");
			var $form = $(form), $iframe = $("#callbackframe");
			var data = $form.data('bootstrapValidator');
			if (data) {
				if (!data.isValid()) {
					return false;
				}
			}
			// 富文本编辑器
			$("div.summernote", $form).each(function() {
				var $this = $(this);
				if (!$this.summernote('isEmpty')) {
				var editor = "<input type='hidden' name='" + $this.attr("name") + "' value='" + $this.summernote('code') + "' />";
				$form.append(editor);
				} else {
				$.showErr("请填写信息内容");
				return false;
				}
			});
			if ($iframe.size() == 0) {
				$iframe = $("<iframe id='callbackframe' name='callbackframe' src='about:blank' style='display:none'></iframe>").appendTo("body");
			}
			if (!form.ajax) {
				$form.append('<input type="hidden" name="ajax" value="1" />');
			}
			form.target = "callbackframe";
			_iframeResponse($iframe[0], callback || YUNM.ajaxDone);
		}
		function _iframeResponse(iframe, callback) {
			var $iframe = $(iframe), $document = $(document);
			$document.trigger("ajaxStart");
			$iframe.bind("load", function(event) {
			$iframe.unbind("load");
			$document.trigger("ajaxStop");
			if (iframe.src == "javascript:'%3Chtml%3E%3C/html%3E';" || // For
			// Safari
			iframe.src == "javascript:'<html></html>';") { // For FF, IE
			return;
			}
			var doc = iframe.contentDocument || iframe.document;
			// fixing Opera 9.26,10.00
			if (doc.readyState && doc.readyState != 'complete')
			return;
			// fixing Opera 9.64
			if (doc.body && doc.body.innerHTML == "false")
			return;
			var response;
			if (doc.XMLDocument) {
			// response is a xml document Internet Explorer property
			response = doc.XMLDocument;
			} else if (doc.body) {
			try {
			response = $iframe.contents().find("body").text();
			response = jQuery.parseJSON(response);
			} catch (e) { // response is html document or plain text
			response = doc.body.innerHTML;
			}
			} else {
			// response is a xml document
			response = doc;
			}
			callback(response);
			});
		}
			$("input:button.sort").on("click", function() {
				if($(this).val() == "信息交流区") {
					$("div.InfoExchange").removeClass("vis");
					$("div.textbox").addClass("vis");
				} else {
					$("div.InfoExchange").addClass("vis");
					$("div.textbox").removeClass("vis");
				}
		});
		
		var edit = function() {
			$("#eg").addClass("no-padding");
			$('.click2edit').summernote({
				lang : 'zh-CN',
				focus : true
			});
		};
		var save = function() {
			$("#eg").removeClass("no-padding");
			var aHTML = $('.click2edit').code(); //save HTML If you need(aHTML: array).
			$('.click2edit').destroy();
		};
function backList() {
	//window.location.href = 'communicate/toLoadList.action';
	window.location.href = 'room/toLoadList.action';
}

function sendMessage(){
	var markupStr = $('#summernote').code();
	console.log(markupStr);
	$('#content').val(markupStr);
	$('#send_status').val("delivered");
	$('#messageForm').form('submit', {
		url : 'messageSend/saveOrUpdate.action',
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.result) {
			} else {
				swal("发送失败！", "请联系系统管理员。", "error");
			}
			backList();
		}
	});
}
function saveMessage(){
	var markupStr = $('#summernote').code();
	$('#content').val(markupStr);
	$('#send_status').val("saved");
	$('#messageForm').form('submit', {
		url : 'messageSend/saveOrUpdate.action',
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.result) {
			} else {
				swal("保存失败！", "请联系系统管理员。", "error");
			}
			backList();
		}
	});
	

}
