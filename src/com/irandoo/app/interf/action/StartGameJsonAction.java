package com.irandoo.app.interf.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.app.interf.service.StartGameJsonService;
import com.irandoo.xhep.base.action.BaseAction;

/**
  * <p>Title: 开始游戏接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("gameStartJsonAction")
@Scope("prototype")
public class StartGameJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private StartGameJsonService startGameJsonService;
	/**
	 * errmsg 报错如下：
	 *  E001 - 设备无效
	 *	E002 - 设备正忙
	 *	E003 - 设备故障
	 *	E004 - 操作超时
	 *	E999 - 未知错误
	 * @return
	 */
	public String startGame() {
		Map<String,Object> paramMap = getInterfMap();
		Map<String,Object> map = startGameJsonService.startGame(paramMap);
		if(map == null){
			return returnJson("", "-1", "娃娃币账户余额不足！");
		}else if(null != map.get("errmsg")){
				return returnJson("", "-1", map.get("errmsg")+"");
		}
		return returnJson(map, "0", "");
	}
    
}
