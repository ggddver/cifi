package com.kingdee.eas.custom.funds;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FundsApplicationEntryCollection extends AbstractObjectCollection 
{
    public FundsApplicationEntryCollection()
    {
        super(FundsApplicationEntryInfo.class);
    }
    public boolean add(FundsApplicationEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FundsApplicationEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FundsApplicationEntryInfo item)
    {
        return removeObject(item);
    }
    public FundsApplicationEntryInfo get(int index)
    {
        return(FundsApplicationEntryInfo)getObject(index);
    }
    public FundsApplicationEntryInfo get(Object key)
    {
        return(FundsApplicationEntryInfo)getObject(key);
    }
    public void set(int index, FundsApplicationEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FundsApplicationEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FundsApplicationEntryInfo item)
    {
        return super.indexOf(item);
    }
}