package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierSelectEntryCollection extends AbstractObjectCollection 
{
    public DesignSupplierSelectEntryCollection()
    {
        super(DesignSupplierSelectEntryInfo.class);
    }
    public boolean add(DesignSupplierSelectEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierSelectEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierSelectEntryInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierSelectEntryInfo get(int index)
    {
        return(DesignSupplierSelectEntryInfo)getObject(index);
    }
    public DesignSupplierSelectEntryInfo get(Object key)
    {
        return(DesignSupplierSelectEntryInfo)getObject(key);
    }
    public void set(int index, DesignSupplierSelectEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierSelectEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierSelectEntryInfo item)
    {
        return super.indexOf(item);
    }
}