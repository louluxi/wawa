package com.irandoo.app.interf.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;

import com.irandoo.app.interf.json.PrivateRoomJson;
import com.irandoo.app.interf.service.PrivateRoomJsonService;
import com.irandoo.app.interf.service.PrivateRoomOnlineJsonService;
import com.irandoo.xhep.anth.util.TimeUtils;
import com.irandoo.xhep.base.util.SpringContextHolder;
/**
 * @description: 检测房间定时任务类
 * 每隔一分钟检测一次所有包房是否超时，超时后就将包房状态改为已结束，
 * 并且将包房内的所有人全部从房间在线人员表中踢出。
 * @author sun
 *
 */
public class DoTimeTasks extends QuartzJobBean{

	
	@SuppressWarnings("unused")
	private int timeout;  	
	
	//调度工厂实例化后，经过timeout时间开始执行调度 
	public void setTimeout(int timeout) { 
	   this.timeout = timeout; 
	} 
	@Transactional
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		PrivateRoomJsonService privateRoomJsonService =	SpringContextHolder.getBean(PrivateRoomJsonService.class);
	    PrivateRoomOnlineJsonService privateRoomOnlineJsonService = SpringContextHolder.getBean(PrivateRoomOnlineJsonService.class);
	    List<PrivateRoomJson> privateRoomJsons = privateRoomJsonService.getExpirationDate();
        for (PrivateRoomJson privateRoomJson : privateRoomJsons) {
        String roomId =	privateRoomJson.getRoomId();//房间id
        
        String roomCode = privateRoomJson.getRoomCode();//房间码
        Date endTime =	privateRoomJson.getEndTime();
        //获取系统当前时间
        Date nowTime=new Date();
      double time= TimeUtils.getTimeDifference(nowTime, endTime);
      if(time>0){//还有剩余时间
     
      }else{
    	  Map<String, Object> sendMap = new HashMap<String, Object>();
    	  if(null != roomCode && !"".equals(roomCode)){
				MqUtil.sendMq(roomCode, "1", sendMap);
			}
          //1.1 修改房间状态为已关闭
    	  privateRoomJson.setStatus("2");
    	  privateRoomJsonService.update(privateRoomJson);	  
          //1.2 清空房间所有在线人员
    	  //1.3   将所有在线人员的人加入历史表  
    	  //1.4 将此房间的在线人员全部清除
    	   privateRoomOnlineJsonService.deleteALLByRoomId(roomId);
        }
      }
	}

}
