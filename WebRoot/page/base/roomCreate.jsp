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
							<a href="room/toLoadList.action">房间管理</a>
						</li>
						<li class="active">
							<a href="room/getInfoById.action?opt=1">${title}</a>
						</li>
					</ul>
					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="room/saveOrUpdate.action" method="post" enctype="multipart/form-data">
									  <input type="hidden" name="room.id" id="id" value='<s:property value="room.id"/>'/>				     
                                       <div class="form-group">
                                          <label class="col-sm-3 control-label">房间类别：</label>
                                          <div class="col-sm-8">
                                              <select class="form-control selectpicker" data-live-search="true" multiple name="room.classIds" id="id_select">
                                                 <s:iterator value="roomClassList" var="roomClass">
                                                        <option value='<s:property value="#roomClass.id"/>'><s:property value="#roomClass.class_name"/></option>
                                                 </s:iterator>
                                              </select>
                                          </div>
                                      </div>
                                      <input id="aaa"  value='<s:property value="room.classIds"/>' type="hidden" class="form-control"  aria-required="true">
								      <div class="form-group">
								          <label class="col-sm-3 control-label">设备编号：</label>
								          <div class="col-sm-8">
								              <input id="deviceCode"   name="device.device_code"  value='<s:property value="room.deviceCode"/>' class="form-control"  aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">前摄像头编号：</label>
								          <div class="col-sm-8">
								              <input id="frontCode" name="frontCameraDevice.device_code"  type="text" value='<s:property value="room.frontCode"/>' class="form-control" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">后摄像头编号：</label>
								          <div class="col-sm-8">
								              <input id="sideCode" name="sideCameraDevice.device_code""  type="text" value='<s:property value="room.sideCode"/>' class="form-control"  aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">房间名称：</label>
								          <div class="col-sm-8">
								              <input id="room_name" name="room.room_name"  type="text" value='<s:property value="room.room_name"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								       <div class="form-group">
                                          <label class="col-sm-3 control-label">房间编号：</label>
                                          <div class="col-sm-8">
                                              <input id="room_code" name="room.room_code"  type="text" value='<s:property value="room.room_code"/>' class="form-control" required="" aria-required="true">
                                          </div>
                                      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">房间最大人数：</label>
								          <div class="col-sm-8">
								              <input id="max_user_num" name="room.max_user_num"  type="text" value='<s:property value="room.max_user_num"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">单次游戏娃娃币：</label>
								          <div class="col-sm-8">
								              <input id="coin_once" name="room.coin_once"  type="text" value='<s:property value="room.coin_once"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
                                          <label class="col-sm-3 control-label">是否允许包房：</label>
                                          <div class="col-sm-8">
                                                <select class="form-control m-b" name="room.is_private">
                                                    <s:iterator value="roomPrivateList" var="dict">
                                                        <option value='<s:property value="#dict.dictId"/>' <s:if test="room.is_private == #dict.dictId">selected='selected'</s:if>><s:property value="#dict.dictName"/></option>
                                                    </s:iterator>
                                                </select>
                                          </div>
                                      </div>
								      <div class="form-group">
                                          <label class="col-sm-3 control-label">是否置顶：</label>
                                          <div class="col-sm-8">
                                                <select class="form-control m-b" name="room.istop">
                                                    <s:iterator value="isTopList" var="dict">
                                                        <option value='<s:property value="#dict.dictId"/>' <s:if test="room.istop== #dict.dictId">selected='selected'</s:if>><s:property value="#dict.dictName"/></option>
                                                    </s:iterator>
                                                </select>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-3 control-label">房间商品选择：</label>
                                          <div class="col-sm-8">
                                                <select class="form-control m-b" name="roomMerch.merch_id">
                                                    <s:iterator value="merchList" var="merch">
                                                        <option value='<s:property value="#merch.id"/>' <s:if test="room.merchId== #merch.id">selected='selected'</s:if>><s:property value="#merch.merch_name"/></option>
                                                    </s:iterator>
                                                </select>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-3 control-label">商品数量：</label>
                                          <div class="col-sm-8">
                                               <input id="merch_num" name="roomMerch.merch_num"  type="text" value='<s:property value="room.merchNum"/>' class="form-control" required="" aria-required="true">
                                          </div>
                                      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">序号：</label>
								          <div class="col-sm-8">
								               <input id="sort" name="room.sort"  type="text" value='<s:property value="room.sort"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">房间说明：</label>
								          <div class="col-sm-8">
								               <input id="room_desc" name="room.room_desc"  type="text" value='<s:property value="room.room_desc"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								       <div class="form-group">
                                            <label class="col-sm-3 control-label">房间图标文件选择：</label>
                                          <div class="col-sm-8">
                                              <input type="file" name="roomIconfile"  class="form-control"/>
                                          </div>
                                       </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">房间背景音乐文件选择：</label>
                                          <div class="col-sm-8">
                                              <input type="file" name="backgroundMusicfile"  class="form-control"/>
                                          </div>
                                       </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">房间背景图片文件选择：</label>
                                          <div class="col-sm-8">
                                              <input type="file" name="backgroundfile"  class="form-control"/>
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

<script type="text/javascript">   
 $(document).ready( function() {  
  $('.selectpicker').selectpicker({
	 'selectedText': 'cat'
   });  
   var str= $("#aaa").val();
   var arr=str.split(',');
   $('#id_select').selectpicker('val', arr);
   $('.selectpicker').selectpicker('refresh');    
 });
  </script>
 
</html>