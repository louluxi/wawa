package com.irandoo.xhep.base.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author ager
 *
 * @param <T>
 */
public interface BaseService<T> {

    void insert(T t);


    void update(T t);


    void delete(String ids);


    T getInfoById(long id);


    String getInfoListStr(Map<String, Object> map);
    
    List<T> getAllList(Map<String, Object> map);


	List<T> getInfoByCode(Map<String, Object> map);


	void deleteById(long id);

}
