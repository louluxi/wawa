<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>会员订单处理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
    $('.date_picker').date_input();
  })
</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li>
							<a href="userOrder/toLoadList.action">会员订单查看</a>
						</li>
					</ul>
					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="userOrder/saveOrUpdate.action" method="post">
									  <input type="hidden" name="userOrder.id" id="id" value='<s:property value="userOrder.id"/>'/>				     
								      <div class="form-group">
								          <label class="col-sm-3 control-label">发货单号：</label>
								          <div class="col-sm-8">
								              <input id="express_no"  name="userOrder.express_no" minlength="2"  value='<s:property value="userOrder.express_no"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">快递公司：</label>
								          <div class="col-sm-8">
								              <input id="express_company" name="userOrder.express_company"  type="text" value='<s:property value="userOrder.express_company"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
                                           <label class="col-sm-3 control-label">发货时间：</label>
                                           <div style="left:40px">
                                              <div class="col-sm">
                                                <input  name="send_time"  value='<s:property value="userOrder.send_time"/>' style="width:200px; line-height:15px;  display:inline-block" type="text" class="form-control date_picker" id="send_time"  required=""/>
                                              </div>
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