$(function(){
	initDatagrid();
});
function initDatagrid(){ 
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("#tt")
			.jqGrid(
					{
						url : 'communicate/getMessageList.action?getType=draft',
						datatype : "json",
						height : "auto",
						autowidth : true,
						multiselect : false,// 复选框
						shrinkToFit : true,
						rowNum : 20,
						rowList : [ 10, 20, 30 ],
						colNames : [ '序号', '名称', '昵称', '说明', '操作' ],
						colModel : [ {
							name : 'id',
							index : 'id',
							editable : true,
							hidden : true,
							key : true,
							width : 80
						}, {
							name : 'name',
							index : 'name',
							editable : true,
							width : 100
						}, {
							name : 'remark',
							index : 'remark',
							editable : true,
							width : 100
						}, {
							name : 'desc',
							index : 'desc',
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
								var rowData = $("#tt").jqGrid('getRowData', cl);
								var html = "";
		          				if(rowData.toType == "group"){
		          					if(i>0){
		          						html+="<span style=\"margin-left:5px;\">"+"<font size=2 color=blue>组：</font>"+rowData.name+"</span>";
		          					}else{
		          						html+="<span>"+"<font size=2 color=blue>组:</font>"+rowData.name+"</span>";
		          					}
		          				}else{
		          					if(i>0){
			          					html+="<span style=\"margin-left:5px;\">"+rowData.name+"</span>";
			          				}else{
			          					html+="<span>"+rowData.name+"</span>";
			          				}
		          				}
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




function checkGroupDetail1(id){
	req = {
			groupid:id,
		}
	checkGroupDetail(req).done(function(resp){
	$('#dlg').show().dialog({ 
		title : "群组详情",
		modal : true,
		shadow : false,
		closed : false, 
		width : 600,
		height : 420,
		maximizable : true,
		left:200,
		top:50,
		
		onOpen:function(){ 
			$('#groupMemberArea').empty();
			$('#groupName').val(resp.name)
			$("#onickName").val(resp.remark);
			$('#createTime').val(resp.createTime);
			$('#remarkdetail').val(resp.desc);
			for(var i = 1;i<=resp.userList.length;i++){
				if((i%5) == 1)
				{
					if(i>1)
					{
						$('#groupMemberArea').append('</br>');
					}
					$('#groupMemberArea').append('<label id="'+resp.userList[i-1].code+'" name="confirmMember" style="padding-left:5px;padding-right:5px;background-color:#e8f0f7;border-radius:5px;border:2px solid grey;font-weight:normal;font-size:13px">'+resp.userList[i-1].name+'<a href="javascript:;" onclick="memberRemove('+resp.userList[i-1].code+')" class="mf_remove" title="Remove">X</a></label>');
					
				}else{
					$('#groupMemberArea').append('<label id="'+resp.userList[i-1].code+'" name="confirmMember" style="margin-left:7px;padding-left:5px;padding-right:5px;background-color:#e8f0f7;border-radius:5px;border:2px solid grey;font-weight:normal;font-size:13px">'+resp.userList[i-1].name+'<a href="javascript:;" onclick="memberRemove('+resp.userList[i-1].code+')" class="mf_remove" title="Remove">X</a></label>');
				}
			}
		},
		onClose : function() {
			// close方法触发的onClose事件,去调用destory方法
			$('#dlg').dialog('close');
		},
	
		buttons : [ {
			text : '确定',
			iconCls : 'icon-ok',
			handler : function() {
				$('#dlg').dialog('close');
			}}, 
	 		{
			text : '关闭',
			iconCls : 'icon-no',
			handler : function() {
				$('#dlg').dialog('close');}
			} 
		]
	 	
	 });
	});
}


function addGroup(){
	
	
	$('#dlgadd').show().dialog({ 
		title : "群组信息",
		modal : true,
		shadow : false,
		closed : false, 
		width : 600,
		height : 500,
		maximizable : true,
		left:200,
		top:50,
		
		onOpen:function(){   
			$('#selectCArea').empty();
		    $('#groupMember').empty();
		    gsearched = new Map();
			gconfirmed = new Map();
			glastQueryName = "";
			trid = 0;
			tdlength = 0;
			$("#groupNameadd").removeAttr("readonly");
			$('#groupNameadd').val("");
			$('#nickName').val("");
			$("#groupNameadd").attr("placeholder","一旦保存无法修改");
			$('#searchName').val("");
			$('#groupMember').empty();
			$('#groupMember').append('<table id="confirmMemberTable" style="width:410px;table-layout:fixed"></table>');
			$('#searchName').keypress(function(e){
		        var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
		        if (eCode == 13){
		        	searchContact();
		        }
			});
			//输入实时触发 ager加
			$('#searchName').bind('input propertychange', function() {
					searchContact();
			}); 
		},
		onClose : function() {
			// close方法触发的onClose事件,去调用destory方法
			$('#dlgadd').dialog('close');
		},
	
		buttons : [ {
			text : '确定',
			iconCls : 'icon-ok',
			handler : function() {
				saveOrUpdate("add");
				$('#dlgadd').dialog('close');
			}}, 
	 		{
			text : '关闭',
			iconCls : 'icon-no',
			handler : function() {
				$('#dlgadd').dialog('close');}} 
		]
	 	
	 });
}


function editGroup(){
	trid = 0;
	tdlength = 0;
	
	var rows = $('#tt').datagrid('getSelections');
	if (rows.length != 1) {
		tAlert('信息', '请选择一条数据');
	} else{
		$('#selectCArea').empty();
	    $('#groupMember').empty();
	    gsearched = new Map();
		gconfirmed = new Map();
		req = {
				groupid:rows[0].id,
			}
		
		checkGroupDetail(req).done(function(resp){
//			//alert(resp.name);
			
			
			$('#dlgadd').show().dialog({ 
				title : "修改群组信息",
				modal : true,
				shadow : false,
				closed : false, 
				width : 600,
				height : 500,
				maximizable : true,
				left:200,
				top:50,
				
				onOpen:function(){   
					$('#groupMember').empty();
					$('#groupMember').append('<table id="confirmMemberTable" style="width:410px;table-layout:fixed"></table>');
					$("#groupNameadd").removeAttr("placeholder");
					$('#groupNameadd').attr("value",resp.name);
					$("#groupNameadd").attr("readonly","readonly");
					$('#searchName').val("");
					$('#remark').val(resp.desc);
					$('#nickName').val(resp.remark);
					
					$('#searchName').keypress(function(e){
				        var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
				        if (eCode == 13){
				        	searchContact();
				        }
					});
					
					//$('#confirmMemberTable').append('<tr id="confirmMemberTr'+trid+'"></tr>');
					for(var i = 1;i<=resp.userList.length;i++){
						//alert("进来了！tdlength:"+tdlength);
						
						if((tdlength%3) == 0)
						{
							//alert()
							//alert(trid);
							//alert("第一行创建新行！并添加到gsearched");
							
							trid++;
							$('#confirmMemberTable').append('<tr id="confirmMemberTr'+trid+'"></tr>');
							$('#confirmMemberTr'+trid).append('<td><label id="'+"cm"+gsearched.size()+'" name="confirmMember" value="'+resp.userList[(i-1)].code+'" style="padding-left:5px;padding-right:5px;background-color:#e8f0f7;border-radius:5px;border:2px solid grey;font-weight:normal;font-size:13px">'+resp.userList[(i-1)].name+'('+resp.userList[(i-1)].code+')'+'<a href="javascript:;" onclick="memberRemove('+gsearched.size()+')" class="mf_remove" title="Remove">X</a></label></td>');
							gsearched.put(resp.userList[(i-1)].id,gsearched.size());
							tdlength++;
						}else{
							//alert("还是这一行！添加新人！");
							$('#confirmMemberTr'+trid).append('<td><label id="'+"cm"+gsearched.size()+'" name="confirmMember" value="'+resp.userList[(i-1)].code+'" style="padding-left:5px;padding-right:5px;background-color:#e8f0f7;border-radius:5px;border:2px solid grey;font-weight:normal;font-size:13px">'+resp.userList[(i-1)].name+'('+resp.userList[(i-1)].code+')'+'<a href="javascript:;" onclick="memberRemove('+gsearched.size()+')" class="mf_remove" title="Remove">X</a></label></td>');
							gsearched.put(resp.userList[(i-1)].id,gsearched.size());
							tdlength++;
						}
					}
					
				},
				onClose : function() {
					// close方法触发的onClose事件,去调用destory方法
					$('#dlgadd').dialog('close');
				},
			
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						saveOrUpdate("edit",rows[0].id);
						$('#dlgadd').dialog('close');
					}}, 
			 		{
					text : '关闭',
					iconCls : 'icon-no',
					handler : function() {
						$('#dlgadd').dialog('close');}} 
				]
			 	
			 });
		});
		
	    
	}
}

function saveOrUpdate(operationType,id) {
	var name = $('#groupNameadd').val();
	var nickname = $('#nickName').val();
	var idstr = "";
	var remark = $("#remark").val();
	$('label[name="confirmMember"]').each(function(){
		idstr += $(this).attr("value")+",";
	});
	var ids = idstr.substring(0, idstr.length-1);
	req={
			name:name,
			remark:nickname,
			userListStr:ids,
			desc:remark,
	}
	if(operationType == "add"){	
		$.ajax({
			url:"communicate/editGroup.action",
			data:req,
			async:true,
			cache:false,
			type:"POST",
			dataType:"text",
			success:function(result)
			{
				var resultstr = result.indexOf("\"result\":0");
				if(result.indexOf("\"result\":0")>0){
					$.messager.alert("信息","群组创建成功！");
					$('#tt').datagrid('reload'); 
					return;
				}else{
					$.messager.alert("信息","群组创建失败！"+result.data);
					return;
				}

			},
			
		});
	}
	if(operationType == "edit"){
		
		req.id = id;
		$.ajax({
			url:"communicate/editGroup.action",
			data:req,
			async:true,
			cache:false,
			type:"POST",
			dataType:"text",
			success:function(result)
			{
				var resultstr = result.indexOf("\"result\":0");
				if(result.indexOf("\"result\":0")>0){
					$.messager.alert("信息","群组修改成功！");
					$('#tt').datagrid('reload'); 
					return;
				}else{
					$.messager.alert("信息","群组修改失败！"+result.data);
					return;
				}

			},
			
		});
	}
}

function searchContact(){
	//alert($('#searchName').val());
	if(glastQueryName == $('#searchName').val())
	{
		return;
	}
	$('#selectCArea').empty();
	req = {
			name:$('#searchName').val(),
	};
	
	glastQueryName = $('#searchName').val();
	queryContctsByName(req).done(function(resp){
		$('#selectCAreaTable').remove();
		$('#selectCArea').append('<table id="selectCAreaTable" style="table-layout:fixed"></table>');
		
		var n = 0;
		for(var i = 1; i<= resp.length;i++)
    	{
			if((i%3) == 1){
				n++;
				$('#selectCAreaTable').append('<tr id="selectCAreatr'+n+'"></tr>');
			}
			if(gsearched.get(resp[(i-1)].code) == null){
				//alert("没找到");
				$('#selectCAreatr'+n).append('<td><label id="sc'+gsearched.size()+'" style="font-weight:normal;font-size:15px" value="'+resp[(i-1)].code+'">'+resp[(i-1)].name+'('+resp[(i-1)].code+')'+'<input id="scc'+gsearched.size()+'" name="selectedContacts" onclick="selectContacts('+gsearched.size()+')" style="float:left" type="checkbox"/></label></td>');
				gsearched.put(resp[(i-1)].code,gsearched.size());
				
			}else{
				//alert("找到了");
				$('#selectCAreatr'+n).append('<td><label id="sc'+gsearched.get(resp[(i-1)].code)+'" style="font-weight:normal;font-size:15px" value="'+resp[(i-1)].code+'">'+resp[(i-1)].name+'('+resp[(i-1)].code+')'+'<input id="scc'+gsearched.get(resp[(i-1)].code)+'" name="selectedContacts" onclick="selectContacts('+gsearched.get(resp[(i-1)].code)+')" style="float:left" type="checkbox"/></label></td>');
				gsearched.put(resp[(i-1)].code,gsearched.get(resp[(i-1)].code));
				if($('#cm'+gsearched.get(resp[(i-1)].code)).length > 0)
				{
					$('#scc'+gsearched.get(resp[(i-1)].code)).attr("checked","checked");
				}
			}
			
    	}
	});
}

function selectContacts(id){
	var isEmpty = true;
	$("#confirmMemberTable").find("tr").each(function(){
	    var tdArr = $(this).children(); 
	    for(var i = 0;i<tdArr.length;i++){
	    	if(tdArr.eq(i).text() != "")
	    	{
	    		isEmpty = false;
	    	}
	    }  
	 });
	if(isEmpty){
		tdlength = 0;
		trid = 0;
		$('#groupMember').empty();
		$('#groupMember').append('<table id="confirmMemberTable" style="width:410px;table-layout:fixed"></table>');
	}
	//alert(id);
	//alert($('#sc'+id).attr("value"));
	if($('#cm'+id).length>0)
	{
		//remove这个人
		//alert("删除！");
		$('#cm'+id).remove();
	}else{
		//alert("tdlength%3:"+tdlength%3);
		if((tdlength%3) == 0)
		{
			//alert()
			//alert(trid);
			trid++;
			$('#confirmMemberTable').append('<tr id="confirmMemberTr'+trid+'"></tr>');
			
			$('#confirmMemberTr'+trid).append('<td><label id="'+"cm"+id+'" name="confirmMember" value="'+$('#sc'+id).attr("value")+'" style="padding-left:5px;padding-right:5px;background-color:#e8f0f7;border-radius:5px;border:2px solid grey;font-weight:normal;font-size:13px">'+$('#sc'+id).text()+'<a href="javascript:;" onclick="memberRemove('+id+')" class="mf_remove" title="Remove">X</a></label></td>');
			tdlength++;
		}else{
			$('#confirmMemberTr'+trid).append('<td><label id="'+"cm"+id+'" name="confirmMember" value="'+$('#sc'+id).attr("value")+'" style="padding-left:5px;padding-right:5px;background-color:#e8f0f7;border-radius:5px;border:2px solid grey;font-weight:normal;font-size:13px">'+$('#sc'+id).text()+'<a href="javascript:;" onclick="memberRemove('+id+')" class="mf_remove" title="Remove">X</a></label></td>');
			tdlength++;
		}
	}
	
}

function memberRemove(id){
	if($('#scc'+id).length>0){
		$('#scc'+id).click();
	}else{
		
		$('#cm'+id).remove();
	}
	
	$("#confirmMemberTable").find("tr").each(function(){
	    var tdArr = $(this).children(); 
	    var isEmpty = true;
	    for(var i = 0;i<tdArr.length;i++){
	    	if(tdArr.eq(i).text() != "")
	    	{
	    		isEmpty = false;
	    	}
	    }   
	 });
}


function removeGroup(){
	var rows = $('#tt').datagrid('getSelections');
    if(rows.length==0){
         tAlert('信息','请选择数据');
    }else{
    	var idarr = [];
        for(var i=0;i<rows.length;i++)
        {
             idarr.push(rows[i].id);
        }
        var res = idarr.join("|");
        $.messager.confirm('信息','确认删除',function(r){
			if (r){
				//alert(res);
				$.post('communicate/deleteGroup.action',{ids:res},
				function(result){
					if(result.indexOf("\"result\":0")>0){
						//$.messager.alert("信息","删除成功！");
						$('#tt').datagrid('reload'); 
					}
					else{
						$.messager.alert("信息","删除失败，请稍后再试！");
					}
				},"text");
			}
		});
	}
}

function Map() {  
	 var struct = function(key, value) {  
	  this.key = key;  
	  this.value = value;  
	 }  
	   
	 var put = function(key, value){  
	  for (var i = 0; i < this.arr.length; i++) {  
	   if ( this.arr[i].key === key ) {  
	    this.arr[i].value = value;  
	    return;  
	   }  
	  }  
	   this.arr[this.arr.length] = new struct(key, value);  
	 }  
	   
	 var get = function(key) {  
	  for (var i = 0; i < this.arr.length; i++) {  
	   if ( this.arr[i].key === key ) {  
	     return this.arr[i].value;  
	   }  
	  }  
	  return null;  
	 }  
	   
	 var remove = function(key) {  
	  var v;  
	  for (var i = 0; i < this.arr.length; i++) {  
	   v = this.arr.pop();  
	   if ( v.key === key ) {  
	    continue;  
	   }  
	   this.arr.unshift(v);  
	  }  
	 }  
	   
	 var size = function() {  
	  return this.arr.length;  
	 }  
	   
	 var isEmpty = function() {  
	  return this.arr.length <= 0;  
	 }   
	 this.arr = new Array();  
	 this.get = get;  
	 this.put = put;  
	 this.remove = remove;  
	 this.size = size;  
	 this.isEmpty = isEmpty;  
}  



