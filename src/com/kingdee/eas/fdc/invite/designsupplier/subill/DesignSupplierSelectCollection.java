package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierSelectCollection extends AbstractObjectCollection 
{
    public DesignSupplierSelectCollection()
    {
        super(DesignSupplierSelectInfo.class);
    }
    public boolean add(DesignSupplierSelectInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierSelectCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierSelectInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierSelectInfo get(int index)
    {
        return(DesignSupplierSelectInfo)getObject(index);
    }
    public DesignSupplierSelectInfo get(Object key)
    {
        return(DesignSupplierSelectInfo)getObject(key);
    }
    public void set(int index, DesignSupplierSelectInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierSelectInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierSelectInfo item)
    {
        return super.indexOf(item);
    }
}