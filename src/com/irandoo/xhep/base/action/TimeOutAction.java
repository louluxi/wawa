package com.irandoo.xhep.base.action;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 登陆超时响应类
 * @author ager
 * @version 1.0 
 */
@Controller("timeOut")
@Scope("prototype")
public class TimeOutAction  extends BaseAction
{

    private Log logger = LogFactory.getLog(TimeOutAction.class);
    private static final long serialVersionUID = -2626588203663939532L;
    public String timeOut()
    {
        logger.debug("Enter timeOut()");
        return SUCCESS;
    }
}
