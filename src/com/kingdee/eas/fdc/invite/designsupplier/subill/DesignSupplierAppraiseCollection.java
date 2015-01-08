package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierAppraiseCollection extends AbstractObjectCollection 
{
    public DesignSupplierAppraiseCollection()
    {
        super(DesignSupplierAppraiseInfo.class);
    }
    public boolean add(DesignSupplierAppraiseInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierAppraiseCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierAppraiseInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierAppraiseInfo get(int index)
    {
        return(DesignSupplierAppraiseInfo)getObject(index);
    }
    public DesignSupplierAppraiseInfo get(Object key)
    {
        return(DesignSupplierAppraiseInfo)getObject(key);
    }
    public void set(int index, DesignSupplierAppraiseInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierAppraiseInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierAppraiseInfo item)
    {
        return super.indexOf(item);
    }
}