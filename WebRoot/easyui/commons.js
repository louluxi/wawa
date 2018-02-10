/**
 * 公共js
 */

/**
 * 警告窗口
 */
function tAlert(title,msg){
	$.messager.alert(title, msg);
}

/**
 * 模块title获取
 * @param title
 * @param opt
 * @returns {String}
 */
function getOptTitle(title,opt){
	switch (opt){
	    case 1:
	      title = '新增'+title;
		  break;
		case 2:
		  title = '修改'+title;
		  break;
		case 3:
		  title = '查看'+title;
	      break;
		default:
	}
	return title;
}

/**
 * 
 * @param $
 */
(function ($) {
	var options = {
			title:'',
			iconCls:'icon-search',
			idField:'id', 
			treeField:'code',
			width:'auto',
			height:'450',
			nowrap: false,
			striped: true,
			url:'getAjaxData.action',
			autoRowHeight:true,
			fitColumns:true,
			frozenColumns:[[
			    {field:'ck',checkbox:true}
	            
			]],
			pagination:true,
			rownumbers:true,
			toolbar:"#tb"
	}
    $.fn.mydatagrid = function (settings) {
        if(settings){
        	$.extend(options, settings);
        }
        $(this).datagrid(options);
    };
    var buttonDir = {north:'down',south:'up',east:'left',west:'right'};
    $.extend($.fn.layout.paneldefaults,{
        onBeforeCollapse:function(){
            /**/
            var popts = $(this).panel('options');
            var dir = popts.region;
            var btnDir = buttonDir[dir];
            if(!btnDir) return false;
 
            setTimeout(function(){
                var pDiv = $('.layout-button-'+btnDir).closest('.layout-expand').css({
                    textAlign:'center',lineHeight:'18px',fontWeight:'bold'
                });
 
                if(popts.title){
                    var vTitle = popts.title;
                    if(dir == "east" || dir == "west"){
                        var vTitle = popts.title.split('').join('<br/>');
                        pDiv.find('.panel-body').html(vTitle);
                    }else{
                        $('.layout-button-'+btnDir).closest('.layout-expand').find('.panel-title')
                        .css({textAlign:'left'})
                        .html(vTitle)
                    }
                }   
            },100);
        }
    });
})(jQuery);

(function ($) {
	var options = {
			title:'',
			iconCls:'icon-search',
			idField:'id', 
			treeField:'code',
			width:'auto',
			height:'450',
			nowrap: false,
			striped: true,
			url:'getAjaxData.action',
			autoRowHeight:true,
			fitColumns:true,
			pagination:true,
			rownumbers:true,
			toolbar:"#tb"
	}
    $.fn.mydatagrid1 = function (settings) {
        if(settings){
        	$.extend(options, settings);
        }
        $(this).datagrid(options);
    };
})(jQuery);



function getLengthUTF8(value)
{
    var length = 0, chcode;
    for(i=0; i < value.length; i++)
    {
       chcode = value.charCodeAt(i);
       length += (chcode >= 0 && chcode <= 255) ? 1 : 3;
    }
    
    return length;
}

$.extend($.fn.validatebox.defaults.rules, {
	    integer:{
	    	validator: function(value){
	    		return /^[0-9]*$/.test(value);
	    	},
	    	message: '请输入整数数字'
	    },
	    lengthUTF:{
	    	validator: function(value, param){
	    		var maxLength = 0;
	    		var minLength = 0;
	    		if ($.isArray(param) && param.length > 1)
	    		{
	    			minLength = param[0];
	    			maxLength = param[1];	
	    		}
	    		
	    		return getLengthUTF8(value) >= minLength && getLengthUTF8(value) <= maxLength;
	    	},
	    	message: '输入内容长度必须介于{0}和{1}之间，数字字母占一个长度，中文占三个长度'
	    },
	    datetimeISO:{
	    	validator: function(value){
	    		return /^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}\s([0-1][0-9]|[2][0-3]):[0-5][0-9]:[0-5][0-9]$/.test(value);
	    	},
	    	message: '请输入合法的日期与时间(yyyy-MM-dd HH:mm:ss)'
	    }
});