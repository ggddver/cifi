package com.kingdee.eas.custom.funds;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FundsApplicationCollection extends AbstractObjectCollection 
{
    public FundsApplicationCollection()
    {
        super(FundsApplicationInfo.class);
    }
    public boolean add(FundsApplicationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FundsApplicationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FundsApplicationInfo item)
    {
        return removeObject(item);
    }
    public FundsApplicationInfo get(int index)
    {
        return(FundsApplicationInfo)getObject(index);
    }
    public FundsApplicationInfo get(Object key)
    {
        return(FundsApplicationInfo)getObject(key);
    }
    public void set(int index, FundsApplicationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FundsApplicationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FundsApplicationInfo item)
    {
        return super.indexOf(item);
    }
}