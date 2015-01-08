package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierAppraiseEntryCollection extends AbstractObjectCollection 
{
    public DesignSupplierAppraiseEntryCollection()
    {
        super(DesignSupplierAppraiseEntryInfo.class);
    }
    public boolean add(DesignSupplierAppraiseEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierAppraiseEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierAppraiseEntryInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierAppraiseEntryInfo get(int index)
    {
        return(DesignSupplierAppraiseEntryInfo)getObject(index);
    }
    public DesignSupplierAppraiseEntryInfo get(Object key)
    {
        return(DesignSupplierAppraiseEntryInfo)getObject(key);
    }
    public void set(int index, DesignSupplierAppraiseEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierAppraiseEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierAppraiseEntryInfo item)
    {
        return super.indexOf(item);
    }
}