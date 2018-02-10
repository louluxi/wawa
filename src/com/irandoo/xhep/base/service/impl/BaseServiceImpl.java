package com.irandoo.xhep.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.irandoo.xhep.base.mapper.BaseMapper;
import com.irandoo.xhep.base.service.BaseService;

/**
 * 
 * @author ager
 *
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{

    private BaseMapper baseMapper;
    
    protected void setBaseMapper(BaseMapper baseMapper){
        this.baseMapper = baseMapper;
    }
    
    @Override
    public void insert(T t) {
        baseMapper.insert(t);
    }

    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    @Transactional
    public void delete(String ids) {
        List<Long> listid = JSON.parseArray(ids, Long.class);
        for (long id : listid) {
            baseMapper.delete(id);
        }
    }

    @Override
    @Transactional
    public void deleteById(long id) {
       baseMapper.delete(id);
    }
    
    @Override
    public T getInfoById(long id) {
        return baseMapper.getInfoById(id);
    }

    @Override
    public List<T> getAllList(Map<String, Object> map) {
        return baseMapper.getAllList(map);
    }
    
    @Override
    public List<T> getInfoByCode(Map<String, Object> map) {
        return baseMapper.getInfoByCode(map);
    }
    
    @Override
    public String getInfoListStr(Map<String, Object> map) {  
        Map<String, Object> result = new HashMap<String, Object>();
        List<T> list = baseMapper.getInfoList(map);
        int records = baseMapper.getTotalCount(map);
        int rows = (Integer)map.get("rows");
        int total = records%rows == 0 ? records/rows : records/rows + 1;
        result.put("total", total);  		   //总页数
        result.put("page", map.get("page"));   //当前页
        result.put("records", records);		   //总记录数
        result.put("rows", list);
        String json = "";
        try {
            json = JSON.toJSONString(result);
        }
        catch (Exception e) {
        }
        return json;
    }
}
