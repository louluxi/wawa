<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>设备管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<div class="ibox-content">
					 <ul class="nav nav-tabs">
                        <li class="active"><a href="room/toLoadList.action">房间列表</a></li>
                        <li><a href="room/getInfoById.action?opt=1">房间新增</a></li>
                    </ul>
                     <!--查询-->
                     <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="room_code" class="sr-only">房间编号</label>
                                <input type="text" placeholder="房间编号" id="room_code" class="form-control">
                                <label for="room_name" class="sr-only">房间名称</label>
                                <input type="text" placeholder="房间名称" id="room_name" class="form-control">                         
                            </div>
                            <select class="form-control"  placeholder="包房状态"  id="is_private">
                                    <option value=''>包房状态</option>
                                    <s:iterator value="roomPrivateList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                            </select>
                            <select class="form-control"  placeholder="房间上架状态"  id="is_putaway">
                                    <option value=''>房间上架状态</option>
                                    <s:iterator value="roomPutawayList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                            </select>
                            <select class="form-control"  placeholder="是否置顶"  id="istop">
                                    <option value=''>是否置顶</option>
                                    <s:iterator value="isTopList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                            </select>
                            <select class="form-control"  placeholder="房间状态"  id="status">
                                    <option value=''>房间状态</option>
                                    <s:iterator value="roomStatusList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                            </select>
                           <%--  <select class="form-control"  placeholder="房间类别"  id="classID">
                                    <option value=''>房间类别</option>
                                    <s:iterator value="roomClassList" var="roomClass">
                                            <option value='<s:property value="#roomClass.id"/>'><s:property value="#roomClass.class_name"/></option>
                                    </s:iterator>
                            </select> --%>
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询
                            </button>
                        </form>
                    </div>
                    <a class="btn btn-primary" href="room/toLoadList.action">刷新</a>
                    <!-- 主体表格 -->
						<div class="jqGrid_wrapper">
							<table id="tt"></table>
							<div id="pl"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Page-Level Scripts -->
	<script>
		$(document)
				.ready(
						function() {
							$.jgrid.defaults.styleUI = 'Bootstrap';
							$("#tt")
									.jqGrid(
											{
												url : 'room/getAjaxData.action',
												datatype : "json",
												height : "auto",
												autowidth : true,
												multiselect : false,//复选框    
												shrinkToFit:false,  
												autoScroll: true, 
												rowNum : 20,
												rownumbers: true,
												editable : true,
												rowList : [ 10, 20, 30 ],
												colNames : ['ID',
	                                                        '房间类别名称', '设备编号', '前摄像头编号','后摄像头编号',
	                                                        '房间编号', '房间名称', '娃娃币', '允许包房', '上架状态', '房间状态', '是否置顶','序号',
	                                                        '商品名称', '房间剩余商品数量','房间抓取寄存商品数量', '热度','创建时间','当前在线人数','前摄像头播放地址','后摄像头播放地址','娃娃机IP',
	                                                        '娃娃机端口号','房间图标','背景音乐','房间背景图片','操作'],
	                                                colModel : [ {
	                                                    name : 'id',
	                                                    index : 'id',
	                                                    editable : true,
	                                                    hidden : true,
	                                                    key : true,
	                                                    width : 80
	                                                },{
	                                                    name : 'className',
	                                                    index : 'className',
	                                                    editable : true,
	                                                    width : 80
	                                                }, {
	                                                    name : 'deviceCode',
	                                                    index : 'deviceCode',
	                                                    editable : true,
	                                                    width : 80
	                                                },{
	                                                    name : 'frontCode',
	                                                    index : 'frontCode',
	                                                    editable : true,
	                                                    width : 120
	                                                }, {
	                                                    name : 'sideCode',
	                                                    index : 'sideCode',
	                                                    editable : true,
	                                                    width : 120
	                                                },{
	                                                    name : 'room_code',
	                                                    index : 'room_code',
	                                                    editable : true,
	                                                    width : 80
	                                                }, {
	                                                    name : 'room_name',
	                                                    index : 'room_name',
	                                                    editable : true,
	                                                    width : 80
	                                                }, {
	                                                    name : 'coin_once',
	                                                    index : 'coin_once',
	                                                    editable : true,
	                                                    width : 60
	                                                }, {
	                                                    name : 'privateShow',
	                                                    index : 'privateShow',
	                                                    editable : true,
	                                                    width : 90
	                                                }, {
	                                                    name : 'is_putaway',
	                                                    index : 'is_putaway',
	                                                    editable : true,
	                                                    width : 70,
	                                                    formatter:function(cellvalue, options, rowObject){
	                                                    	return "<select onchange='checkField(this.value,"+options.rowId+")'><option value='0' " +(cellvalue==0?"selected='selected'":"") + ">待定</option><option value='1' "+(cellvalue==1?"selected='selected'":"") + ">上架</option><option value='2' "+(cellvalue==2?"selected='selected'":"") + ">下架</option></select>";
	                                                    	
	                                                    }
	                                                }, {
	                                                    name : 'strtusShow',
	                                                    index : 'strtusShow',
	                                                    editable : true,
	                                                    width : 70
	                                                },{
	                                                    name : 'istopShow',
	                                                    index : 'istopShow',
	                                                    editable : true,
	                                                    width : 90
	                                                },  {
	                                                    name : 'sort',
	                                                    index : 'sort',
	                                                    editable : true,
	                                                    width : 90
	                                                }, {
	                                                    name : 'merchName',
	                                                    index : 'merchName',
	                                                    editable : true,
	                                                    width : 70
	                                                }, {
	                                                    name : 'merchNumShow',
	                                                    index : 'merchNumShow',
	                                                    editable : true,
	                                                    width : 90
	                                                }, {
                                                        name : 'checkMerchNum',
                                                        index : 'checkMerchNum',
                                                        editable : true,
                                                        width : 90
                                                    },{
	                                                    name : 'hot',
	                                                    index : 'hot',
	                                                    editable : true,
	                                                    width : 150,
	                                                }, {
	                                                    name : 'create_time',
	                                                    index : 'create_time',
	                                                    editable : true,
	                                                    width : 90,
	                                                    formatter : "datetime"
	                                                }, {
	                                                    name : 'userNum',
	                                                    index : 'userNum',
	                                                    editable : true,
	                                                    width : 90,
	                                                }, {
                                                        name : 'frontCamera',
                                                        index : 'frontCamera',
                                                        editable : true,
                                                        width : 90,
                                                    },{
                                                        name : 'sideCamera',
                                                        index : 'sideCamera',
                                                        editable : true,
                                                        width : 90,
                                                    }, {
                                                        name : 'deviceIp',
                                                        index : 'deviceIp',
                                                        editable : true,
                                                        width : 90,
                                                    }, {
                                                        name : 'devicePort',
                                                        index : 'devicePort',
                                                        editable : true,
                                                        width : 90,
                                                    }, {
                                                        name : 'room_icon',
                                                        index : 'room_icon',
                                                        editable : true,
                                                        width : 90,
                                                    }, {
                                                        name : 'background_music',
                                                        index : 'background_music',
                                                        editable : true,
                                                        width : 90,
                                                    }, {
                                                        name : 'background_img',
                                                        index : 'background_img',
                                                        editable : true,
                                                        width : 90,
                                                    }, {
	                                                    name : 'opt',
	                                                    index : 'opt',
	                                                    editable : true,
	                                                    width : 150, 
	                                                } ],
												pager: "#pl",
								                viewrecords: true,
								                caption: "",
								                hidegrid: false,
												gridComplete : function() {
													var ids = $("#tt").jqGrid(
															'getDataIDs');
													for (var i = 0; i < ids.length; i++) {
														var cl = ids[i];
														var update = "<input class='btn btn-outline btn-success' type='button' value='编辑' onclick='updateData("
																+ cl
																+ ")'/>&nbsp;";
														var delet = "<input class='btn btn-outline btn-warning' type='button' value='删除' onclick='deleteData("
																+ cl + ")'/>";
														$("#tt")
																.jqGrid(
																		'setRowData',
																		ids[i],
																		{
																			opt : update
																					+ delet
																		});
													}
													
												}
											});
							// rownumbers添加序号列列头
							jQuery("#tt").jqGrid('setLabel', 'rn', '序号', {'text-align':'center','padding':'0'});
							// Add responsive to jqGrid
							$(window).bind('resize', function() {
								var width = $('.jqGrid_wrapper').width();
								$('#tt').setGridWidth(width);
							}); 
						});

		function searchInfo() {
			var room_code = $('#room_code').val();
			var room_name = $('#room_name').val();
			var is_private = $('#is_private').val();
            var is_putaway = $('#is_putaway').val();
            var istop = $('#istop').val();
			var status = $('#status').val();
            var classID = $('#classID').val();
			$("#tt").jqGrid('setGridParam', {
				url : "room/getAjaxData.action",
				postData : {
					'room_code' : room_code,
					'room_name' : room_name,
					'is_private' : is_private,
                    'is_putaway' : is_putaway,
                    'istop' : istop,
					'status' : status,
					'classID' : classID
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

		}
       //更新
		function updateData(catId) {
			window.location.href = 'room/getInfoById.action?opt=2&id=' + catId;
			searchInfo();
		}
       
      function checkField (val,rowid) {
    	   $.ajax({
              type : "POST",
              url : "version/updatePutaway.action",
              data : {
            	  is_putaway : val,
                  id : rowid
              },
              dataType : "text",
              success : function(result) {
                  var result = eval('(' + result + ')');
                  if (result.result) {
                      swal("更新成功！", "您已经更新了此房间的状态。", "success");
                  } else {
                      swal("更新失败！", "请联系系统管理员。", "error");
                  }
                  searchInfo();
              }
          }); 
      }
      //
      function deleteData(catId) {
          swal({
              title : "您确定要删除这条信息吗",
              text : "删除后将无法恢复，请谨慎操作！",
              type : "warning",
              showCancelButton : true,
              confirmButtonColor : "#DD6B55",
              confirmButtonText : "删除",
              cancelButtonText : "取消",
              closeOnConfirm : false
          }, function() {
              $.ajax({
                  type : "POST",
                  url : "room/delete.action",
                  data : {
                      ids : catId
                  },
                  dataType : "text",
                  success : function(result) {
                      var result = eval('(' + result + ')');
                      if (result.result) {
                          swal("删除成功！", "您已经删除了这条信息。", "success");
                      } else {
                          swal("不能删除上架或下架的房间！", "请联系系统管理员。", "error");
                      }
                      searchInfo();
                  }
              });
          });
      }
	</script>
</body>
</html>