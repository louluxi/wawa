package com.irandoo.xhep.base.util;

import java.util.List;
/**
 * 分页工具类
 * @author ager
 * @version 1.0
 */
public class Page {
    private int pageSize = 0;
    private int curPage = 1;
    private int rowCount;
    private String pageFoot ="";
    private String pageFootScript;
    private List<?> data;
    //显示前后的数字
    private int num = 5;
    
    public Page()
    {
        
    }
    
    public Page(int pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public Page(int pageSize,int curPage)
    {
        this.pageSize = pageSize;
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return this.rowCount%this.pageSize==0?(this.rowCount/this.pageSize):(this.rowCount/this.pageSize+1);
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getStart() {
        return (this.curPage-1)*this.pageSize;
    }

    public int getEnd() {
        return this.curPage*this.pageSize;
    }
    
    public boolean isFirst() {
        return this.curPage==1?true:false;
    }
    
    public boolean isEnd() {
        return this.curPage==this.getPageCount()?true:false;
    }

    public String getPageFoot() {
        return pageFoot;
        
    }
    
    public String getPageFootScript() {
        return pageFootScript;
        
    }

    public void setPageFoot(String url) {
        StringBuffer sb = new StringBuffer();
        //sb.append("<div class='list_page'>");
        //sb.append("共"+this.getRowCount()+"条记录&nbsp;&nbsp;&nbsp;&nbsp;");
        //sb.append("共"+this.getPageCount()+"页&nbsp;&nbsp;&nbsp;&nbsp;");
        //sb.append("当前第"+this.getCurPage()+"页&nbsp;&nbsp;&nbsp;&nbsp;");
        //sb.append("每页显示"+this.getPageSize()+"条");
        
        if(this.getRowCount()==0)
        {
            return;
        }
        
        if(this.isFirst())
        {
            sb.append("<li><a style='cursor:not-allowed'>首页</a></li>");
            sb.append("<li><a style='cursor:not-allowed'>上一页</a></li>");
        }else{
            sb.append("<li><a href='"+url+"&curPage=1'>首页</a></li>");
            sb.append("<li><a href='"+url+"&curPage="+(this.getCurPage()-1)+"'>上一页</a></li>");
        }
        
        //获取当前页的前10页 最小只能是1
        int startCount = this.getCurPage()-num<1?1:(this.getCurPage()-num);
        //获取当前页的后10页 最大不能超过总页数
        int endCount = this.getCurPage()+num>this.getPageCount()?this.getPageCount():(this.getCurPage()+num);
        
        for(int i=startCount;i<=endCount;i++)
        {
            if(i==this.curPage)
            {   
                if(this.getRowCount()>this.getPageSize())
                {
                    sb.append("<li><a class='select'>"+i+"</a></li>");
                }
                
            }else{
                sb.append("<li><a href='"+url+"&curPage="+i+"'>"+i+"</a></li>");
            }
        }
        
        if(this.isEnd())
        {
            sb.append("<li><a style='cursor:not-allowed'>下一页</a></li>");
            sb.append("<li><a style='cursor:not-allowed'>末页</a></li>");
        }else{
            sb.append("<li><a href='"+url+"&curPage="+(this.getCurPage()+1)+"'>下一页</a></li>");
            sb.append("<li><a href='"+url+"&curPage="+this.getPageCount()+"'>末页</a></li>");
        }
        sb.append("<li class='page_all'>"+this.getCurPage()+"/"+this.getPageCount()+"页</li>");
       
        this.pageFoot = sb.toString();
    }
    
    
    
    
    public void setPageFootScript() {
        StringBuffer sb = new StringBuffer();
        
        if(this.getRowCount()==0)
        {
            return;
        }
        
        if(this.isFirst())
        {
            //sb.append("<li class='list_pon'>首页</li>");
            //sb.append("<li class='list_pn d00'>上一页</li>");
        }else{
            //sb.append("<li><a class='pageUPD' href='"+url+"&curPage=1'></a></li>");
            sb.append("<li><a class='pageUP' href='javascript:void(0);' onclick='toPage("+(this.getCurPage()-1)+")'></a></li>");
        }
        
        //获取当前页的前10页 最小只能是1
        int startCount = this.getCurPage()-num<1?1:(this.getCurPage()-num);
        //获取当前页的后10页 最大不能超过总页数
        int endCount = this.getCurPage()+num>this.getPageCount()?this.getPageCount():(this.getCurPage()+num);
        
        for(int i=startCount;i<=endCount;i++)
        {
            if(i==this.curPage)
            {   
                if(this.getRowCount()>this.getPageSize())
                {
                    sb.append("<li class='current'>"+i+"</li>");
                }
                
            }else{
                sb.append("<li><a href='javascript:void(0);' onclick='toPage("+i+")'>"+i+"</a></li>");
            }
        }
        
        if(this.isEnd())
        {
            //sb.append("<li class='list_pn d00'>下一页</li>");
            //sb.append("<li class='list_pon'>末页</li>");
        }else{
            sb.append("<li><a class='pageDOWN' href='javascript:void(0);' onclick='toPage("+(this.getCurPage()+1)+")'></a></li>");
            //sb.append("<li><a class='pageDOWND' href='"+url+"&curPage="+this.getPageCount()+"'></a></li>");
        }
        ////sb.append("</div>");
        this.pageFootScript = sb.toString();
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
