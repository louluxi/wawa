package com.irandoo.xhep.base.util;

import java.util.ArrayList;
import java.util.List;

public class ResourceUtil {
	private static List<Resource> firstReourceList = new ArrayList<Resource>();
	private static List<Resource> secondReourceList = new ArrayList<Resource>();
	private static List<Resource> thirdReourceList = new ArrayList<Resource>();
	private static List<Resource> urlList = new ArrayList<Resource>();
    private static ResourceUtil resourceUtil = new ResourceUtil();
    public static ResourceUtil getResourceUtil()
    {
        return resourceUtil;
    }
    public ResourceUtil(){
    	setFirstReourceList();
    	setSecondReourceList();
    	setThirdReourceList();
    	setUrlList();
    }
	public String getResourceDataByPid(Long firstId)
    {
		StringBuilder sb = new StringBuilder();
		for(Resource secondResource:secondReourceList){
			if(firstId.equals(secondResource.getParent_id())){
				sb.append("{\"id\":");
				sb.append(secondResource.getId());
				sb.append(",\"text\":");
				sb.append("\"" + secondResource.getResource_name() + "\"");
				sb.append(",\"children\":[");
				for(Resource thirdResource:thirdReourceList)
				{
					if(secondResource.getId().equals(thirdResource.getParent_id())){
						sb.append("{\"id\":");
						sb.append(thirdResource.getId());
						sb.append(",\"text\":");
						sb.append("\"" + thirdResource.getResource_name() + "\"");
						sb.append(",\"children\":[");
						sb.append("]},");
					}
				}
				sb.append("]},");
			}
		}
        String r = ("[" + sb.toString() + "]").replaceAll("\\,]", "\\]");
        return r;
    }
	public List<Resource> getFirstReourceList() {
		return firstReourceList;
	}
	public void setFirstReourceList() {
		Resource resource1 =new Resource();
		resource1.setId(1l);
		resource1.setResource_name("住户管理");
		Resource resource2 =new Resource();
		resource2.setId(2l);
		resource2.setResource_name("分类管理");
		Resource resource3 =new Resource();
		resource3.setId(3l);
		resource3.setResource_name("区域管理");
		Resource resource4 =new Resource();
		resource4.setId(4l);
		resource4.setResource_name("统计管理");
		firstReourceList.add(resource1);
		firstReourceList.add(resource2);
		firstReourceList.add(resource3);
		firstReourceList.add(resource4);
	}
	public List<Resource> getSecondReourceList() {
		return secondReourceList;
	}
	public void setSecondReourceList() {
		Resource resource11 =new Resource();
		resource11.setId(11l);
		resource11.setParent_id(1l);
		resource11.setResource_name("住户管理");
		
		Resource resource21 =new Resource();
		resource21.setId(21l);
		resource21.setParent_id(2l);
		resource21.setResource_name("分类管理");
		
		Resource resource31 =new Resource();
		resource31.setId(31l);
		resource31.setParent_id(3l);
		resource31.setResource_name("区域管理");
		
		Resource resource41 =new Resource();
		resource41.setId(41l);
		resource41.setParent_id(4l);
		resource41.setResource_name("住户分类统计");
		
		Resource resource42 =new Resource();
		resource42.setId(42l);
		resource42.setParent_id(4l);
		resource42.setResource_name("参与人次饼图");
		
		Resource resource43 =new Resource();
		resource43.setId(43l);
		resource43.setParent_id(4l);
		resource43.setResource_name("参与人数饼图");
		
		secondReourceList.add(resource11);
		secondReourceList.add(resource21);
		secondReourceList.add(resource31);
		secondReourceList.add(resource41);
		secondReourceList.add(resource42);
		secondReourceList.add(resource43);
	}
	public List<Resource> getThirdReourceList() {
		return thirdReourceList;
	}
	public String getThirdUrlById(Long thirdId){
		String url ="";
		for(Resource thirdResource:thirdReourceList){
			if(thirdResource.getId() == thirdId){
				url = thirdResource.getUrl();
			}
		}
		return url;
	}
	public void setThirdReourceList() {
//		Resource resource111 =new Resource();
//		resource111.setId(111l);
//		resource111.setParent_id(11l);
//		resource111.setResource_name("用户管理");
//		
//		Resource resource211 =new Resource();
//		resource211.setId(211l);
//		resource211.setParent_id(21l);
//		resource211.setResource_name("启动图片管理");
//		
//		Resource resource221 =new Resource();
//		resource221.setId(221l);
//		resource221.setParent_id(22l);
//		resource221.setResource_name("众筹商铺管理");
//		
//		Resource resource231 =new Resource();
//		resource231.setId(231l);
//		resource231.setParent_id(23l);
//		resource231.setResource_name("活动管理");
//		
//		Resource resource241 =new Resource();
//		resource241.setId(241l);
//		resource241.setParent_id(24l);
//		resource241.setResource_name("记步管理");
//		
//		Resource resource251 =new Resource();
//		resource251.setId(251l);
//		resource251.setParent_id(25l);
//		resource251.setResource_name("数据字典");
//		
//		Resource resource311 =new Resource();
//		resource311.setId(311l);
//		resource311.setParent_id(31l);
//		resource311.setResource_name("城市管理");
//		
//		Resource resource321 =new Resource();
//		resource321.setId(321l);
//		resource321.setParent_id(32l);
//		resource321.setResource_name("商铺管理");
//		
//		Resource resource331 =new Resource();
//		resource331.setId(331l);
//		resource331.setParent_id(33l);
//		resource331.setResource_name("优惠券管理");
//		
//		Resource resource341 =new Resource();
//		resource341.setId(341l);
//		resource341.setParent_id(34l);
//		resource341.setResource_name("商品管理");
//		
//		Resource resource351 =new Resource();
//		resource351.setId(351l);
//		resource351.setParent_id(35l);
//		resource351.setResource_name("评论管理");
//		
//		Resource resource411 =new Resource();
//		resource411.setId(411l);
//		resource411.setParent_id(41l);
//		resource411.setResource_name("品牌管理");
//		
//		Resource resource421 =new Resource();
//		resource421.setId(421l);
//		resource421.setParent_id(32l);
//		resource421.setResource_name("品牌类别");
//		
//		thirdReourceList.add(resource111);
//		thirdReourceList.add(resource211);
//		thirdReourceList.add(resource221);
//		thirdReourceList.add(resource231);
//		thirdReourceList.add(resource241);
//		thirdReourceList.add(resource251);
//		thirdReourceList.add(resource311);
//		thirdReourceList.add(resource321);
//		thirdReourceList.add(resource331);
//		thirdReourceList.add(resource341);
//		thirdReourceList.add(resource351);
//		thirdReourceList.add(resource411);
//		thirdReourceList.add(resource421);
	}
	public List<Resource> getUrlList() {
		return urlList;
	}
	public void setUrlList() {
		Resource resource11 =new Resource();
		resource11.setId(11l);
		resource11.setUrl("../user/toLoadList.action");
		
		Resource resource21 =new Resource();
		resource21.setId(21l);
		resource21.setUrl("../wasteType/toLoadList.action");
		
		Resource resource31 =new Resource();
		resource31.setId(31l);
		resource31.setUrl("../area/toLoadList.action");
		
		Resource resource41 =new Resource();
		resource41.setId(41l);
		resource41.setUrl("../statistics/householdCount.action");
		
		Resource resource42 =new Resource();
		resource42.setId(42l);
		resource42.setUrl("../statistics/toParticipantCount.action");
		
		Resource resource43 =new Resource();
		resource43.setId(43l);
		resource43.setUrl("../statistics/toNumberCount.action");
		
		urlList.add(resource11);
		urlList.add(resource21);
		urlList.add(resource31);
		urlList.add(resource41);
		urlList.add(resource42);
		urlList.add(resource43);
	}
	
}
