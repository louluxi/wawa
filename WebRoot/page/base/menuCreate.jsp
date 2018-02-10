<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>菜单管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
<style type="text/css">
.invalid:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
    color: red;  
}

.invalid::-moz-placeholder { /* Mozilla Firefox 19+ */
    color: red;
}

.invalid:-ms-input-placeholder{
    color: red;
}

.invalid::-webkit-input-placeholder {
    color: red;
}
</style>
<script type="text/javascript">
	function selIcon(){
	    layer.open({
	        type: 2,
	        title: '选择图标',
	        shadeClose: true,
	        shade: 0.8,
	        area: ['500px', '400px'],
	        content: 'page/base/tagIconselect.jsp' //iframe的url
	    }); 
	}
</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li><a href="menu/toLoadList.action">菜单列表</a></li>
						<li class="active"><a href="menu/getInfoById.action?opt=1">${title}</a></li>
					</ul>
					<div class="tab-content" style="background: #fff;border: 1px solid #e7eaec;border-radius: 2px;">
						<form role="form" id="myForm" class="form-horizontal m-t" onsubmit="return validate();"
							action="menu/saveOrUpdate.action" method="POST">
							<div class="form-group">
								<input type="hidden" name="menu.id" value='<s:property value="menu.id"/>'/>
								<div class="form-group">
									<label class="col-sm-3 control-label">菜单标识:</label>
									<div class="col-sm-8" style="margin-top: 7px;">
										<h9><s:property value="menu.id"/></h9>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">名称:</label>
									<div class="col-sm-8">
										<input id="resource_name" name="menu.resource_name" class="form-control" aria-required="true" 
											type="text" value='<s:property value="menu.resource_name"/>' maxlength="50">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">资源类型:</label>
									<div class="col-sm-8">
										<select class="form-control m-b" name="menu.resource_type_id">
						          			<s:iterator value="resourceTypeList" var="resourceType">
	                                        	<option value='<s:property value="#resourceType.id"/>' <s:if test="menu.resource_type_id == #resourceType.id">selected='selected'</s:if>><s:property value="#resourceType.resource_type_name"/></option>
						          			</s:iterator>
	                                    </select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">父节点菜单标识:</label>
									<div class="col-sm-8">
										<input id="parent_id" name="menu.parent_id" class="form-control" aria-required="true" 
											type="text" value='<s:property value="menu.parent_id"/>' maxlength="2000">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">链接:</label>
									<div class="col-sm-8">
										<input id="url" name="menu.url" class="form-control" aria-required="true" 
											type="text" value='<s:property value="menu.url"/>' maxlength="2000">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">图标:</label>
									<div class="col-sm-8">
										<s:if test="menu.icon_img != null and menu.icon_img != ''">
											<span id="icon"  onclick="selIcon()"><s:property value="menu.icon_img" escape="false"/></span>
										</s:if>
										<s:else>
											<span id="icon" onclick="selIcon()">选择</span>
										</s:else>
										<input type="hidden" id="icon_img" name="menu.icon_img" class="form-control" aria-required="true" type="text" value='<s:property value="menu.icon_img"/>' maxlength="2000">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">排序:</label>
									<div class="col-sm-8">
										<input id="display_order" name="menu.display_order" class="form-control" aria-required="true" 
											type="text" value='<s:property value="menu.display_order"/>' maxlength="50">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">等级:</label>
									<div class="col-sm-8">
										<input id="level" name="menu.level" class="form-control" aria-required="true"
											type="text" value='<s:property value="menu.level"/>' maxlength="100">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">可见:</label>
									<div class="col-sm-8">
										<span>
											<input name="menu.is_show" type="radio" value="Y" <s:if test="menu.is_show == 'Y'.toString()">checked</s:if> />
											<label for="isShow1">显示</label>
										</span>
										<span>
											<input name="menu.is_show" type="radio" value="N" <s:if test="menu.is_show == 'N'.toString()">checked</s:if> />
											<label for="isShow2">隐藏</label>
										</span>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-3">
										<button class="btn btn-primary" type="submit">保 存</button>
										<button class="btn" type="button" onclick="history.go(-1)">返 回</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		var flag = true;
		function validate() {
			$("input").not("type='hidden'").each(function() {
				if($(this).val() == "" || $(this).prop("checked") == false) {
	                $(this).attr("placeholder","此项不能为空！");
    				$(this).addClass("invalid");
    				flag = false;
				} else {
	                $(this).attr("placeholder","");
    				$(this).removeClass("invalid");
    				flag = true;
				}
			});
			return flag;
		}
		
		$("input#level").on("blur", function() {
			var str = $("input#level").val();
			var re = /^[1-2]{1}$/;
			if(!re.test(str)) {
				$("input#level").val("");
			}
		})
	</script>
</body>
</html>