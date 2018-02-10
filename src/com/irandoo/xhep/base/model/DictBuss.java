package com.irandoo.xhep.base.model;

import java.io.Serializable;

/**
 * @author ager
 * @version 1.0 
 */
public class DictBuss implements Serializable
{

	private static final long serialVersionUID = -8857768767305112421L;

	private int id;

    private String dictId;

    private String dictName;

    private int dictType;
    
    private String descript;

    public String getDescript()
    {
        return descript;
    }

    public void setDescript(String descript)
    {
        this.descript = descript;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDictId()
    {
        return dictId;
    }

    public void setDictId(String dictId)
    {
        this.dictId = dictId;
    }

    public String getDictName()
    {
        return dictName;
    }

    public void setDictName(String dictName)
    {
        this.dictName = dictName;
    }

    public int getDictType()
    {
        return dictType;
    }

    public void setDictType(int dictType)
    {
        this.dictType = dictType;
    }
}
