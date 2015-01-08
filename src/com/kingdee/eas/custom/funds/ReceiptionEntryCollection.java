package com.kingdee.eas.custom.funds;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ReceiptionEntryCollection extends AbstractObjectCollection 
{
    public ReceiptionEntryCollection()
    {
        super(ReceiptionEntryInfo.class);
    }
    public boolean add(ReceiptionEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ReceiptionEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ReceiptionEntryInfo item)
    {
        return removeObject(item);
    }
    public ReceiptionEntryInfo get(int index)
    {
        return(ReceiptionEntryInfo)getObject(index);
    }
    public ReceiptionEntryInfo get(Object key)
    {
        return(ReceiptionEntryInfo)getObject(key);
    }
    public void set(int index, ReceiptionEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ReceiptionEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ReceiptionEntryInfo item)
    {
        return super.indexOf(item);
    }
}