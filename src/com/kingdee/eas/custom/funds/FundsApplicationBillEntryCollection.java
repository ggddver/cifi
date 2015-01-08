package com.kingdee.eas.custom.funds;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FundsApplicationBillEntryCollection extends AbstractObjectCollection 
{
    public FundsApplicationBillEntryCollection()
    {
        super(FundsApplicationBillEntryInfo.class);
    }
    public boolean add(FundsApplicationBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FundsApplicationBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FundsApplicationBillEntryInfo item)
    {
        return removeObject(item);
    }
    public FundsApplicationBillEntryInfo get(int index)
    {
        return(FundsApplicationBillEntryInfo)getObject(index);
    }
    public FundsApplicationBillEntryInfo get(Object key)
    {
        return(FundsApplicationBillEntryInfo)getObject(key);
    }
    public void set(int index, FundsApplicationBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FundsApplicationBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FundsApplicationBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}