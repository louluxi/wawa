<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function() {
	if('' != $('#userId').val()&&'0' != $('#userId').val()&& null != $('#userId').val()){
		$.ajax({
				type : "POST",
				url : "user/getUserRole.action?userId="+$('#userId').val(),
				dataType : "json",
				success : function(data) {
					var ids = []
					for(var i =0;i<data.length;i++){
						ids.push(data[i].role_id);
					}
					$('#role').selectpicker('val', ids);
				}
			});
	}
	$.ajax({  
	        type : "POST",
			url : "factory/getGroupList.action",
	        async: false,
			dataType : "json",
			success : function(data) {
				var rows = data.rows;
				var str = "";
	            for(var i = 0;i<rows.length;i++){
	               str+='<option value='+rows[i].purchase_group+'>'+rows[i].purchase_group+'</option>'
	            }
	            $("#factoryCom").html(str);
	            var s = $('#order_group').val();
	            if(null != s && '' != s){
					ss = s.split(",");
		            $("#factoryCom").selectpicker('val', ss);
	            }
	            $("#factoryCom" ).selectpicker('refresh');
			}
		});
	var keys = document.cookie.match(/[^ =;]+(?=\=)/g);  
    if(keys) {  
        for(var i = keys.length; i--;)  
            document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()  
    }  
	});
	function cleanData(obj){
		if('material' != obj){
			$('#'+obj).selectpicker('val', '');
		}else{
			$('#material').val("");
		}
	}
	function checkUserCode(objVal) {
		$.ajax({
			type : "POST",
			url : "user/checkCode.action",
			data : {
				user_code : objVal
			},
			dataType : "json",
			success : function(result) {
				// var result = eval('('+result+')');
				if (result.result != 'false') {
					$('#alt').text("系统中已存在该编码：" + objVal + "");
					$('#userCode').val("");
				} else {
					$('#alt').text("验证通过");
				}
			}
		});
	}
</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li>
							<a href="user/toLoadList.action">用户管理</a>
						</li>
						<li class="active">
							<a href="user/getInfoById.action?opt=1">${title}</a>
						</li>
					</ul>
					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="user/saveOrUpdate.action" method="post">
									  <input type="hidden" name="user.id" id="userId" value='<s:property value="user.id"/>'/>
									  <input type="hidden" id="order_group" value='<s:property value="user.order_group"/>'/>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">用户账号：</label>
								          <div class="col-sm-8">
								              <input id="user_code" autocomplete="off" name="user.user_code" id="userCode" onchange="checkUserCode(this.value)" minlength="2" type="text" value='<s:property value="user.user_code" default=""/>' class="form-control" required="" aria-required="true">
								          	  <span class="help-block m-b-none" id="alt"></span>
								          </div>
								      </div>
								      <input type="password" name="user.user_pwd" style="display:none">
								      <div class="form-group">
								          <label class="col-sm-3 control-label">用户密码：</label>
								          <div class="col-sm-8">
								              <input id="user_pwd" placeholder="" autocomplete="off" name="user.user_pwd" minlength="2" type="password" value='' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">企业名称：</label>
								          <div class="col-sm-8">
								              <input id="business_name" name="user.business_name" minlength="2" type="text" value='<s:property value="user.business_name"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">企业邮箱：</label>
								          <div class="col-sm-8">
								              <input id="business_email" name="user.business_email" minlength="2" type="text" value='<s:property value="user.business_email"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">部门：</label>
								          <div class="col-sm-8">
								              <input id="department" name="user.department" minlength="2" type="text" value='<s:property value="user.department"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">职务：</label>
								          <div class="col-sm-8">
								              <input id="post" name="user.post" minlength="2" type="text" value='<s:property value="user.post"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">姓名：</label>
								          <div class="col-sm-8">
								              <input id="user_name" name="user.user_name" minlength="2" type="text" value='<s:property value="user.user_name"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">性别：</label>
								          <div class="col-sm-8">
								          		<select class="form-control m-b" name="user.gender">
								          			<s:iterator value="genderList" var="dict">
			                                        	<option value='<s:property value="#dict.dictId"/>' <s:if test="user.gender == #dict.dictId">selected='selected'</s:if>><s:property value="#dict.dictName"/></option>
								          			</s:iterator>
			                                    </select>
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">联系电话：</label>
								          <div class="col-sm-8">
								              <input id="user_tel" name="user.user_tel" minlength="2" type="text" value='<s:property value="user.user_tel"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">联系人邮箱：</label>
								          <div class="col-sm-8">
								              <input id="user_email" name="user.user_email" minlength="2" type="text" value='<s:property value="user.user_email"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
									        <label class="col-sm-3 control-label">采购组：</label>
									        <div class="col-sm-8">
									        	<select class="form-control selectpicker" multiple="multiple" data-live-search="true" name="user.order_group" id="factoryCom">
									            </select>
									             <a class="glyphicon glyphicon-remove btn form-control-feedback" onclick="cleanData('factoryCom')" style="pointer-events: auto"></a>
									        </div>
									    </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">用户类型：</label>
								          <div class="col-sm-8">
								          		<select class="form-control m-b" name="user.user_type">
								          			<s:iterator value="userTypeList" var="dict">
			                                        	<option value='<s:property value="#dict.dictId"/>' <s:if test="user.user_type == #dict.dictId">selected='selected'</s:if>><s:property value="#dict.dictName"/></option>
								          			</s:iterator>
			                                    </select>
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">用户角色：</label>
								          <div class="col-sm-8">
								              <select class="form-control selectpicker" data-live-search="true" multiple name="user.role" id="role">
			                                     <s:iterator value="roleList" var="role">
		                                        	<option value='<s:property value="#role.id"/>'><s:property value="#role.role_id"/>_<s:property value="#role.role_name"/></option>
							          			 </s:iterator>
			                                  </select>
								          </div>
								      </div>
								      <div class="form-group">
								          <div class="col-sm-4 col-sm-offset-3">
								              <button class="btn btn-primary" type="submit">提交</button>
								              <button class="btn btn-warning" onclick="history.go(-1)">返 回</button>
								          </div>
								      </div>
								  </form>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>