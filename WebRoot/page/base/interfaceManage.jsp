<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>接口管理</title>
    <jsp:include page="../../page/common/taglib.jsp"></jsp:include>
	<script type="text/javascript">
		function startInterface(){
		/* 	$.ajax({  
		        type : "POST",
				url : "purchaseOrder/syncPurchaseOrderData.action",
				dataType : "json",
				success : function(data) {
				}
			}); */
			$.ajax({  
		        type : "POST",
				url : "orderInvoice/syncOrderInvoiceData.action",
				dataType : "json",
				success : function(data) {
				}
			});
		}
	</script>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                     <div class="ibox-title">
                        <button class="btn btn-info " type="button" onclick="startInterface()">运行</button>
                   	 </div>
                    <div class="ibox-content">
                        <div class="jqGrid_wrapper">
                            <table id="table_list_2"></table>
                            <div id="pager_list_2"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
            $.jgrid.defaults.styleUI = 'Bootstrap';
            // Examle data for jqGrid
            var mydata = [
                {
                    id: "1",
                    t1: "ZGYLBJ_GET_BSINFO",
                    t2: "保税基础数据信息获取接口",
                    t3: "JCO",
                    t4: "table",
                },
                {
                    id: "2",
                    t1: "ZGYLBJ_MAT_READ_DATA",
                    t2: "物料主数据信息获取接口",
                    t3: "JCO",
                    t4: "table",
                },
                {
                    id: "3",
                    t1: "ZGYLBJ_MAT_FB_RESULT",
                    t2: "物料主数据信息回写接口",
                    t3: "JCO",
                    t4: "table",
                },
                {
                    id: "4",
                    t1: "ZGYLBJ_EKO_READ_DATA",
                    t2: "采购订单信息获取接口",
                    t3: "JCO",
                    t4: "table",
                },
                {
                    id: "5",
                    t1: "ZGYLBJ_EKO_FB_RESULT",
                    t2: "采购订单信息回写接口",
                    t3: "JCO",
                    t4: "table",
                },
                {
                    id: "6",
                    t1: "ZGYLBJ_RBK_READ_DATA",
                    t2: "采购订单开票信息获取接口",
                    t3: "JCO",
                    t4: "table",
                },
                {
                    id: "7",
                    t1: "ZGYLBJ_RBK_FB_RESULT",
                    t2: "采购订单开票信息回写接口",
                    t3: "JCO",
                    t4: "table",
                }
            ];

            // Configuration for jqGrid Example 2
            $("#table_list_2").jqGrid({
                data: mydata,
                datatype: "local",
                height : "auto",
				autowidth : true,
				multiselect : false,//复选框    
				shrinkToFit : true,
				rowNum : 20,
				rownumbers: true,
				rowList : [ 10, 20, 30],
                colNames: ['序号', '接口编码', '接口名称',  '调用方式', '返回结果'],
                colModel: [
                    {
                        name: 'id',
                        index: 'id',
                        editable: true,
                        width: 30,
                        sorttype: "int",
                        search: true
                    },
                    {
                        name: 't1',
                        index: 't1',
                        editable: true,
                        width: 100
                    },
                    {
                        name: 't2',
                        index: 't2',
                        editable: true,
                        width: 80,
                        sorttype: "string",
                    },
                    {
                        name: 't3',
                        index: 't3',
                        editable: true,
                        width: 90,
                        sorttype: "string",
                    },
                    {
                        name: 't4',
                        index: 't4',
                        editable: true,
                        width: 80,
                        sorttype: "string",
                        formatter: "string"
                    }
                ],
                pager: "#pager_list_2",
                viewrecords: true,
                caption: null,
                hidegrid: false
            	});
			// rownumbers添加序号列列头
			jQuery("#table_list_2").jqGrid('setLabel', 'rn', '序号', {'text-align':'center','padding':'0'});
            // Add responsive to jqGrid
            $(window).bind('resize', function () {
                var width = $('.jqGrid_wrapper').width();
                $('#table_list_2').setGridWidth(width);
            });
        });
    </script>

</body>

</html>

