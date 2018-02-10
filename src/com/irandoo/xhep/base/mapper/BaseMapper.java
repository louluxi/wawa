package com.irandoo.xhep.base.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper
{
    <T> void insert(T t);
    
    <T> void update(T t);
    
    void delete(long id);
    
    <T> T getInfoById(long id);
    
    <T> List<T> getInfoList(Map<String,Object> map);
    
    <T> List<T> getInfoByCode(Map<String,Object> map);
    
    int getTotalCount(Map<String,Object> map);
    
    <T> List<T> getAllList(Map<String,Object> map);
}
