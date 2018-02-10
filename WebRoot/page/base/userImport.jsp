<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>品牌管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
<!-- Prettyfile -->
<script src="js/plugins/prettyfile/bootstrap-prettyfile.js"></script>
<script type="text/javascript">
	function closeLayer() {
		window.parent.layer.closeAll();
	}
	function doSubmit(){
		$('#importForm').form('submit', {
			url : 'user/importData.action',
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				window.parent.location.reload();
				closeLayer();
			}
		});
	}
	function download(){
		window.location.href="user/download.action";
	}
</script>
</head>

<body>
	<form id="importForm" action="user/importData.action" method="post"
		enctype="multipart/form-data"
		<div class="ibox-content">
	         <div id="file-pretty">
	             <div class="form-group">
	                 <label class="font-noraml">文件选择</label>
	                 <input type="file" name="uploadfile" required class="form-control"/>
	             </div>
		</div>
		</div>
		
		<div class="form-group">
			  <div class="col-sm-4 col-sm-offset-3" style="text-align: center">
              	  <button class="btn btn-primary" type="button" onclick="download()">下载模板</button>
	              <button class="btn btn-success" type="button" id="tijiao" onclick="doSubmit()" >提交</button>
              </div>
	     </div>
	</form>
</body>
</html>
