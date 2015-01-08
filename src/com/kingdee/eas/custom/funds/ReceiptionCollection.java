package com.kingdee.eas.custom.funds;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ReceiptionCollection extends AbstractObjectCollection 
{
    public ReceiptionCollection()
    {
        super(ReceiptionInfo.class);
    }
    public boolean add(ReceiptionInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ReceiptionCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ReceiptionInfo item)
    {
        return removeObject(item);
    }
    public ReceiptionInfo get(int index)
    {
        return(ReceiptionInfo)getObject(index);
    }
    public ReceiptionInfo get(Object key)
    {
        return(ReceiptionInfo)getObject(key);
    }
    public void set(int index, ReceiptionInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ReceiptionInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ReceiptionInfo item)
    {
        return super.indexOf(item);
    }
}