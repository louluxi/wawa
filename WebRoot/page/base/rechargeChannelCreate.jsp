<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li>
							<a href="rechargeChannel/toLoadList.action">支付方式管理</a>
						</li>
						<li class="active">
							<a href="rechargeChannel/getInfoById.action?opt=1">${title}</a>
						</li>
					</ul>
					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="rechargeChannel/saveOrUpdate.action" method="post">
									  <input type="hidden" name="rechargeChannel.id" id="id" value='<s:property value="rechargeChannel.id"/>'/>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">支付方式：</label>
								          <div class="col-sm-8">
								              <input id="payname"  name="rechargeChannel.payname"   type="text" value='<s:property value="rechargeChannel.payname"/>' class="form-control" required="" aria-required="true">
								          	  <span class="help-block m-b-none" id="alt"></span>
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">渠道说明：</label>
								          <div class="col-sm-8">
								              <input id="remark"   name="rechargeChannel.remark"   value='<s:property value="rechargeChannel.remark"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">收款账户：</label>
								          <div class="col-sm-8">
								              <input id="recv_account" name="rechargeChannel.recv_account"  type="text" value='<s:property value="rechargeChannel.recv_account"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">费率（%）：</label>
								          <div class="col-sm-8">
								              <input id="fee" name="rechargeChannel.fee"  type="text" value='<s:property value="rechargeChannel.fee"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">商户号：</label>
								          <div class="col-sm-8">
								              <input id="mch_id" name="rechargeChannel.mch_id"  type="text" value='<s:property value="rechargeChannel.mch_id"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">应用id：</label>
								          <div class="col-sm-8">
								              <input id="app_id" name="rechargeChannel.app_id"  type="text" value='<s:property value="rechargeChannel.app_id"/>' class="form-control" required="" aria-required="true">
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