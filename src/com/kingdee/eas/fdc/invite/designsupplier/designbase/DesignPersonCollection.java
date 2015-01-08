package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignPersonCollection extends AbstractObjectCollection 
{
    public DesignPersonCollection()
    {
        super(DesignPersonInfo.class);
    }
    public boolean add(DesignPersonInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignPersonCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignPersonInfo item)
    {
        return removeObject(item);
    }
    public DesignPersonInfo get(int index)
    {
        return(DesignPersonInfo)getObject(index);
    }
    public DesignPersonInfo get(Object key)
    {
        return(DesignPersonInfo)getObject(key);
    }
    public void set(int index, DesignPersonInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignPersonInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignPersonInfo item)
    {
        return super.indexOf(item);
    }
}