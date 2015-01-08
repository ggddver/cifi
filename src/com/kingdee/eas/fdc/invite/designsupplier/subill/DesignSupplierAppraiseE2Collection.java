package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierAppraiseE2Collection extends AbstractObjectCollection 
{
    public DesignSupplierAppraiseE2Collection()
    {
        super(DesignSupplierAppraiseE2Info.class);
    }
    public boolean add(DesignSupplierAppraiseE2Info item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierAppraiseE2Collection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierAppraiseE2Info item)
    {
        return removeObject(item);
    }
    public DesignSupplierAppraiseE2Info get(int index)
    {
        return(DesignSupplierAppraiseE2Info)getObject(index);
    }
    public DesignSupplierAppraiseE2Info get(Object key)
    {
        return(DesignSupplierAppraiseE2Info)getObject(key);
    }
    public void set(int index, DesignSupplierAppraiseE2Info item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierAppraiseE2Info item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierAppraiseE2Info item)
    {
        return super.indexOf(item);
    }
}