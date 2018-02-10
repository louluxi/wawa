<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>套餐管理</title>
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
						<li><a href="meal/toLoadList.action">套餐管理</a></li>
						<li class="active"><a href="meal/getInfoById.action?opt=1">${title}</a></li>
					</ul>

					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="meal/saveOrUpdate.action" method="post">
									  <input type="hidden" name="meal.id" id="id" value='<s:property value="meal.id"/>'/>
								     <div class="form-group">
								          <label class="col-sm-3 control-label">套餐名称：</label>
								          <div class="col-sm-8">
								              <input id="name" name="meal.name"  type="text" value='<s:property value="meal.name"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">套餐价格(元)：</label>
								          <div class="col-sm-8">
								              <input id="price"  name="meal.price" type="text" value='<s:property value="meal.price"/>' class="form-control" required="" aria-required="true">
								          	  <span class="help-block m-b-none" id="alt"></span>
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">娃娃币(个)：</label>
								          <div class="col-sm-8">
								              <input id="doll_coin"   name="meal.doll_coin"  type="number"  value='<s:property value="meal.doll_coin"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
                                          <label class="col-sm-3 control-label">奖励娃娃币(个)：</label>
                                          <div class="col-sm-8">
                                              <input id="reward_coin"   name="meal.reward_coin"  type="number"  value='<s:property value="meal.reward_coin"/>' class="form-control" required="" aria-required="true">
                                          </div>
                                      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">套餐描述：</label>
								          <div class="col-sm-8">
								              <input id="remark" name="meal.remark"  type="text" value='<s:property value="meal.remark"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
                                          <label class="col-sm-3 control-label">套餐状态：</label>
                                          <div class="col-sm-8">
                                                <select class="form-control m-b" name="meal.status">
                                                    <s:iterator value="mealStrutsList" var="dict">
                                                        <option value='<s:property value="#dict.dictId"/>' <s:if test="meal.status == #dict.dictId">selected='selected'</s:if>><s:property value="#dict.dictName"/></option>
                                                    </s:iterator>
                                                </select>
                                          </div>
                                      </div>
								     <div class="form-group">
                                           <label class="col-sm-3 control-label">有效期起：</label>
                                           <div style="left:40px">
                                              <div class="col-sm">
                                                <input  name="meal.validity_start"  value='<s:property value="meal.validity_start"/>' style="width:200px; line-height:15px;  display:inline-block" type="text" class="form-control date_picker" id="validity_start"  required=""/>
                                              </div>
                                           </div>
                                      </div>
								      <div class="form-group">
                                           <label class="col-sm-3 control-label">有效期至：</label>
                                           <div style="left:20px">
                                           <div class="col-sm">
                                           <input  name="meal.validity_end"  value='<s:property value="meal.validity_end"/>' style="width:200px; line-height:15px;  display:inline-block" type="text" class="form-control date_picker" id="validity_end"  required=""/>
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