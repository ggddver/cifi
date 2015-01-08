package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierStockSupplierServiceTypeCollection extends AbstractObjectCollection 
{
    public DesignSupplierStockSupplierServiceTypeCollection()
    {
        super(DesignSupplierStockSupplierServiceTypeInfo.class);
    }
    public boolean add(DesignSupplierStockSupplierServiceTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierStockSupplierServiceTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierStockSupplierServiceTypeInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierStockSupplierServiceTypeInfo get(int index)
    {
        return(DesignSupplierStockSupplierServiceTypeInfo)getObject(index);
    }
    public DesignSupplierStockSupplierServiceTypeInfo get(Object key)
    {
        return(DesignSupplierStockSupplierServiceTypeInfo)getObject(key);
    }
    public void set(int index, DesignSupplierStockSupplierServiceTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierStockSupplierServiceTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierStockSupplierServiceTypeInfo item)
    {
        return super.indexOf(item);
    }
}