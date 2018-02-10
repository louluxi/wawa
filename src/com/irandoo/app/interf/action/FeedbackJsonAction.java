package com.irandoo.app.interf.action;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.app.interf.json.FeedbackJson;
import com.irandoo.app.interf.json.UserJson;
import com.irandoo.app.interf.service.FeedbackJsonService;
import com.irandoo.app.interf.service.UserJsonService;
import com.irandoo.xhep.base.action.BaseAction;
/**
  * <p>Title: 意见反馈接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("feedbackJsonAction")
@Scope("prototype")
public class FeedbackJsonAction extends BaseAction{
	private Log log = LogFactory.getLog(FeedbackJsonAction.class);
	private static final long serialVersionUID = 1L;
	@Autowired
    private FeedbackJsonService feedbackJsonService;
	@Autowired
	private UserJsonService userJsonService;
    
	public String getFeedbackList() {
		return returnJson(feedbackJsonService.getAllList(getInterfMap()), "0", "");
	}
    
	public String createFeedback() {
		String o = request.getParameter("object");
		Map<String, Object> paramObject = (Map<String, Object>) JSON.parse(o);		
		String userId = request.getAttribute("userId")+"";
		UserJson userJson = userJsonService.getInfoById(Long.valueOf(userId));
		FeedbackJson feedbackJson = new FeedbackJson(); 
		feedbackJson.setTitle(paramObject.get("title")+"");
		feedbackJson.setqContent(paramObject.get("qContent")+"");
		feedbackJson.setqCode(userId);
		feedbackJson.setqName(userJson.getNickName());
		String result = "0";
		String errmsg = "";
        try {
        	feedbackJsonService.insert(feedbackJson);
        }
        catch (Exception e) {
        	result = "-1";
        	errmsg = e.getLocalizedMessage();
        }
		return returnJson("", result, errmsg);
	}
}
