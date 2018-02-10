<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>会员详情</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li><a href="member/toLoadList.action">套餐管理</a></li>
						<li class="active"><a href="member/getInfoById.action?opt=1">${title}</a></li>
					</ul>
					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="member/saveOrUpdate.action" method="post">
									  <input type="hidden" name="member.id" id="id" value='<s:property value="member.id"/>'/>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">套餐价格：</label>
								          <div class="col-sm-8">
								              <input id="price"  name="meal.price"  minlength="2" type="text" value='<s:property value="meal.price"/>' class="form-control" required="" aria-required="true">
								          	  <span class="help-block m-b-none" id="alt"></span>
								          </div> 
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">娃娃币：</label>
								          <div class="col-sm-8">
								              <input id="doll_coin"   name="meal.doll_coin" minlength="2"  value='<s:property value="meal.doll_coin"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">套餐名称：</label>
								          <div class="col-sm-8">
								              <input id="name" name="meal.name" minlength="2" type="text" value='<s:property value="meal.name"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">套餐描述：</label>
								          <div class="col-sm-8">
								              <input id="remark" name="meal.remark" minlength="2" type="text" value='<s:property value="meal.remark"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">套餐状态：</label>
								          <div class="col-sm-8">
								              <input id="status" name="meal.status" minlength="2" type="text" value='<s:property value="meal.status"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								       <div class="form-group">
								          <label class="col-sm-3 control-label">有效期起：</label>
								          <div class="col-sm-8">
								              <input id="validity_start" name="meal.validity_start" minlength="2" type="text" value='<s:property value="meal.validity_start"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">有效期至：</label>
								          <div class="col-sm-8">
								              <input id="validity_end" name="meal.validity_end" minlength="2" type="text" value='<s:property value="meal.validity_end"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>								    						   	
								      <div class="form-group">
								          <label class="col-sm-3 control-label">机构编码：</label>
								          <div class="col-sm-8">
								               <input id="corp_code" name="meal.corp_code" minlength="2" type="text" value='<s:property value="meal.corp_code"/>' class="form-control" required="" aria-required="true">
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