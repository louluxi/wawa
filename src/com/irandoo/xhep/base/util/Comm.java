package com.irandoo.xhep.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.huawei.bme.commons.encryption.EncryptTool;

/**
 * 
 * @author ager
 *
 */
public class Comm {
    
    
    public static String [] tType = new String[]{"1","11","16","23"};

    public static String getMsg(String code) {
        String res = "您访问的页面不存在";
        if (StringUtils.isNotEmpty(code)) {
            if ("001".equals(code)) {
                res = "企业用户不能操作";
            }
            else if ("002".equals(code)) {
                res = "个人用户不能操作";
            }
            else if ("003".equals(code)) {
                res = "现场用户不能操作";
            }
            else if ("004".equals(code)) {
                res = "网络用户不能操作";
            }
            else if ("005".equals(code)) {
                res = "对不起，您没有权限访问";
            }
            else {
                res = "您访问的页面不存在";
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        //System.out.println(Comm.getMsg("001"));
        //System.out.println(getVerCode());
        //System.out.println(getUUID());
        //System.out.println( createID(20005));
        //System.out.println( pareseID("GQ9u75z3G4/e6idWQ8DjlQ=="));
        //printWeekdays();
    }
    
    /**
     * 验证码
     * @return
     */
    public static String getVerCode(){
       int num = (int)((Math.random()*9+1)*100000);
       return String.valueOf(num);
    }
    
    public static String getYeadMouth(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(new Date());
     }
    
    public static boolean compareTime(Date d){
        long curTime =  new Date().getTime();
        long dTime = d.getTime();
        //2分钟
        long constant = 2*60*1000;
        //
        if((curTime-dTime)>=constant){
            return true;
        }else{
            return false;
        }
        
    }
    
    public static String getRemoteAddr(HttpServletRequest request)
    {
        String address = request.getHeader("X-Forwarded-For");
        if (address != null && address.length() > 0 && !"unknown".equalsIgnoreCase(address))
        {
            return address;
        }
        address = request.getHeader("X-Real-IP");
        if (address != null && address.length() > 0 && !"unknown".equalsIgnoreCase(address))
        {
            return address;
        }
        return request.getRemoteAddr();
    }
    
    
    
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    private static EncryptTool eTool = new EncryptTool();
    public static String createID(long id){
        String resID = String.valueOf(id);
        return createID(resID);
    }
    
    public static String createID(String id){
        String resID = String.valueOf(id);
        try {
            return eTool.encrypt(resID);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            resID = null;
        }
        return resID;
    }
    
    public static String pareseID(String id){
        try {
            return eTool.parseEncrypt(id);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            id = null;
        }
        return id;
    }
    
    private static final int FIRST_DAY = Calendar.SUNDAY;
    
    public static String [] getWeekdays() {
        Calendar calendar = Calendar.getInstance();
        setToFirstDay(calendar);
        calendar.add(Calendar.DATE, 1);
        String d1 = getDay(calendar);
        
        calendar.add(Calendar.DATE, 5);
        String d2 = getDay(calendar);

        return new String[]{d1,d2};
    }
 
    private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) != FIRST_DAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }
 
    private static String getDay(Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calendar.getTime());
        //System.out.println(dateFormat.format(calendar.getTime()));
    }
    
    public static String getDateStr(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    
    public static String getMixDate(String day){
        
        Calendar aCalendar = Calendar.getInstance();

        aCalendar.setTime(new Date());

        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        
        Date date = new Date();
        try {
            date = DateUtils.parseDate(day, "yyyy-MM-dd");
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
           // e.printStackTrace();
        }

        aCalendar.setTime(date);

        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        
        if(day2 - day1 < 0){
            return "<font color=\"red\">已过期<font>";
        }else{
            return String.valueOf(day2 - day1);
        }

        
    }
    
     public static int getMixDate2(Date date1,Date date2){
        
        Calendar aCalendar = Calendar.getInstance();

        aCalendar.setTime(date1);

        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        
        aCalendar.setTime(date2);

        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        
        return day2 - day1;

        
    }


}
