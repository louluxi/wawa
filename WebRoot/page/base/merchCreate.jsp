<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>发布消息</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
<link href="css/plugins/summernote/summernote.css" rel="stylesheet">
<link href="css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
<script src="js/plugins/summernote/summernote.min.js"></script>
<script src="js/plugins/summernote/summernote-zh-CN.js"></script>
<script src="js/plugins/suggest/bootstrap-suggest.min.js"></script>
<script src="js/merch.js"></script>
<style type="text/css">
label {
    margin: 0; 
}

.ibox-cont {
    margin-bottom: 1%; 
}
</style>
<script type="text/javascript">
  $(function(){
    $('.date_picker').date_input();
  })
  function sub(){
	  var markupStr = $('#summernote').code();
	  console.log("....."+markupStr);
	  $('#merch_desc').val(markupStr);
	  $('#messageForm').submit();
  }
</script>

</head>
<body class="gray-bg">
    <form id="messageForm" action="merch/saveOrUpdate.action" enctype="multipart/form-data" method="post">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-12">
                <div class="tabs-container">
                    <ul class="nav nav-tabs">
                        <li>
                            <a href="merch/toLoadList.action">商品管理</a>
                        </li>
                        <li class="active">
                            <a href="merch/getInfoById.action?opt=1">${title}</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="panel-body">
                            <div class="ibox-title">
                                <button class="btn btn-success" type="button" onclick="sub()">
                                    <span class="bold">保存</span>
                                </button>
                                <button class="btn btn-warning" onclick="history.go(-1)">
                                    <span class="bold">返 回</span>
                                </button>
                            </div>
                            <div class="ibox-content">
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>批次号：</label>
                                    </div>
                                     <input type="hidden" id="id" name="merch.id" 
                                        value='<s:property value="merch.id"/>'/>
                                    <div class="col-sm-8 input-group">
                                        <input id="batch_num" type="text" name = "merch.batch_num" value='<s:property value="merch.batch_num"/>' 
                                            class="form-control" required="" aria-required="true">
                                    </div>                                     
                                </div>
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>商品类别：</label>
                                    </div>
                                    <div class="col-sm-8 input-group">
                                        <select class="form-control m-b" name="merch.merch_type_id">
                                          <s:iterator value="merchTypeList" var="merchtype">
                                             <option value='<s:property value="#merchtype.id"/>' <s:if test="merch.merch_type_id == #merchtype.id">selected='selected'</s:if>><s:property value="#merchtype.type_name"/></option>
                                          </s:iterator>
                                        </select>
                                    </div>
                                </div>
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>商品名称：</label>
                                    </div>
                                    <div class="col-sm-8 input-group">
                                         <input id="merch_name" name="merch.merch_name"  type="text" value='<s:property value="merch.merch_name"/>' class="form-control" required="" aria-required="true">
                                    </div>
                                </div>
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>商品图片选择：</label>
                                    </div>
                                    <div class="col-sm-8 input-group">
                                        <input type="file" name="uploadfile"  class="form-control"/>
                                    </div>
                                </div>
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>详情图片选择：</label>
                                    </div>
                                    <div class="col-sm-8 input-group">
                                        <input type="file" name="merchDescfile"  class="form-control"/>
                                    </div>
                                </div>
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>商品价格：</label>
                                    </div>
                                    <div class="col-sm-8 input-group">
                                        <div class="input-group-btn">
                                             <input id="price" name="merch.price"  type="text" value='<s:property value="merch.price"/>' class="form-control" required="" aria-required="true">
                                        </div>
                                    </div>
                                </div>
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>商品数量：</label>
                                    </div>
                                    <div class="col-sm-8 input-group">
                                        <div class="input-group-btn">
                                             <input id="merch_num" name="merch.merch_num" type="text" value='<s:property value="merch.merch_num"/>' class="form-control" required="" aria-required="true">
                                        </div>
                                    </div>
                                </div>
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>兑换价：</label>
                                    </div>
                                    <div class="col-sm-8 input-group">
                                        <div class="input-group-btn">
                                             <input id="exchange_coin" name="merch.exchange_coin"  type="text" value='<s:property value="merch.exchange_coin"/>' class="form-control" required="" aria-required="true">
                                        </div>
                                    </div>
                                </div>
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>进货来源：</label>
                                    </div>
                                    <div class="col-sm-8 input-group">
                                        <div class="input-group-btn">
                                             <input id="origin" name="merch.origin"  type="text" value='<s:property value="merch.origin"/>' class="form-control" required="" aria-required="true">
                                        </div>
                                    </div>
                                </div>
                                <div class="ibox-cont">
                                
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>商品状态：</label>
                                    </div>
                                    <div class="col-sm-8 input-group">
                                        <div class="input-group-btn">
                                             <select class="form-control m-b" name="merch.status">
                                                    <s:iterator value="merchStrutsList" var="dict">
                                                        <option value='<s:property value="#dict.dictId"/>' <s:if test="merch.status == #dict.dictId">selected='selected'</s:if>><s:property value="#dict.dictName"/></option>
                                                    </s:iterator>
                                             </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                        <label>采购人：</label>
                                    </div>
                                    <div class="col-sm-8 input-group">
                                        <div class="input-group-btn">
                                             <input id="purchaser" name="merch.purchaser"  type="text" value='<s:property value="merch.purchaser"/>' class="form-control" required="" aria-required="true">
                                        </div>
                                    </div>
                                </div>   
                                <div class="ibox-cont">
                                    <div style="float:left;width:5em;padding-top:0.3em;">
                                       <input id="merch_desc" name="merch_desc"  type="hidden"  class="form-control" required="" aria-required="true">
                                        <label>采购时间：</label>
                                    </div>
                                    <div class="col-sm">
                                           <input  name="merch.purchase_time"  value='<s:property value="merch.purchase_time"/>' style="width:200px; line-height:15px;  display:inline-block" type="text" class="form-control date_picker" id="purchase_time" />
                                    </div>
                                </div>
                                
                                <div class="summernote" id="summernote"   placeholder="请填写信息交流的详情" ><s:property value="merch.merch_desc" escape="false"/></div>
                              
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
</body>
</html>