package com.kingdee.eas.custom.funds;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FundsApplicationBillCollection extends AbstractObjectCollection 
{
    public FundsApplicationBillCollection()
    {
        super(FundsApplicationBillInfo.class);
    }
    public boolean add(FundsApplicationBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FundsApplicationBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FundsApplicationBillInfo item)
    {
        return removeObject(item);
    }
    public FundsApplicationBillInfo get(int index)
    {
        return(FundsApplicationBillInfo)getObject(index);
    }
    public FundsApplicationBillInfo get(Object key)
    {
        return(FundsApplicationBillInfo)getObject(key);
    }
    public void set(int index, FundsApplicationBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FundsApplicationBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FundsApplicationBillInfo item)
    {
        return super.indexOf(item);
    }
}