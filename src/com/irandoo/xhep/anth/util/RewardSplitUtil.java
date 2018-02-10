package com.irandoo.xhep.anth.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 奖励分割工具（分割成rewardCoin娃娃币|exerciseCoin练习币）
 * @author sun
 *
 */

public class RewardSplitUtil {
	
     public static Map<String, Object> SplitReward(String value){
    	 Map<String, Object> maps=new HashMap<>();
    	 String str[] = value.split("/");
    	  maps.put("rewardCoin", str[0]);
    	  maps.put("exerciseCoin",str[1]);
    	 return maps;
     }
    
}
