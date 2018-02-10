$(function(){
	initDatagrid();
});
function initDatagrid(){ 
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("#tt")
			.jqGrid(
					{
						url : 'communicate/getMessageList.action?getType=receive',
						datatype : "json",
						height : 450,
						autowidth : true,
						multiselect : false,// 复选框
						shrinkToFit : true,
						rowNum : 20,
						rowList : [ 10, 20, 30 ],
						colNames : [ '序号', '发送人', '日期', '主题', '操作' ],
						colModel : [ {
							name : 'id',
							index : 'id',
							editable : true,
							hidden : true,
							key : true,
							width : 80
						}, {
							name : 'sendUser',
							index : 'sendUser',
							editable : true,
							width : 100
						}, {
							name : 'sendTime',
							index : 'sendTime',
							editable : true,
							width : 100
						}, {
							name : 'title',
							index : 'title',
							editable : true,
							width : 120
						}, {
							name : 'opt',
							index : 'opt',
							editable : true,
							width : 100
						} ],
						pager : "#pl",
						viewrecords : true,
						caption : null,
						hidegrid : true,
						gridComplete : function() {
							var ids = $("#tt").jqGrid('getDataIDs');
							for ( var i = 0; i < ids.length; i++) {
								var cl = ids[i];
								var update = "<input class='btn btn-outline btn-success' type='button' value='编辑' onclick='updateData("+ cl + ")'/>&nbsp;";
								var delet = "<input class='btn btn-outline btn-warning' type='button' value='删除' onclick='deleteData(" + cl + ")'/>";
								$("#tt").jqGrid('setRowData',ids[i],
								{
									toList:html,
									opt : update + delet
								});
							}
						}
					});
	$("#tt").jqGrid('navGrid', '#pl', {}, {
		height : 200,
		reloadAfterSubmit : true
	});
	// Add responsive to jqGrid
	$(window).bind('resize', function() {
		var width = $('.jqGrid_wrapper').width();
		$('#tt').setGridWidth(width);
	});
}
function loadFilter(data){  
    var value = {  
            total:data.data.total,  
            rows:[]  
    };  
    for (var i = 0; i < data.data.rows.length; i++) {  
        value.rows.push(data.data.rows[i]);  
    }  
    return value;  
}


function relayMessage(){
	var rows = $('#tt').datagrid('getSelections');
	if (rows.length != 1) {
		tAlert('信息', '请选择一条数据');
	} else{

		$('#isEdit').attr("value","false");
		$('#isRelay').attr("value","true");
		$('#isDraft').attr("value","false");
		$('#RelayId').attr("value",rows[0].id);
		$('#createJump').submit();
	}
	
}

function checkMessageDetail1(id,isread){
	req = {
			msgId:id
		}
	var closeState = 0;
	var title = "";
	var content = "";
	var sendDate = "";
	var sendUser = "";
	//alert(isread);
	var recvId = "";
	checkMessageDetail(req).done(function(resp){
		
		title = resp.title;
		content = resp.content;
		sendDate = resp.sendTime;
		sendUser = "<label>"+resp.sendUser+"</label>";
		recvId = resp.recvId;
		$('#dlg').show().dialog({ 
			
			title : "申请详情",
			modal : true,
			shadow : false,
			closed : false, 
			width : 600,
			height : 400,
			maximizable : true,
			left:200,
			top:50,
			
			onOpen:function(){   
				$('#sendUser').empty();
				$('#title').text(title);
				$('#content').html(content);
				$('#sendDate').html(sendDate);
				$('#sendUser').append(sendUser);
				
			},
			onClose : function() {
				// close方法触发的onClose事件,去调用close方法
				if(closeState == 0){
					if(isread == "unread"){
						ttreload(recvId);
					}
					closeState = 1;
					$('#dlg').dialog('close');
				}
			},
		
			buttons : [ {
				text : '确定',
				iconCls : 'icon-ok',
				handler : function() {
					if(closeState == 0){
						if(isread == "unread"){
							ttreload(recvId);
						}
						closeState = 1;
						$('#dlg').dialog('close');
					}
				}
			}, {
				text : '关闭',
				iconCls : 'icon-no',
				handler : function() {
					if(closeState == 0){
						if(isread == "unread"){
							ttreload(recvId);
						}
						closeState = 1;
						$('#dlg').dialog('close');
					}
				}
			}]
		 	
		 });
	});
	
}

function ttreload(recvId){
	
	//alert("执行了ttreload！");
	$.ajax({
		url:"communicate/readed.action",
		data:{recvId:recvId},
		async:true,
		cache:false,
		type:"POST",
		dataType:"json",
		success:function(result){}
	});
	$('#tt').datagrid('reload'); 
}

function checkNewMessage(){
	$('#tt').datagrid({
//		url:'../getApplyInfo.action?status='+status+'&type='+type+'&isAudit='+false,
		url:'communicate/getMessageList.action?getType=unread',
		pagination:true,
		autoRowHeight:false,
		rownumbers:true,
		onClickRow: function (rowIndex, rowData) {
            $(this).datagrid('unselectRow', rowIndex);
		},
		rowStyler:function(index,row){
	        if (row.recvStatus == "unread"){    
	            return 'background-color:;color:;font-weight:bold;';    
	        }    
	    },
		columns:[[
		          	{title:'',field:'id',checkbox:true,width:100},
		          	{title:'发送人',halign: 'center',field:'sendUser',width:150,formatter: function(value,rec){
		          			return '<span title='+value+'>'+value+'</span>';     	    	   
		          	}},
		          	
		            //{title:'标题',halign: 'center',field:'type',width:200},
			        {title:'主题',halign: 'center',field:'title',width:300,formatter: function(value,rec){		          		
		          		return '<span title='+value+'>'+value+'</span>';
		          	}},
			        {title:'日期',halign: 'center',field:'sendTime',width:250,formatter: function(value,rec){
		          		return '<span title='+value+'>'+value+'</span>';  
		          	}},
	          	    {field:'opt',title:'操作',width:200,align:'center', 
						formatter:function(value,rec){
							var html='';
							html+= "<span style='display: inline-block;margin-left:10px'><img src='"+$('#baseUrl').attr("value")+"/themes/icons/view.gif'\ title='查看详情' style='cursor:pointer' onclick='checkMessageDetail1(" + rec.id + ")' ></span>";
						    return html;
						},
					}
				]],
				toolbar:"#tb",
				loadFilter:function(data){  
			         return loadFilter(data);    //自定义过滤方法         
			    }  
	});
}



