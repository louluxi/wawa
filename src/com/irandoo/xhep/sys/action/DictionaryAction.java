package com.irandoo.xhep.sys.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.xhep.base.action.BaseAction;
import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.sys.service.DictionaryService;

@Controller("dictionaryAction")
@Scope("prototype")
public class DictionaryAction extends BaseAction {
	
	private static final long serialVersionUID = -1350801866160866958L;
	private Log logger = LogFactory.getLog(DictionaryAction.class);
	@Autowired
	private DictionaryService dictionaryService;
	private Dictionary dictionary;
	
	/**
     * 加载数据
     * @return
     */
    public String getDataByDescript() {
    	String descript = request.getParameter("descript");
    	List<Dictionary> list = dictionaryService.getByDescript(descript);
    	String json = "";
        try {
            json = JSON.toJSONString(list);
        }catch(Exception e){
        	e.printStackTrace();
        }
    	return toJsonData(json);
    }
    
	/**
     * 跳转
     * @return
     */
    public String toLoadList() {
        request.setAttribute("title", "字典");
        return SUCCESS;
    }

    /**
     * 加载数据
     * @return
     */
    public String getAjaxData() {
    	String jsonData = dictionaryService.getInfoListStr(getConditionMap());
    	return toJsonData(jsonData);
    }
    

    /**
     * 保存数据
     * @return
     */
    public String saveOrUpdate() {
        logger.debug("enter saveOrUpdate");
        if(dictionary == null) {
        	dictionary = new Dictionary();
        }
        if(dictionary.getId() == null) {
        	try {
        		dictionaryService.insert(dictionary);
        	}
        	catch(Exception e) {
            	e.printStackTrace();
        	}
        }else {
        	try {
        		dictionaryService.update(dictionary);
        	}
        	catch(Exception e) {
            	e.printStackTrace();
        	}
        }
        logger.debug("exit saveOrUpdate");
        return SUCCESS;
        
    }
    

    /**
     * 查看数据
     * @return
     */
    public String getInfoById() {
        logger.debug("enter getInfoById");
        String id = request.getParameter("id");
        String opt = request.getParameter("opt");
        if(StringUtils.isEmpty(opt)){
            return ERROR;
        }
        //新增页面
        if(ADD.equals(opt)){
        	dictionary = new Dictionary();
        	request.setAttribute("title", "字典新增");
        }
        //修改页面
        else if(UPDATE.equals(opt)){
        	dictionary = dictionaryService.getInfoById(Long.parseLong(id));
        	request.setAttribute("title", "字典修改");
        }
        //查看页面
        else if(VIEW.equals(opt)){
        	dictionary = dictionaryService.getInfoById(Long.parseLong(id));
        	request.setAttribute("title", "键值添加");
        }
        
        else{
        	request.setAttribute("title", "字典新增");
        }
        return SUCCESS;
    }
    
    /**
     * 删除数据
     * @return
     */
    public String delete() {
        logger.debug("enter delete");
        boolean result = true;
        String id = request.getParameter("ids");

        try {
        	dictionaryService.deleteOne(Long.valueOf(id));
        }
        catch (Exception e) {
        	e.printStackTrace();
            result = false;
        }

        logger.debug("exit delete");

        return result(result);
    }

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
    
    
}
